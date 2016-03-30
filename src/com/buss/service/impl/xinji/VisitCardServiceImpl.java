package com.buss.service.impl.xinji;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buss.service.xinji.VisitCardServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("visitCardService")
@Transactional
public class VisitCardServiceImpl extends CommonServiceImpl implements VisitCardServiceI {
  
}