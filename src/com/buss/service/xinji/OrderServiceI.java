package com.buss.service.xinji;

import java.util.List;
import org.jeecgframework.core.common.service.CommonService;
import com.buss.entity.xinji.OrderEntity;
import com.buss.entity.xinji.OrderItemEntity;

public interface OrderServiceI extends CommonService{

  /**
   * 添加一对多
   * 
   */
  public void addMain(OrderEntity order,
          List<OrderItemEntity> orderItemList) ;
  /**
   * 修改一对多
   * 
   */
  public void updateMain(OrderEntity order,
          List<OrderItemEntity> orderItemList);
  public void delMain (OrderEntity order);
}
