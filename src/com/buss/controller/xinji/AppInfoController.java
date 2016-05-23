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

import com.buss.entity.xinji.AppInfoEntity;
import com.buss.service.xinji.AppInfoServiceI;

/**   
 * @Title: Controller
 * @Description: app信息
 * @author liliming
 * @date 2016-05-23 17:34:28
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/appInfoController")
public class AppInfoController extends BaseController {
  /**
   * Logger for this class
   */
  private static final Logger logger = Logger.getLogger(AppInfoController.class);

  @Autowired
  private AppInfoServiceI appInfoService;
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
   * app信息列表 页面跳转
   * 
   * @return
   */
  @RequestMapping(params = "appInfo")
  public ModelAndView appInfo(HttpServletRequest request) {
    return new ModelAndView("com/buss/xinji/appInfoList");
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
  public void datagrid(AppInfoEntity appInfo,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
    CriteriaQuery cq = new CriteriaQuery(AppInfoEntity.class, dataGrid);
    //查询条件组装器
    org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, appInfo, request.getParameterMap());
    this.appInfoService.getDataGridReturn(cq, true);
    TagUtil.datagrid(response, dataGrid);
  }

  /**
   * 删除app信息
   * 
   * @return
   */
  @RequestMapping(params = "del")
  @ResponseBody
  public AjaxJson del(AppInfoEntity appInfo, HttpServletRequest request) {
    AjaxJson j = new AjaxJson();
    appInfo = systemService.getEntity(AppInfoEntity.class, appInfo.getId());
    message = "app信息删除成功";
    appInfoService.delete(appInfo);
    systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
    
    j.setMsg(message);
    return j;
  }


  /**
   * 添加app信息
   * 
   * @param ids
   * @return
   */
  @RequestMapping(params = "save")
  @ResponseBody
  public AjaxJson save(AppInfoEntity appInfo, HttpServletRequest request) {
    AjaxJson j = new AjaxJson();
    if (StringUtil.isNotEmpty(appInfo.getId())) {
      message = "app信息更新成功";
      AppInfoEntity t = appInfoService.get(AppInfoEntity.class, appInfo.getId());
      try {
        MyBeanUtils.copyBeanNotNull2Bean(appInfo, t);
        appInfoService.saveOrUpdate(t);
        systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
      } catch (Exception e) {
        e.printStackTrace();
        message = "app信息更新失败";
      }
    } else {
      message = "app信息添加成功";
      appInfoService.save(appInfo);
      systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
    }
    j.setMsg(message);
    return j;
  }

  /**
   * app信息列表页面跳转
   * 
   * @return
   */
  @RequestMapping(params = "addorupdate")
  public ModelAndView addorupdate(AppInfoEntity appInfo, HttpServletRequest req) {
    if (StringUtil.isNotEmpty(appInfo.getId())) {
      appInfo = appInfoService.getEntity(AppInfoEntity.class, appInfo.getId());
      req.setAttribute("appInfoPage", appInfo);
    }
    return new ModelAndView("com/buss/xinji/appInfo");
  }
}
