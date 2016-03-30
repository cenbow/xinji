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

import com.buss.entity.xinji.CarRepairCompanyEntity;
import com.buss.service.xinji.CarRepairCompanyServiceI;

/**   
 * @Title: Controller
 * @Description: 汽修公司
 * @author liliming
 * @date 2016-03-30 17:59:59
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/carRepairCompanyController")
public class CarRepairCompanyController extends BaseController {
  /**
   * Logger for this class
   */
  private static final Logger logger = Logger.getLogger(CarRepairCompanyController.class);

  @Autowired
  private CarRepairCompanyServiceI carRepairCompanyService;
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
   * 汽修公司列表 页面跳转
   * 
   * @return
   */
  @RequestMapping(params = "carRepairCompany")
  public ModelAndView carRepairCompany(HttpServletRequest request) {
    return new ModelAndView("com/buss/xinji/carRepairCompanyList");
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
  public void datagrid(CarRepairCompanyEntity carRepairCompany,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
    CriteriaQuery cq = new CriteriaQuery(CarRepairCompanyEntity.class, dataGrid);
    //查询条件组装器
    org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, carRepairCompany, request.getParameterMap());
    this.carRepairCompanyService.getDataGridReturn(cq, true);
    TagUtil.datagrid(response, dataGrid);
  }

  /**
   * 删除汽修公司
   * 
   * @return
   */
  @RequestMapping(params = "del")
  @ResponseBody
  public AjaxJson del(CarRepairCompanyEntity carRepairCompany, HttpServletRequest request) {
    AjaxJson j = new AjaxJson();
    carRepairCompany = systemService.getEntity(CarRepairCompanyEntity.class, carRepairCompany.getId());
    message = "汽修公司删除成功";
    carRepairCompanyService.delete(carRepairCompany);
    systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
    
    j.setMsg(message);
    return j;
  }


  /**
   * 添加汽修公司
   * 
   * @param ids
   * @return
   */
  @RequestMapping(params = "save")
  @ResponseBody
  public AjaxJson save(CarRepairCompanyEntity carRepairCompany, HttpServletRequest request) {
    AjaxJson j = new AjaxJson();
    if (StringUtil.isNotEmpty(carRepairCompany.getId())) {
      message = "汽修公司更新成功";
      CarRepairCompanyEntity t = carRepairCompanyService.get(CarRepairCompanyEntity.class, carRepairCompany.getId());
      try {
        MyBeanUtils.copyBeanNotNull2Bean(carRepairCompany, t);
        carRepairCompanyService.saveOrUpdate(t);
        systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
      } catch (Exception e) {
        e.printStackTrace();
        message = "汽修公司更新失败";
      }
    } else {
      message = "汽修公司添加成功";
      carRepairCompanyService.save(carRepairCompany);
      systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
    }
    j.setMsg(message);
    return j;
  }

  /**
   * 汽修公司列表页面跳转
   * 
   * @return
   */
  @RequestMapping(params = "addorupdate")
  public ModelAndView addorupdate(CarRepairCompanyEntity carRepairCompany, HttpServletRequest req) {
    if (StringUtil.isNotEmpty(carRepairCompany.getId())) {
      carRepairCompany = carRepairCompanyService.getEntity(CarRepairCompanyEntity.class, carRepairCompany.getId());
      req.setAttribute("carRepairCompanyPage", carRepairCompany);
    }
    return new ModelAndView("com/buss/xinji/carRepairCompany");
  }
}
