package com.buss.controller.xinji;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import com.buss.entity.xinji.AdEntity;
import com.buss.service.xinji.AdServiceI;

/**   
 * @Title: Controller
 * @Description: 广告信息管理
 * @author liliming
 * @date 2016-03-25 00:35:39
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/adController")
public class AdController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(AdController.class);

	@Autowired
	private AdServiceI adService;
	@Autowired
	private SystemService systemService;
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	/**
	 * 广告信息管理列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "ad")
	public ModelAndView ad(HttpServletRequest request) {
		return new ModelAndView("com/buss/xinji/adList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(AdEntity ad,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(AdEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, ad, request.getParameterMap());
		this.adService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除广告信息管理
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(AdEntity ad, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		ad = systemService.getEntity(AdEntity.class, ad.getId());
		message = "广告信息删除成功";
		adService.delete(ad);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加广告信息管理
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(AdEntity ad, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(ad.getId())) {
			message = "广告信息管理更新成功";
			AdEntity t = adService.get(AdEntity.class, ad.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(ad, t);
				adService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "广告信息更新失败";
			}
		} else {
			message = "广告信息添加成功";
			adService.save(ad);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 广告信息管理列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(AdEntity ad, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(ad.getId())) {
			ad = adService.getEntity(AdEntity.class, ad.getId());
			req.setAttribute("adPage", ad);
		}
		return new ModelAndView("com/buss/xinji/ad");
	}
}
