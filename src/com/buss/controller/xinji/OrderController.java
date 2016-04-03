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
import org.jeecgframework.core.util.DateUtils;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.core.util.oConvertUtils;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.buss.entity.xinji.AddressEntity;
import com.buss.entity.xinji.GroupBuyingEntity;
import com.buss.entity.xinji.MembersEntity;
import com.buss.entity.xinji.OrderEntity;
import com.buss.entity.xinji.OrderItemEntity;
import com.buss.page.xinji.OrderPage;
import com.buss.service.xinji.OrderServiceI;
/**   
 * @Title: Controller
 * @Description: 订单
 * @author liliming
 * @date 2016-04-03 17:14:56
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/orderController")
public class OrderController extends BaseController {
  /**
   * Logger for this class
   */
  private static final Logger logger = Logger.getLogger(OrderController.class);

  @Autowired
  private OrderServiceI orderService;
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
   * 订单列表 页面跳转
   * 
   * @return
   */
  @RequestMapping(params = "order")
  public ModelAndView order(HttpServletRequest request) {
    return new ModelAndView("com/buss/xinji/orderList");
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
  public void datagrid(OrderEntity order,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
    CriteriaQuery cq = new CriteriaQuery(OrderEntity.class, dataGrid);
    //查询条件组装器
    org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, order);
    this.orderService.getDataGridReturn(cq, true);
    //遍历设置会员和地址
    List<OrderEntity> cfeList = new ArrayList<OrderEntity>();
    for (Object o : dataGrid.getResults()) {
      if (o instanceof OrderEntity) {
        OrderEntity cfe = (OrderEntity) o;
        if (cfe.getMemberId() != null && !"".equals(cfe.getMemberId())) {
          MembersEntity member = systemService.get(MembersEntity.class, cfe.getMemberId());
          if (member != null) {
            cfe.setMemberName(member.getPhone());
          }
        }
        if (cfe.getAddressId() != null && !"".equals(cfe.getAddressId())) {
          AddressEntity address = systemService.get(AddressEntity.class, cfe.getAddressId());
          if (address != null) {
            cfe.setAddressDetail(oConvertUtils.getString(address.getProvince())+oConvertUtils.getString(address.getCity())+oConvertUtils.getString(address.getDistrict())+oConvertUtils.getString(address.getDetailLocation()));
          }
        }
        
        cfeList.add(cfe);
      }
    }
    
    TagUtil.datagrid(response, dataGrid);
  }

  /**
   * 删除订单
   * 
   * @return
   */
  @RequestMapping(params = "del")
  @ResponseBody
  public AjaxJson del(OrderEntity order, HttpServletRequest request) {
    AjaxJson j = new AjaxJson();
    order = systemService.getEntity(OrderEntity.class, order.getId());
    message = "删除成功";
    orderService.delMain(order);
    systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
    
    j.setMsg(message);
    return j;
  }


  /**
   * 添加订单
   * 
   * @param ids
   * @return
   */
  @RequestMapping(params = "save")
  @ResponseBody
  public AjaxJson save(OrderEntity order,OrderPage orderPage, HttpServletRequest request) {
    List<OrderItemEntity> orderItemList =  orderPage.getOrderItemList();
    AjaxJson j = new AjaxJson();
    if (StringUtil.isNotEmpty(order.getId())) {
      message = "更新成功";
      orderService.updateMain(order, orderItemList);
      systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
    } else {
      message = "添加成功";
      orderService.addMain(order, orderItemList);
      systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
    }
    j.setMsg(message);
    return j;
  }

  /**
   * 订单列表页面跳转
   * 
   * @return
   */
  @RequestMapping(params = "addorupdate")
  public ModelAndView addorupdate(OrderEntity order, HttpServletRequest req) {
    List<MembersEntity> memberList = systemService.getList(MembersEntity.class);
    List<AddressEntity> addressList = systemService.getList(AddressEntity.class);
    List<GroupBuyingEntity> itemList = systemService.getList(GroupBuyingEntity.class);
    req.setAttribute("memberList", memberList);
    req.setAttribute("addressList", addressList);
    req.setAttribute("itemList", itemList);
    
    if (StringUtil.isNotEmpty(order.getId())) {
      order = orderService.getEntity(OrderEntity.class, order.getId());
      if(StringUtil.isNotEmpty(order.getAddressId())) {
        AddressEntity address = systemService.get(AddressEntity.class, order.getAddressId());
        if(address != null) {
          req.setAttribute("addressDetail", oConvertUtils.getString(address.getProvince())+oConvertUtils.getString(address.getCity())+oConvertUtils.getString(address.getDistrict())+oConvertUtils.getString(address.getDetailLocation()));
        }
      }
      req.setAttribute("orderPage", order);
      req.setAttribute("orderCode", order.getOrderCode());
    } else {
      req.setAttribute("orderCode", DateUtils.getDataString(DateUtils.yyyymmddhhmmss)+StringUtil.random(6));
    }
    
    if(req.getParameter("load") != null && req.getParameter("load").equals("detail")) {
      req.setAttribute("isDetail", 1);
    }
    
    return new ModelAndView("com/buss/xinji/order");
  }
  
  
  /**
   * 加载明细列表[商品明细]
   * 
   * @return
   */
  @RequestMapping(params = "orderItemList")
  public ModelAndView orderItemList(OrderEntity order, HttpServletRequest req) {
  
    //===================================================================================
    //获取参数
    Object id0 = order.getId();
    //===================================================================================
    //查询-商品明细
      String hql0 = "from OrderItemEntity where 1 = 1 AND orderId = ? ";
    try{
      List<OrderItemEntity> orderItemEntityList = systemService.findHql(hql0,id0);
      List<GroupBuyingEntity> itemList = systemService.getList(GroupBuyingEntity.class);
      req.setAttribute("orderItemList", orderItemEntityList);
      req.setAttribute("itemList", itemList);
    }catch(Exception e){
      logger.info(e.getMessage());
    }
    return new ModelAndView("com/buss/xinji/orderItemList");
  }
  
  
}
