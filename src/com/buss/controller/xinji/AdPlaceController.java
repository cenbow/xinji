package com.buss.controller.xinji;
import java.util.ArrayList;
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
import org.jeecgframework.web.system.pojo.base.TSRoleUser;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import com.buss.entity.xinji.AdEntity;
import com.buss.entity.xinji.AdPlaceEntity;
import com.buss.service.xinji.AdPlaceServiceI;

/**   
 * @Title: Controller
 * @Description: 广告位管理
 * @author liliming
 * @date 2016-03-29 23:12:13
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/adPlaceController")
public class AdPlaceController extends BaseController {
  /**
   * Logger for this class
   */
  private static final Logger logger = Logger.getLogger(AdPlaceController.class);

  @Autowired
  private AdPlaceServiceI adPlaceService;
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
   * 广告位管理列表 页面跳转
   * 
   * @return
   */
  @RequestMapping(params = "adPlace")
  public ModelAndView adPlace(HttpServletRequest request) {
    return new ModelAndView("com/buss/xinji/adPlaceList");
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
  public void datagrid(AdPlaceEntity adPlace,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
    CriteriaQuery cq = new CriteriaQuery(AdPlaceEntity.class, dataGrid);
    //查询条件组装器
    org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, adPlace, request.getParameterMap());
    this.adPlaceService.getDataGridReturn(cq, true);
    //遍历设置广告位当前广告名称
    List<AdPlaceEntity> cfeList = new ArrayList<AdPlaceEntity>();
    for (Object o : dataGrid.getResults()) {
        if (o instanceof AdPlaceEntity) {
          AdPlaceEntity cfe = (AdPlaceEntity) o;
            if (cfe.getAdId() != null && !"".equals(cfe.getAdId())) {
                AdEntity ad = systemService.get(AdEntity.class, cfe.getAdId());
                if (ad != null) {
                    cfe.setAdTitle(ad.getTitle());
                }
            }
            cfeList.add(cfe);
        }
    }
    
    TagUtil.datagrid(response, dataGrid);
  }

  /**
   * 删除广告位管理
   * 
   * @return
   */
  @RequestMapping(params = "del")
  @ResponseBody
  public AjaxJson del(AdPlaceEntity adPlace, HttpServletRequest request) {
    AjaxJson j = new AjaxJson();
    adPlace = systemService.getEntity(AdPlaceEntity.class, adPlace.getId());
    message = "广告位删除成功";
    adPlaceService.delete(adPlace);
    systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
    
    j.setMsg(message);
    return j;
  }


  /**
   * 添加广告位管理
   * 
   * @param ids
   * @return
   */
  @RequestMapping(params = "save")
  @ResponseBody
  public AjaxJson save(AdPlaceEntity adPlace, HttpServletRequest request) {
    AjaxJson j = new AjaxJson();
    if (StringUtil.isNotEmpty(adPlace.getId())) {
      message = "广告位更新成功";
      AdPlaceEntity t = adPlaceService.get(AdPlaceEntity.class, adPlace.getId());
      try {
        MyBeanUtils.copyBeanNotNull2Bean(adPlace, t);
        adPlaceService.saveOrUpdate(t);
        systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
      } catch (Exception e) {
        e.printStackTrace();
        message = "广告位更新失败";
      }
    } else {
      message = "广告位添加成功";
      adPlaceService.save(adPlace);
      systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
    }
    j.setMsg(message);
    return j;
  }

  /**
   * 广告位管理列表页面跳转
   * 
   * @return
   */
  @RequestMapping(params = "addorupdate")
  public ModelAndView addorupdate(AdPlaceEntity adPlace, HttpServletRequest req) {
    //获取广告列表
    List<AdEntity> adList = systemService.getList(AdEntity.class);
    req.setAttribute("adList", adList);
    
    if (StringUtil.isNotEmpty(adPlace.getId())) {
      adPlace = adPlaceService.getEntity(AdPlaceEntity.class, adPlace.getId());
      req.setAttribute("adPlacePage", adPlace);
    }
    return new ModelAndView("com/buss/xinji/adPlace");
  }
}
