package com.buss.controller.xinji;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.buss.entity.xinji.GovDepartmentEntity;
import com.buss.entity.xinji.GovNewsCategoryEntity;
import com.buss.service.xinji.GovDepartmentServiceI;

/**   
 * @Title: Controller
 * @Description: 政务部门
 * @author liliming
 * @date 2016-03-30 21:39:08
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/govDepartmentController")
public class GovDepartmentController extends BaseController {
  /**
   * Logger for this class
   */
  private static final Logger logger = Logger.getLogger(GovDepartmentController.class);

  @Autowired
  private GovDepartmentServiceI govDepartmentService;
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
   * 政务部门列表 页面跳转
   * 
   * @return
   */
  @RequestMapping(params = "govDepartment")
  public ModelAndView govDepartment(HttpServletRequest request) {
    return new ModelAndView("com/buss/xinji/govDepartmentList");
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
  public void datagrid(GovDepartmentEntity govDepartment,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
    CriteriaQuery cq = new CriteriaQuery(GovDepartmentEntity.class, dataGrid);
    //查询条件组装器
    org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, govDepartment, request.getParameterMap());
    this.govDepartmentService.getDataGridReturn(cq, true);
    TagUtil.datagrid(response, dataGrid);
  }

  /**
   * 删除政务部门
   * 
   * @return
   */
  @RequestMapping(params = "del")
  @ResponseBody
  public AjaxJson del(GovDepartmentEntity govDepartment, HttpServletRequest request) {
    AjaxJson j = new AjaxJson();
    govDepartment = systemService.getEntity(GovDepartmentEntity.class, govDepartment.getId());
    message = "政务部门删除成功";
    govDepartmentService.delete(govDepartment);
    systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
    
    j.setMsg(message);
    return j;
  }


  /**
   * 添加政务部门
   * 
   * @param ids
   * @return
   */
  @RequestMapping(params = "save")
  @ResponseBody
  public AjaxJson save(GovDepartmentEntity govDepartment, HttpServletRequest request) {
    AjaxJson j = new AjaxJson();
    //获取categoryids
    String[] categoryids = request.getParameterValues("categoryids");
    String cids="";
    for (int i = 0; i < categoryids.length; i++) {
      if(cids.isEmpty()) {
        cids = categoryids[i];
      } else {
        cids += "|"+categoryids[i];
      }
    }
    govDepartment.setCategoryIds(cids);
    
    if (StringUtil.isNotEmpty(govDepartment.getId())) {
      message = "政务部门更新成功";
      GovDepartmentEntity t = govDepartmentService.get(GovDepartmentEntity.class, govDepartment.getId());
      try {
        MyBeanUtils.copyBeanNotNull2Bean(govDepartment, t);
        govDepartmentService.saveOrUpdate(t);
        systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
      } catch (Exception e) {
        e.printStackTrace();
        message = "政务部门更新失败";
      }
    } else {
      message = "政务部门添加成功";
      govDepartmentService.save(govDepartment);
      systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
    }
    j.setMsg(message);
    return j;
  }

  /**
   * 政务部门列表页面跳转
   * 
   * @return
   */
  @RequestMapping(params = "addorupdate")
  public ModelAndView addorupdate(GovDepartmentEntity govDepartment, HttpServletRequest req) {
    if (StringUtil.isNotEmpty(govDepartment.getId())) {
      govDepartment = govDepartmentService.getEntity(GovDepartmentEntity.class, govDepartment.getId());
      req.setAttribute("govDepartmentPage", govDepartment);
    }
    //获取栏目列表
    List<GovNewsCategoryEntity> categoryList = systemService.getList(GovNewsCategoryEntity.class);
    req.setAttribute("categoryList", categoryList);
    
    return new ModelAndView("com/buss/xinji/govDepartment");
  }
}
