package com.buss.service.impl.xinji;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buss.service.xinji.GovNewsServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("govNewsService")
@Transactional
public class GovNewsServiceImpl extends CommonServiceImpl implements GovNewsServiceI {
  
}