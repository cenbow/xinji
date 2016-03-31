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
import org.jeecgframework.core.util.oConvertUtils;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.DateUtils;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.PasswordUtil;

import com.buss.entity.xinji.MembersEntity;
import com.buss.service.xinji.MembersServiceI;

/**   
 * @Title: Controller
 * @Description: 会员
 * @author liliming
 * @date 2016-03-30 19:38:43
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/membersController")
public class MembersController extends BaseController {
  /**
   * Logger for this class
   */
  private static final Logger logger = Logger.getLogger(MembersController.class);

  @Autowired
  private MembersServiceI membersService;
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
   * 会员列表 页面跳转
   * 
   * @return
   */
  @RequestMapping(params = "members")
  public ModelAndView members(HttpServletRequest request) {
    return new ModelAndView("com/buss/xinji/membersList");
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
  public void datagrid(MembersEntity members,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
    CriteriaQuery cq = new CriteriaQuery(MembersEntity.class, dataGrid);
    //查询条件组装器
    org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, members, request.getParameterMap());
    this.membersService.getDataGridReturn(cq, true);
    TagUtil.datagrid(response, dataGrid);
  }

  /**
   * 删除会员
   * 
   * @return
   */
  @RequestMapping(params = "del")
  @ResponseBody
  public AjaxJson del(MembersEntity members, HttpServletRequest request) {
    AjaxJson j = new AjaxJson();
    members = systemService.getEntity(MembersEntity.class, members.getId());
    message = "会员删除成功";
    membersService.delete(members);
    systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
    
    j.setMsg(message);
    return j;
  }


  /**
   * 添加会员
   * 
   * @param ids
   * @return
   */
  @RequestMapping(params = "save")
  @ResponseBody
  public AjaxJson save(MembersEntity members, HttpServletRequest request) {
    AjaxJson j = new AjaxJson();
    
    String phone = oConvertUtils.getString(request.getParameter("phone"));
    String password = oConvertUtils.getString(request.getParameter("password"));
    //密码加密
    String pString = PasswordUtil.encrypt(password, phone, PasswordUtil.getStaticSalt());
    members.setPassword(pString);
    
    if (StringUtil.isNotEmpty(members.getId())) {
      message = "会员更新成功";
      MembersEntity t = membersService.get(MembersEntity.class, members.getId());
      try {
        MyBeanUtils.copyBeanNotNull2Bean(members, t);
        membersService.saveOrUpdate(t);
        systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
      } catch (Exception e) {
        e.printStackTrace();
        message = "会员更新失败";
      }
    } else {
      message = "会员添加成功";
      members.setMemberNo("xj_"+DateUtils.getDataString(DateUtils.yyyymmddhhmmss)+StringUtil.random(6));
      membersService.save(members);
      systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
    }
    j.setMsg(message);
    return j;
  }

  /**
   * 会员列表页面跳转
   * 
   * @return
   */
  @RequestMapping(params = "addorupdate")
  public ModelAndView addorupdate(MembersEntity members, HttpServletRequest req) {
    if (StringUtil.isNotEmpty(members.getId())) {
      members = membersService.getEntity(MembersEntity.class, members.getId());
      //密码解密
      String pString = PasswordUtil.decrypt(members.getPassword(), members.getPhone(), PasswordUtil.getStaticSalt());
      req.setAttribute("membersPage", members);
      req.setAttribute("password", pString);
    }
    if(req.getParameter("load") != null && req.getParameter("load").equals("detail")) {
      req.setAttribute("isDetail", 1);
    }
    
    return new ModelAndView("com/buss/xinji/members");
  }
}
