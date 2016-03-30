package com.buss.service.impl.xinji;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buss.service.xinji.DriverCompanyServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("driverCompanyService")
@Transactional
public class DriverCompanyServiceImpl extends CommonServiceImpl implements DriverCompanyServiceI {
  
}