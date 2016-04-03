package com.buss.service.impl.xinji;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import com.buss.service.xinji.OrderServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.util.MyBeanUtils;
import com.buss.entity.xinji.OrderEntity;
import com.buss.entity.xinji.OrderItemEntity;
@Service("orderService")
@Transactional
public class OrderServiceImpl extends CommonServiceImpl implements OrderServiceI {

  
  public void addMain(OrderEntity order,
          List<OrderItemEntity> orderItemList){
      //保存主信息
      this.save(order);
    
      /**保存-商品明细*/
      for(OrderItemEntity orderItem:orderItemList){
        //外键设置
        orderItem.setOrderId(order.getId());
        orderItem.setMemberId(order.getMemberId());
        this.save(orderItem);
      }
  }

  
  public void updateMain(OrderEntity order,
          List<OrderItemEntity> orderItemList) {
    //保存订单主信息
    this.saveOrUpdate(order);
    
    
    //===================================================================================
    //获取参数
    Object id0 = order.getId();
    //===================================================================================
    //1.查询出数据库的明细数据-商品明细
      String hql0 = "from OrderItemEntity where 1 = 1 AND orderId = ? ";
      List<OrderItemEntity> orderItemOldList = this.findHql(hql0,id0);
    //2.筛选更新明细数据-商品明细
    for(OrderItemEntity oldE:orderItemOldList){
      boolean isUpdate = false;
        for(OrderItemEntity sendE:orderItemList){
          //需要更新的明细数据-商品明细
          if(oldE.getId().equals(sendE.getId())){
              try {
              MyBeanUtils.copyBeanNotNull2Bean(sendE,oldE);
              this.saveOrUpdate(oldE);
            } catch (Exception e) {
              e.printStackTrace();
              throw new BusinessException(e.getMessage());
            }
            isUpdate= true;
              break;
            }
          }
          if(!isUpdate){
            //如果数据库存在的明细，前台没有传递过来则是删除-商品明细
            super.delete(oldE);
          }
          
      }
    //3.持久化新增的数据-商品明细
    for(OrderItemEntity orderItem:orderItemList){
      if(orderItem.getId()==null){
        //外键设置
        orderItem.setOrderId(order.getId());
        this.save(orderItem);
      }
    }
    
  }

  
  public void delMain(OrderEntity order) {
    //删除主表信息
    this.delete(order);
    
    //===================================================================================
    //获取参数
    Object id0 = order.getId();
    //===================================================================================
    //删除-商品明细
      String hql0 = "from OrderItemEntity where 1 = 1 AND orderId = ? ";
      List<OrderItemEntity> orderItemOldList = this.findHql(hql0,id0);
    this.deleteAllEntitie(orderItemOldList);
  }
  
}