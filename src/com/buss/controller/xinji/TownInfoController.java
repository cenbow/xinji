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

import com.buss.entity.xinji.TownInfoEntity;
import com.buss.entity.xinji.TownNewsCategoryEntity;
import com.buss.service.xinji.TownInfoServiceI;

/**   
 * @Title: Controller
 * @Description: 乡镇信息
 * @author liliming
 * @date 2016-03-30 21:40:56
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/townInfoController")
public class TownInfoController extends BaseController {
  /**
   * Logger for this class
   */
  private static final Logger logger = Logger.getLogger(TownInfoController.class);

  @Autowired
  private TownInfoServiceI townInfoService;
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
   * 乡镇信息列表 页面跳转
   * 
   * @return
   */
  @RequestMapping(params = "townInfo")
  public ModelAndView townInfo(HttpServletRequest request) {
    return new ModelAndView("com/buss/xinji/townInfoList");
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
  public void datagrid(TownInfoEntity townInfo,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
    CriteriaQuery cq = new CriteriaQuery(TownInfoEntity.class, dataGrid);
    //查询条件组装器
    org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, townInfo, request.getParameterMap());
    this.townInfoService.getDataGridReturn(cq, true);
    TagUtil.datagrid(response, dataGrid);
  }

  /**
   * 删除乡镇信息
   * 
   * @return
   */
  @RequestMapping(params = "del")
  @ResponseBody
  public AjaxJson del(TownInfoEntity townInfo, HttpServletRequest request) {
    AjaxJson j = new AjaxJson();
    townInfo = systemService.getEntity(TownInfoEntity.class, townInfo.getId());
    message = "乡镇信息删除成功";
    townInfoService.delete(townInfo);
    systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
    
    j.setMsg(message);
    return j;
  }


  /**
   * 添加乡镇信息
   * 
   * @param ids
   * @return
   */
  @RequestMapping(params = "save")
  @ResponseBody
  public AjaxJson save(TownInfoEntity townInfo, HttpServletRequest request) {
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
    townInfo.setCategoryIds(cids);
    
    if (StringUtil.isNotEmpty(townInfo.getId())) {
      message = "乡镇信息更新成功";
      TownInfoEntity t = townInfoService.get(TownInfoEntity.class, townInfo.getId());
      try {
        MyBeanUtils.copyBeanNotNull2Bean(townInfo, t);
        townInfoService.saveOrUpdate(t);
        systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
      } catch (Exception e) {
        e.printStackTrace();
        message = "乡镇信息更新失败";
      }
    } else {
      message = "乡镇信息添加成功";
      townInfoService.save(townInfo);
      systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
    }
    j.setMsg(message);
    return j;
  }

  /**
   * 乡镇信息列表页面跳转
   * 
   * @return
   */
  @RequestMapping(params = "addorupdate")
  public ModelAndView addorupdate(TownInfoEntity townInfo, HttpServletRequest req) {
    if (StringUtil.isNotEmpty(townInfo.getId())) {
      townInfo = townInfoService.getEntity(TownInfoEntity.class, townInfo.getId());
      req.setAttribute("townInfoPage", townInfo);
    }
    //获取栏目列表
    List<TownNewsCategoryEntity> categoryList = systemService.getList(TownNewsCategoryEntity.class);
    req.setAttribute("categoryList", categoryList);
    
    return new ModelAndView("com/buss/xinji/townInfo");
  }
}
