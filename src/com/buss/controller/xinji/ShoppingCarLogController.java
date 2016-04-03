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

import com.buss.entity.xinji.GroupBuyingEntity;
import com.buss.entity.xinji.MembersEntity;
import com.buss.entity.xinji.ShoppingCarLogEntity;
import com.buss.service.xinji.ShoppingCarLogServiceI;

/**   
 * @Title: Controller
 * @Description: 购物车记录
 * @author liliming
 * @date 2016-04-03 16:43:42
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/shoppingCarLogController")
public class ShoppingCarLogController extends BaseController {
  /**
   * Logger for this class
   */
  private static final Logger logger = Logger.getLogger(ShoppingCarLogController.class);

  @Autowired
  private ShoppingCarLogServiceI shoppingCarLogService;
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
   * 购物车记录列表 页面跳转
   * 
   * @return
   */
  @RequestMapping(params = "shoppingCarLog")
  public ModelAndView shoppingCarLog(HttpServletRequest request) {
    return new ModelAndView("com/buss/xinji/shoppingCarLogList");
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
  public void datagrid(ShoppingCarLogEntity shoppingCarLog,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
    CriteriaQuery cq = new CriteriaQuery(ShoppingCarLogEntity.class, dataGrid);
    //查询条件组装器
    org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, shoppingCarLog, request.getParameterMap());
    this.shoppingCarLogService.getDataGridReturn(cq, true);
    //遍历设置会员和项目名称
    List<ShoppingCarLogEntity> cfeList = new ArrayList<ShoppingCarLogEntity>();
    for (Object o : dataGrid.getResults()) {
      if (o instanceof ShoppingCarLogEntity) {
        ShoppingCarLogEntity cfe = (ShoppingCarLogEntity) o;
        if (cfe.getMemberId() != null && !"".equals(cfe.getMemberId())) {
          MembersEntity member = systemService.get(MembersEntity.class, cfe.getMemberId());
          if (member != null) {
            cfe.setMemberName(member.getPhone());
          }
        }
        if (cfe.getItemId() != null && !"".equals(cfe.getItemId())) {
          GroupBuyingEntity groupBuying = systemService.get(GroupBuyingEntity.class, cfe.getItemId());
          if (groupBuying != null) {
            cfe.setItemName(groupBuying.getTitle());
          }
        }
        
        cfeList.add(cfe);
      }
    }
    TagUtil.datagrid(response, dataGrid);
  }

  /**
   * 删除购物车记录
   * 
   * @return
   */
  @RequestMapping(params = "del")
  @ResponseBody
  public AjaxJson del(ShoppingCarLogEntity shoppingCarLog, HttpServletRequest request) {
    AjaxJson j = new AjaxJson();
    shoppingCarLog = systemService.getEntity(ShoppingCarLogEntity.class, shoppingCarLog.getId());
    message = "购物车记录删除成功";
    shoppingCarLogService.delete(shoppingCarLog);
    systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
    
    j.setMsg(message);
    return j;
  }


  /**
   * 添加购物车记录
   * 
   * @param ids
   * @return
   */
  @RequestMapping(params = "save")
  @ResponseBody
  public AjaxJson save(ShoppingCarLogEntity shoppingCarLog, HttpServletRequest request) {
    AjaxJson j = new AjaxJson();
    if (StringUtil.isNotEmpty(shoppingCarLog.getId())) {
      message = "购物车记录更新成功";
      ShoppingCarLogEntity t = shoppingCarLogService.get(ShoppingCarLogEntity.class, shoppingCarLog.getId());
      try {
        MyBeanUtils.copyBeanNotNull2Bean(shoppingCarLog, t);
        shoppingCarLogService.saveOrUpdate(t);
        systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
      } catch (Exception e) {
        e.printStackTrace();
        message = "购物车记录更新失败";
      }
    } else {
      message = "购物车记录添加成功";
      shoppingCarLogService.save(shoppingCarLog);
      systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
    }
    j.setMsg(message);
    return j;
  }

  /**
   * 购物车记录列表页面跳转
   * 
   * @return
   */
  @RequestMapping(params = "addorupdate")
  public ModelAndView addorupdate(ShoppingCarLogEntity shoppingCarLog, HttpServletRequest req) {
    List<MembersEntity> memberList = systemService.getList(MembersEntity.class);
    List<GroupBuyingEntity> itemList = systemService.getList(GroupBuyingEntity.class);
    req.setAttribute("memberList", memberList);
    req.setAttribute("itemList", itemList);
    
    if (StringUtil.isNotEmpty(shoppingCarLog.getId())) {
      shoppingCarLog = shoppingCarLogService.getEntity(ShoppingCarLogEntity.class, shoppingCarLog.getId());
      req.setAttribute("shoppingCarLogPage", shoppingCarLog);
    }
    return new ModelAndView("com/buss/xinji/shoppingCarLog");
  }
}
