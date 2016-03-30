package com.buss.service.impl.xinji;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buss.service.xinji.TownNewsServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("townNewsService")
@Transactional
public class TownNewsServiceImpl extends CommonServiceImpl implements TownNewsServiceI {
  
}