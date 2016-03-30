package com.buss.service.impl.xinji;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buss.service.xinji.AddressServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("addressService")
@Transactional
public class AddressServiceImpl extends CommonServiceImpl implements AddressServiceI {
  
}