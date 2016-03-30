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

import com.buss.entity.xinji.GovNewsCategoryEntity;
import com.buss.service.xinji.GovNewsCategoryServiceI;

/**   
 * @Title: Controller
 * @Description: 政务资讯栏目
 * @author liliming
 * @date 2016-03-30 21:39:51
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/govNewsCategoryController")
public class GovNewsCategoryController extends BaseController {
  /**
   * Logger for this class
   */
  private static final Logger logger = Logger.getLogger(GovNewsCategoryController.class);

  @Autowired
  private GovNewsCategoryServiceI govNewsCategoryService;
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
   * 政务资讯栏目列表 页面跳转
   * 
   * @return
   */
  @RequestMapping(params = "govNewsCategory")
  public ModelAndView govNewsCategory(HttpServletRequest request) {
    return new ModelAndView("com/buss/xinji/govNewsCategoryList");
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
  public void datagrid(GovNewsCategoryEntity govNewsCategory,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
    CriteriaQuery cq = new CriteriaQuery(GovNewsCategoryEntity.class, dataGrid);
    //查询条件组装器
    org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, govNewsCategory, request.getParameterMap());
    this.govNewsCategoryService.getDataGridReturn(cq, true);
    TagUtil.datagrid(response, dataGrid);
  }

  /**
   * 删除政务资讯栏目
   * 
   * @return
   */
  @RequestMapping(params = "del")
  @ResponseBody
  public AjaxJson del(GovNewsCategoryEntity govNewsCategory, HttpServletRequest request) {
    AjaxJson j = new AjaxJson();
    govNewsCategory = systemService.getEntity(GovNewsCategoryEntity.class, govNewsCategory.getId());
    message = "政务资讯栏目删除成功";
    govNewsCategoryService.delete(govNewsCategory);
    systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
    
    j.setMsg(message);
    return j;
  }


  /**
   * 添加政务资讯栏目
   * 
   * @param ids
   * @return
   */
  @RequestMapping(params = "save")
  @ResponseBody
  public AjaxJson save(GovNewsCategoryEntity govNewsCategory, HttpServletRequest request) {
    AjaxJson j = new AjaxJson();
    if (StringUtil.isNotEmpty(govNewsCategory.getId())) {
      message = "政务资讯栏目更新成功";
      GovNewsCategoryEntity t = govNewsCategoryService.get(GovNewsCategoryEntity.class, govNewsCategory.getId());
      try {
        MyBeanUtils.copyBeanNotNull2Bean(govNewsCategory, t);
        govNewsCategoryService.saveOrUpdate(t);
        systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
      } catch (Exception e) {
        e.printStackTrace();
        message = "政务资讯栏目更新失败";
      }
    } else {
      message = "政务资讯栏目添加成功";
      govNewsCategoryService.save(govNewsCategory);
      systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
    }
    j.setMsg(message);
    return j;
  }

  /**
   * 政务资讯栏目列表页面跳转
   * 
   * @return
   */
  @RequestMapping(params = "addorupdate")
  public ModelAndView addorupdate(GovNewsCategoryEntity govNewsCategory, HttpServletRequest req) {
    if (StringUtil.isNotEmpty(govNewsCategory.getId())) {
      govNewsCategory = govNewsCategoryService.getEntity(GovNewsCategoryEntity.class, govNewsCategory.getId());
      req.setAttribute("govNewsCategoryPage", govNewsCategory);
    }
    return new ModelAndView("com/buss/xinji/govNewsCategory");
  }
}
