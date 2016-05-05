package com.buss.api.xinji.controller;

import javax.servlet.http.HttpServletRequest;

import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.util.PasswordUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Restful API的Controller.
 * 
 * @author liliming
 */
@Controller
@RequestMapping(value = "/api")
public class ApiRestController {

  @RequestMapping(method = RequestMethod.GET,params="encrypt")
  @ResponseBody
  public AjaxJson encryptPwd(@RequestParam("tel") String phone,@RequestParam("pwd") String password, HttpServletRequest request) {
    AjaxJson j = new AjaxJson();
    //密码加密
    String pString = PasswordUtil.encrypt(password, phone, PasswordUtil.getStaticSalt());
    j.setMsg(pString);
    
    return j;
  }
}
