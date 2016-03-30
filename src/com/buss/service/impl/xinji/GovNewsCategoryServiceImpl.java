package com.buss.service.impl.xinji;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buss.service.xinji.GovNewsCategoryServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("govNewsCategoryService")
@Transactional
public class GovNewsCategoryServiceImpl extends CommonServiceImpl implements GovNewsCategoryServiceI {
  
}