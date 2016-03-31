package com.buss.controller.xinji;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
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
import org.jeecgframework.core.util.oConvertUtils;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.pojo.base.TSType;
import org.jeecgframework.web.system.pojo.base.TSTypegroup;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import com.buss.entity.xinji.NewsEntity;
import com.buss.service.xinji.NewsServiceI;

/**   
 * @Title: Controller
 * @Description: 资讯
 * @author liliming
 * @date 2016-03-30 23:28:43
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/newsController")
public class NewsController extends BaseController {
  /**
   * Logger for this class
   */
  private static final Logger logger = Logger.getLogger(NewsController.class);

  @Autowired
  private NewsServiceI newsService;
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
   * 资讯列表 页面跳转
   * 
   * @return
   */
  @RequestMapping(params = "news")
  public ModelAndView news(HttpServletRequest request) {
    String category = oConvertUtils.getString(request.getParameter("category"));
    TSTypegroup newTypes = systemService.getTypeGroup("newsType", "newsType");
    TSType ntype = systemService.getType(category, "newtype", newTypes);
    
    request.setAttribute("category", category);
    request.setAttribute("categoryName", ntype.getTypename());
    
    return new ModelAndView("com/buss/xinji/newsList");
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
  public void datagrid(NewsEntity news,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
    String category = oConvertUtils.getString(request.getParameter("category"));
    CriteriaQuery cq = new CriteriaQuery(NewsEntity.class, dataGrid);
    //查询条件组装器
    org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, news, request.getParameterMap());
    cq.eq("category", category);
    cq.add();
    this.newsService.getDataGridReturn(cq, true);
    TagUtil.datagrid(response, dataGrid);
  }

  /**
   * 删除资讯
   * 
   * @return
   */
  @RequestMapping(params = "del")
  @ResponseBody
  public AjaxJson del(NewsEntity news, HttpServletRequest request) {
    AjaxJson j = new AjaxJson();
    news = systemService.getEntity(NewsEntity.class, news.getId());
    message = "资讯删除成功";
    newsService.delete(news);
    systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
    
    j.setMsg(message);
    return j;
  }


  /**
   * 添加资讯
   * 
   * @param ids
   * @return
   */
  @RequestMapping(params = "save")
  @ResponseBody
  public AjaxJson save(NewsEntity news, HttpServletRequest request) {
    AjaxJson j = new AjaxJson();
    if (StringUtil.isNotEmpty(news.getId())) {
      message = "资讯更新成功";
      NewsEntity t = newsService.get(NewsEntity.class, news.getId());
      try {
        MyBeanUtils.copyBeanNotNull2Bean(news, t);
        newsService.saveOrUpdate(t);
        systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
      } catch (Exception e) {
        e.printStackTrace();
        message = "资讯更新失败";
      }
    } else {
      message = "资讯添加成功";
      newsService.save(news);
      systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
    }
    j.setMsg(message);
    return j;
  }

  /**
   * 资讯列表页面跳转
   * 
   * @return
   */
  @RequestMapping(params = "addorupdate")
  public ModelAndView addorupdate(NewsEntity news, HttpServletRequest req) {
    String category = oConvertUtils.getString(req.getParameter("category"));
    TSTypegroup newTypes = systemService.getTypeGroup("newsType", "newsType");
    TSType ntype = systemService.getType(category, "newtype", newTypes);
    req.setAttribute("category", category);
    req.setAttribute("categoryName", ntype.getTypename());
    
    if (StringUtil.isNotEmpty(news.getId())) {
      news = newsService.getEntity(NewsEntity.class, news.getId());
      req.setAttribute("newsPage", news);
    }
    return new ModelAndView("com/buss/xinji/news");
  }
}
