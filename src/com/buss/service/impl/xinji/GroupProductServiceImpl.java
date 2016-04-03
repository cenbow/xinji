package com.buss.service.impl.xinji;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buss.service.xinji.GroupProductServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("groupProductService")
@Transactional
public class GroupProductServiceImpl extends CommonServiceImpl implements GroupProductServiceI {
  
}