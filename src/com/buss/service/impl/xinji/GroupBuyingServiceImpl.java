package com.buss.service.impl.xinji;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buss.service.xinji.GroupBuyingServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("groupBuyingService")
@Transactional
public class GroupBuyingServiceImpl extends CommonServiceImpl implements GroupBuyingServiceI {
  
}