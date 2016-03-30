package com.buss.service.impl.xinji;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buss.service.xinji.MembersServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("membersService")
@Transactional
public class MembersServiceImpl extends CommonServiceImpl implements MembersServiceI {
  
}