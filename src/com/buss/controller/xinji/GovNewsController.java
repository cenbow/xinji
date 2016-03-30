package com.buss.controller.xinji;
import java.util.ArrayList;
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
import com.buss.entity.xinji.GovNewsEntity;
import com.buss.service.xinji.GovNewsServiceI;

/**   
 * @Title: Controller
 * @Description: 政务资讯
 * @author liliming
 * @date 2016-03-30 21:40:15
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/govNewsController")
public class GovNewsController extends BaseController {
  /**
   * Logger for this class
   */
  private static final Logger logger = Logger.getLogger(GovNewsController.class);

  @Autowired
  private GovNewsServiceI govNewsService;
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
   * 政务资讯列表 页面跳转
   * 
   * @return
   */
  @RequestMapping(params = "govNews")
  public ModelAndView govNews(HttpServletRequest request) {
    return new ModelAndView("com/buss/xinji/govNewsList");
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
  public void datagrid(GovNewsEntity govNews,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
    CriteriaQuery cq = new CriteriaQuery(GovNewsEntity.class, dataGrid);
    //查询条件组装器
    org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, govNews, request.getParameterMap());
    this.govNewsService.getDataGridReturn(cq, true);
    
    //遍历设置部门和栏目名称
    List<GovNewsEntity> cfeList = new ArrayList<GovNewsEntity>();
    for (Object o : dataGrid.getResults()) {
      if (o instanceof GovNewsEntity) {
        GovNewsEntity cfe = (GovNewsEntity) o;
        if (cfe.getGovId() != null && !"".equals(cfe.getGovId())) {
          GovDepartmentEntity gov = systemService.get(GovDepartmentEntity.class, cfe.getGovId());
          if (gov != null) {
            cfe.setGovName(gov.getName());
          }
        }
        if (cfe.getCategoryId() != null && !"".equals(cfe.getCategoryId())) {
          GovNewsCategoryEntity category = systemService.get(GovNewsCategoryEntity.class, cfe.getCategoryId());
          if (category != null) {
            cfe.setCategoryName(category.getName());
          }
        }
        
        cfeList.add(cfe);
      }
    }
    
    TagUtil.datagrid(response, dataGrid);
  }

  /**
   * 删除政务资讯
   * 
   * @return
   */
  @RequestMapping(params = "del")
  @ResponseBody
  public AjaxJson del(GovNewsEntity govNews, HttpServletRequest request) {
    AjaxJson j = new AjaxJson();
    govNews = systemService.getEntity(GovNewsEntity.class, govNews.getId());
    message = "政务资讯删除成功";
    govNewsService.delete(govNews);
    systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
    
    j.setMsg(message);
    return j;
  }


  /**
   * 添加政务资讯
   * 
   * @param ids
   * @return
   */
  @RequestMapping(params = "save")
  @ResponseBody
  public AjaxJson save(GovNewsEntity govNews, HttpServletRequest request) {
    AjaxJson j = new AjaxJson();
    if (StringUtil.isNotEmpty(govNews.getId())) {
      message = "政务资讯更新成功";
      GovNewsEntity t = govNewsService.get(GovNewsEntity.class, govNews.getId());
      try {
        MyBeanUtils.copyBeanNotNull2Bean(govNews, t);
        govNewsService.saveOrUpdate(t);
        systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
      } catch (Exception e) {
        e.printStackTrace();
        message = "政务资讯更新失败";
      }
    } else {
      message = "政务资讯添加成功";
      govNewsService.save(govNews);
      systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
    }
    j.setMsg(message);
    return j;
  }

  /**
   * 政务资讯列表页面跳转
   * 
   * @return
   */
  @RequestMapping(params = "addorupdate")
  public ModelAndView addorupdate(GovNewsEntity govNews, HttpServletRequest req) {
    //获取部门列表
    List<GovDepartmentEntity> govList = systemService.getList(GovDepartmentEntity.class);
    req.setAttribute("govList", govList);
    //获取栏目列表
    List<GovNewsCategoryEntity> categoryList = systemService.getList(GovNewsCategoryEntity.class);
    req.setAttribute("categoryList", categoryList);
    
    if (StringUtil.isNotEmpty(govNews.getId())) {
      govNews = govNewsService.getEntity(GovNewsEntity.class, govNews.getId());
      req.setAttribute("govNewsPage", govNews);
    }
    return new ModelAndView("com/buss/xinji/govNews");
  }
}
