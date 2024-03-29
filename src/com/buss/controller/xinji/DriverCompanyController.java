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

import com.buss.entity.xinji.DriverCompanyEntity;
import com.buss.service.xinji.DriverCompanyServiceI;

/**   
 * @Title: Controller
 * @Description: 代驾公司
 * @author liliming
 * @date 2016-03-30 17:59:23
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/driverCompanyController")
public class DriverCompanyController extends BaseController {
  /**
   * Logger for this class
   */
  private static final Logger logger = Logger.getLogger(DriverCompanyController.class);

  @Autowired
  private DriverCompanyServiceI driverCompanyService;
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
   * 代驾公司列表 页面跳转
   * 
   * @return
   */
  @RequestMapping(params = "driverCompany")
  public ModelAndView driverCompany(HttpServletRequest request) {
    return new ModelAndView("com/buss/xinji/driverCompanyList");
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
  public void datagrid(DriverCompanyEntity driverCompany,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
    CriteriaQuery cq = new CriteriaQuery(DriverCompanyEntity.class, dataGrid);
    //查询条件组装器
    org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, driverCompany, request.getParameterMap());
    this.driverCompanyService.getDataGridReturn(cq, true);
    TagUtil.datagrid(response, dataGrid);
  }

  /**
   * 删除代驾公司
   * 
   * @return
   */
  @RequestMapping(params = "del")
  @ResponseBody
  public AjaxJson del(DriverCompanyEntity driverCompany, HttpServletRequest request) {
    AjaxJson j = new AjaxJson();
    driverCompany = systemService.getEntity(DriverCompanyEntity.class, driverCompany.getId());
    message = "代驾公司删除成功";
    driverCompanyService.delete(driverCompany);
    systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
    
    j.setMsg(message);
    return j;
  }


  /**
   * 添加代驾公司
   * 
   * @param ids
   * @return
   */
  @RequestMapping(params = "save")
  @ResponseBody
  public AjaxJson save(DriverCompanyEntity driverCompany, HttpServletRequest request) {
    AjaxJson j = new AjaxJson();
    if (StringUtil.isNotEmpty(driverCompany.getId())) {
      message = "代驾公司更新成功";
      DriverCompanyEntity t = driverCompanyService.get(DriverCompanyEntity.class, driverCompany.getId());
      try {
        MyBeanUtils.copyBeanNotNull2Bean(driverCompany, t);
        driverCompanyService.saveOrUpdate(t);
        systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
      } catch (Exception e) {
        e.printStackTrace();
        message = "代驾公司更新失败";
      }
    } else {
      message = "代驾公司添加成功";
      driverCompanyService.save(driverCompany);
      systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
    }
    j.setMsg(message);
    return j;
  }

  /**
   * 代驾公司列表页面跳转
   * 
   * @return
   */
  @RequestMapping(params = "addorupdate")
  public ModelAndView addorupdate(DriverCompanyEntity driverCompany, HttpServletRequest req) {
    if (StringUtil.isNotEmpty(driverCompany.getId())) {
      driverCompany = driverCompanyService.getEntity(DriverCompanyEntity.class, driverCompany.getId());
      req.setAttribute("driverCompanyPage", driverCompany);
    }
    return new ModelAndView("com/buss/xinji/driverCompany");
  }
}
