package com.buss.controller.xinji;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import com.buss.entity.xinji.GroupBuyingEntity;
import com.buss.service.xinji.GroupBuyingServiceI;

/**   
 * @Title: Controller
 * @Description: 团购
 * @author liliming
 * @date 2016-04-01 13:57:18
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/groupBuyingController")
public class GroupBuyingController extends BaseController {
  /**
   * Logger for this class
   */
  private static final Logger logger = Logger.getLogger(GroupBuyingController.class);

  @Autowired
  private GroupBuyingServiceI groupBuyingService;
  @Autowired
  private SystemService systemService;
  private String message;
  
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }


  /**
   * 团购列表 页面跳转
   * 
   * @return
   */
  @RequestMapping(params = "groupBuying")
  public ModelAndView groupBuying(HttpServletRequest request) {
    return new ModelAndView("com/buss/xinji/groupBuyingList");
  }

  /**
   * easyui AJAX请求数据
   * 
   * @param request
   * @param response
   * @param dataGrid
   * @param user
   */

  @RequestMapping(params = "datagrid")
  public void datagrid(GroupBuyingEntity groupBuying,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
    CriteriaQuery cq = new CriteriaQuery(GroupBuyingEntity.class, dataGrid);
    //查询条件组装器
    org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, groupBuying, request.getParameterMap());
    this.groupBuyingService.getDataGridReturn(cq, true);
    TagUtil.datagrid(response, dataGrid);
  }

  /**
   * 删除团购
   * 
   * @return
   */
  @RequestMapping(params = "del")
  @ResponseBody
  public AjaxJson del(GroupBuyingEntity groupBuying, HttpServletRequest request) {
    AjaxJson j = new AjaxJson();
    groupBuying = systemService.getEntity(GroupBuyingEntity.class, groupBuying.getId());
    message = "团购删除成功";
    groupBuyingService.delete(groupBuying);
    systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
    
    j.setMsg(message);
    return j;
  }


  /**
   * 添加团购
   * 
   * @param ids
   * @return
   */
  @RequestMapping(params = "save")
  @ResponseBody
  public AjaxJson save(GroupBuyingEntity groupBuying, HttpServletRequest request) {
    AjaxJson j = new AjaxJson();
    if (StringUtil.isNotEmpty(groupBuying.getId())) {
      message = "团购更新成功";
      GroupBuyingEntity t = groupBuyingService.get(GroupBuyingEntity.class, groupBuying.getId());
      try {
        MyBeanUtils.copyBeanNotNull2Bean(groupBuying, t);
        groupBuyingService.saveOrUpdate(t);
        systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
      } catch (Exception e) {
        e.printStackTrace();
        message = "团购更新失败";
      }
    } else {
      message = "团购添加成功";
      groupBuyingService.save(groupBuying);
      systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
    }
    j.setMsg(message);
    return j;
  }

  /**
   * 团购列表页面跳转
   * 
   * @return
   */
  @RequestMapping(params = "addorupdate")
  public ModelAndView addorupdate(GroupBuyingEntity groupBuying, HttpServletRequest req) {
    if (StringUtil.isNotEmpty(groupBuying.getId())) {
      groupBuying = groupBuyingService.getEntity(GroupBuyingEntity.class, groupBuying.getId());
      req.setAttribute("groupBuyingPage", groupBuying);
    }
    return new ModelAndView("com/buss/xinji/groupBuying");
  }
}
