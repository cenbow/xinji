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

import com.buss.entity.xinji.BusinessActivityEntity;
import com.buss.service.xinji.BusinessActivityServiceI;

/**   
 * @Title: Controller
 * @Description: 商业活动
 * @author liliming
 * @date 2016-03-30 17:58:01
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/businessActivityController")
public class BusinessActivityController extends BaseController {
  /**
   * Logger for this class
   */
  private static final Logger logger = Logger.getLogger(BusinessActivityController.class);

  @Autowired
  private BusinessActivityServiceI businessActivityService;
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
   * 商业活动列表 页面跳转
   * 
   * @return
   */
  @RequestMapping(params = "businessActivity")
  public ModelAndView businessActivity(HttpServletRequest request) {
    return new ModelAndView("com/buss/xinji/businessActivityList");
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
  public void datagrid(BusinessActivityEntity businessActivity,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
    CriteriaQuery cq = new CriteriaQuery(BusinessActivityEntity.class, dataGrid);
    //查询条件组装器
    org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, businessActivity, request.getParameterMap());
    this.businessActivityService.getDataGridReturn(cq, true);
    TagUtil.datagrid(response, dataGrid);
  }

  /**
   * 删除商业活动
   * 
   * @return
   */
  @RequestMapping(params = "del")
  @ResponseBody
  public AjaxJson del(BusinessActivityEntity businessActivity, HttpServletRequest request) {
    AjaxJson j = new AjaxJson();
    businessActivity = systemService.getEntity(BusinessActivityEntity.class, businessActivity.getId());
    message = "商业活动删除成功";
    businessActivityService.delete(businessActivity);
    systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
    
    j.setMsg(message);
    return j;
  }


  /**
   * 添加商业活动
   * 
   * @param ids
   * @return
   */
  @RequestMapping(params = "save")
  @ResponseBody
  public AjaxJson save(BusinessActivityEntity businessActivity, HttpServletRequest request) {
    AjaxJson j = new AjaxJson();
    if (StringUtil.isNotEmpty(businessActivity.getId())) {
      message = "商业活动更新成功";
      BusinessActivityEntity t = businessActivityService.get(BusinessActivityEntity.class, businessActivity.getId());
      try {
        MyBeanUtils.copyBeanNotNull2Bean(businessActivity, t);
        businessActivityService.saveOrUpdate(t);
        systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
      } catch (Exception e) {
        e.printStackTrace();
        message = "商业活动更新失败";
      }
    } else {
      message = "商业活动添加成功";
      businessActivityService.save(businessActivity);
      systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
    }
    j.setMsg(message);
    return j;
  }

  /**
   * 商业活动列表页面跳转
   * 
   * @return
   */
  @RequestMapping(params = "addorupdate")
  public ModelAndView addorupdate(BusinessActivityEntity businessActivity, HttpServletRequest req) {
    if (StringUtil.isNotEmpty(businessActivity.getId())) {
      businessActivity = businessActivityService.getEntity(BusinessActivityEntity.class, businessActivity.getId());
      req.setAttribute("businessActivityPage", businessActivity);
    }
    return new ModelAndView("com/buss/xinji/businessActivity");
  }
}
