package com.buss.service.impl.xinji;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buss.service.xinji.CarRepairCompanyServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("carRepairCompanyService")
@Transactional
public class CarRepairCompanyServiceImpl extends CommonServiceImpl implements CarRepairCompanyServiceI {
  
}