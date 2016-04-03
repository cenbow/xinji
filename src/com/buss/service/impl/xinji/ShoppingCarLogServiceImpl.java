package com.buss.service.impl.xinji;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buss.service.xinji.ShoppingCarLogServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("shoppingCarLogService")
@Transactional
public class ShoppingCarLogServiceImpl extends CommonServiceImpl implements ShoppingCarLogServiceI {
  
}