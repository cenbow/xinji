package com.buss.service.impl.xinji;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buss.service.xinji.AppInfoServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("appInfoService")
@Transactional
public class AppInfoServiceImpl extends CommonServiceImpl implements AppInfoServiceI {
  
}