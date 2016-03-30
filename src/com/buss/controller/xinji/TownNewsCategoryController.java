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

import com.buss.entity.xinji.TownNewsCategoryEntity;
import com.buss.service.xinji.TownNewsCategoryServiceI;

/**   
 * @Title: Controller
 * @Description: 乡镇资讯栏目
 * @author liliming
 * @date 2016-03-30 21:41:25
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/townNewsCategoryController")
public class TownNewsCategoryController extends BaseController {
  /**
   * Logger for this class
   */
  private static final Logger logger = Logger.getLogger(TownNewsCategoryController.class);

  @Autowired
  private TownNewsCategoryServiceI townNewsCategoryService;
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
   * 乡镇资讯栏目列表 页面跳转
   * 
   * @return
   */
  @RequestMapping(params = "townNewsCategory")
  public ModelAndView townNewsCategory(HttpServletRequest request) {
    return new ModelAndView("com/buss/xinji/townNewsCategoryList");
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
  public void datagrid(TownNewsCategoryEntity townNewsCategory,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
    CriteriaQuery cq = new CriteriaQuery(TownNewsCategoryEntity.class, dataGrid);
    //查询条件组装器
    org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, townNewsCategory, request.getParameterMap());
    this.townNewsCategoryService.getDataGridReturn(cq, true);
    TagUtil.datagrid(response, dataGrid);
  }

  /**
   * 删除乡镇资讯栏目
   * 
   * @return
   */
  @RequestMapping(params = "del")
  @ResponseBody
  public AjaxJson del(TownNewsCategoryEntity townNewsCategory, HttpServletRequest request) {
    AjaxJson j = new AjaxJson();
    townNewsCategory = systemService.getEntity(TownNewsCategoryEntity.class, townNewsCategory.getId());
    message = "乡镇资讯栏目删除成功";
    townNewsCategoryService.delete(townNewsCategory);
    systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
    
    j.setMsg(message);
    return j;
  }


  /**
   * 添加乡镇资讯栏目
   * 
   * @param ids
   * @return
   */
  @RequestMapping(params = "save")
  @ResponseBody
  public AjaxJson save(TownNewsCategoryEntity townNewsCategory, HttpServletRequest request) {
    AjaxJson j = new AjaxJson();
    if (StringUtil.isNotEmpty(townNewsCategory.getId())) {
      message = "乡镇资讯栏目更新成功";
      TownNewsCategoryEntity t = townNewsCategoryService.get(TownNewsCategoryEntity.class, townNewsCategory.getId());
      try {
        MyBeanUtils.copyBeanNotNull2Bean(townNewsCategory, t);
        townNewsCategoryService.saveOrUpdate(t);
        systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
      } catch (Exception e) {
        e.printStackTrace();
        message = "乡镇资讯栏目更新失败";
      }
    } else {
      message = "乡镇资讯栏目添加成功";
      townNewsCategoryService.save(townNewsCategory);
      systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
    }
    j.setMsg(message);
    return j;
  }

  /**
   * 乡镇资讯栏目列表页面跳转
   * 
   * @return
   */
  @RequestMapping(params = "addorupdate")
  public ModelAndView addorupdate(TownNewsCategoryEntity townNewsCategory, HttpServletRequest req) {
    if (StringUtil.isNotEmpty(townNewsCategory.getId())) {
      townNewsCategory = townNewsCategoryService.getEntity(TownNewsCategoryEntity.class, townNewsCategory.getId());
      req.setAttribute("townNewsCategoryPage", townNewsCategory);
    }
    return new ModelAndView("com/buss/xinji/townNewsCategory");
  }
}
