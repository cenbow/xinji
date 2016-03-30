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

import com.buss.entity.xinji.TownInfoEntity;
import com.buss.entity.xinji.TownNewsCategoryEntity;
import com.buss.entity.xinji.TownNewsEntity;
import com.buss.service.xinji.TownNewsServiceI;

/**   
 * @Title: Controller
 * @Description: 乡镇资讯
 * @author liliming
 * @date 2016-03-30 21:41:43
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/townNewsController")
public class TownNewsController extends BaseController {
  /**
   * Logger for this class
   */
  private static final Logger logger = Logger.getLogger(TownNewsController.class);

  @Autowired
  private TownNewsServiceI townNewsService;
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
   * 乡镇资讯列表 页面跳转
   * 
   * @return
   */
  @RequestMapping(params = "townNews")
  public ModelAndView townNews(HttpServletRequest request) {
    return new ModelAndView("com/buss/xinji/townNewsList");
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
  public void datagrid(TownNewsEntity townNews,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
    CriteriaQuery cq = new CriteriaQuery(TownNewsEntity.class, dataGrid);
    //查询条件组装器
    org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, townNews, request.getParameterMap());
    this.townNewsService.getDataGridReturn(cq, true);
    
    //遍历设置乡镇和栏目名称
    List<TownNewsEntity> cfeList = new ArrayList<TownNewsEntity>();
    for (Object o : dataGrid.getResults()) {
      if (o instanceof TownNewsEntity) {
        TownNewsEntity cfe = (TownNewsEntity) o;
        if (cfe.getTownId() != null && !"".equals(cfe.getTownId())) {
          TownInfoEntity town = systemService.get(TownInfoEntity.class, cfe.getTownId());
          if (town != null) {
            cfe.setTownName(town.getName());
          }
        }
        if (cfe.getCategoryId() != null && !"".equals(cfe.getCategoryId())) {
          TownNewsCategoryEntity category = systemService.get(TownNewsCategoryEntity.class, cfe.getCategoryId());
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
   * 删除乡镇资讯
   * 
   * @return
   */
  @RequestMapping(params = "del")
  @ResponseBody
  public AjaxJson del(TownNewsEntity townNews, HttpServletRequest request) {
    AjaxJson j = new AjaxJson();
    townNews = systemService.getEntity(TownNewsEntity.class, townNews.getId());
    message = "乡镇资讯删除成功";
    townNewsService.delete(townNews);
    systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
    
    j.setMsg(message);
    return j;
  }


  /**
   * 添加乡镇资讯
   * 
   * @param ids
   * @return
   */
  @RequestMapping(params = "save")
  @ResponseBody
  public AjaxJson save(TownNewsEntity townNews, HttpServletRequest request) {
    AjaxJson j = new AjaxJson();
    if (StringUtil.isNotEmpty(townNews.getId())) {
      message = "乡镇资讯更新成功";
      TownNewsEntity t = townNewsService.get(TownNewsEntity.class, townNews.getId());
      try {
        MyBeanUtils.copyBeanNotNull2Bean(townNews, t);
        townNewsService.saveOrUpdate(t);
        systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
      } catch (Exception e) {
        e.printStackTrace();
        message = "乡镇资讯更新失败";
      }
    } else {
      message = "乡镇资讯添加成功";
      townNewsService.save(townNews);
      systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
    }
    j.setMsg(message);
    return j;
  }

  /**
   * 乡镇资讯列表页面跳转
   * 
   * @return
   */
  @RequestMapping(params = "addorupdate")
  public ModelAndView addorupdate(TownNewsEntity townNews, HttpServletRequest req) {
    //获取乡镇列表
    List<TownInfoEntity> townList = systemService.getList(TownInfoEntity.class);
    req.setAttribute("townList", townList);
    //获取栏目列表
    List<TownNewsCategoryEntity> categoryList = systemService.getList(TownNewsCategoryEntity.class);
    req.setAttribute("categoryList", categoryList);
    
    if (StringUtil.isNotEmpty(townNews.getId())) {
      townNews = townNewsService.getEntity(TownNewsEntity.class, townNews.getId());
      req.setAttribute("townNewsPage", townNews);
    }
    return new ModelAndView("com/buss/xinji/townNews");
  }
}
