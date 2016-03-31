package com.buss.service.impl.xinji;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buss.service.xinji.NewsServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("newsService")
@Transactional
public class NewsServiceImpl extends CommonServiceImpl implements NewsServiceI {
  
}