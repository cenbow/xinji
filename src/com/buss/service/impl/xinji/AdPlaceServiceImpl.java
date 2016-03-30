package com.buss.service.impl.xinji;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buss.service.xinji.AdPlaceServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("adPlaceService")
@Transactional
public class AdPlaceServiceImpl extends CommonServiceImpl implements AdPlaceServiceI {
	
}