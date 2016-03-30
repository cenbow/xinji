package com.buss.service.impl.xinji;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buss.service.xinji.TownInfoServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("townInfoService")
@Transactional
public class TownInfoServiceImpl extends CommonServiceImpl implements TownInfoServiceI {
  
}