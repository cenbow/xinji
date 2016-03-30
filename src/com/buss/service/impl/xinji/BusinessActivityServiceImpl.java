package com.buss.service.impl.xinji;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buss.service.xinji.BusinessActivityServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("businessActivityService")
@Transactional
public class BusinessActivityServiceImpl extends CommonServiceImpl implements BusinessActivityServiceI {
  
}