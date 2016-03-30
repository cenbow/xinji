package com.buss.service.impl.xinji;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buss.service.xinji.AdServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("adService")
@Transactional
public class AdServiceImpl extends CommonServiceImpl implements AdServiceI {
	
}