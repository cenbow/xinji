package com.buss.service.impl.xinji;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buss.service.xinji.GovDepartmentServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("govDepartmentService")
@Transactional
public class GovDepartmentServiceImpl extends CommonServiceImpl implements GovDepartmentServiceI {
  
}