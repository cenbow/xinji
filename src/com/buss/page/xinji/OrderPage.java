package com.buss.page.xinji;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.buss.entity.xinji.OrderItemEntity;

/**   
 * @Description: 订单
 * @author liliming
 * @date 2016-04-03 17:14:57
 * @version V1.0   
 *
 */
@SuppressWarnings("serial")
public class OrderPage implements java.io.Serializable {
  /**保存-商品明细*/
  private List<OrderItemEntity> orderItemList = new ArrayList<OrderItemEntity>();
  
  public List<OrderItemEntity> getOrderItemList() {
    return orderItemList;
  }
  public void setOrderItemList(List<OrderItemEntity> orderItemList) {
    this.orderItemList = orderItemList;
  }
}
