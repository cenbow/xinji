package com.buss.controller.xinji;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.buss.entity.xinji.AddressEntity;
import com.buss.entity.xinji.MembersEntity;
import com.buss.service.xinji.AddressServiceI;

/**   
 * @Title: Controller
 * @Description: 地址
 * @author liliming
 * @date 2016-03-30 17:57:19
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/addressController")
public class AddressController extends BaseController {
  /**
   * Logger for this class
   */
  private static final Logger logger = Logger.getLogger(AddressController.class);

  @Autowired
  private AddressServiceI addressService;
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
   * 地址列表 页面跳转
   * 
   * @return
   */
  @RequestMapping(params = "address")
  public ModelAndView address(HttpServletRequest request) {
    return new ModelAndView("com/buss/xinji/addressList");
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
  public void datagrid(AddressEntity address,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
    CriteriaQuery cq = new CriteriaQuery(AddressEntity.class, dataGrid);
    //查询条件组装器
    org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, address, request.getParameterMap());
    this.addressService.getDataGridReturn(cq, true);
    //遍历设置会员名
    List<AddressEntity> cfeList = new ArrayList<AddressEntity>();
    for (Object o : dataGrid.getResults()) {
        if (o instanceof AddressEntity) {
          AddressEntity cfe = (AddressEntity) o;
            if (cfe.getMemberId() != null && !"".equals(cfe.getMemberId())) {
              MembersEntity m = systemService.get(MembersEntity.class, cfe.getMemberId());
              if (m != null) {
                  cfe.setMemberPhone(m.getPhone());
              }
            }
            cfeList.add(cfe);
        }
    }
    TagUtil.datagrid(response, dataGrid);
  }

  /**
   * 删除地址
   * 
   * @return
   */
  @RequestMapping(params = "del")
  @ResponseBody
  public AjaxJson del(AddressEntity address, HttpServletRequest request) {
    AjaxJson j = new AjaxJson();
    address = systemService.getEntity(AddressEntity.class, address.getId());
    message = "地址删除成功";
    addressService.delete(address);
    systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
    
    j.setMsg(message);
    return j;
  }


  /**
   * 添加地址
   * 
   * @param ids
   * @return
   */
  @RequestMapping(params = "save")
  @ResponseBody
  public AjaxJson save(AddressEntity address, HttpServletRequest request) {
    AjaxJson j = new AjaxJson();
    if (StringUtil.isNotEmpty(address.getId())) {
      message = "地址更新成功";
      AddressEntity t = addressService.get(AddressEntity.class, address.getId());
      try {
        MyBeanUtils.copyBeanNotNull2Bean(address, t);
        addressService.saveOrUpdate(t);
        systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
      } catch (Exception e) {
        e.printStackTrace();
        message = "地址更新失败";
      }
    } else {
      message = "地址添加成功";
      addressService.save(address);
      systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
    }
    j.setMsg(message);
    return j;
  }

  /**
   * 地址列表页面跳转
   * 
   * @return
   */
  @RequestMapping(params = "addorupdate")
  public ModelAndView addorupdate(AddressEntity address, HttpServletRequest req) {
    //获取会员列表
    List<MembersEntity> membersList = systemService.getList(MembersEntity.class);
    req.setAttribute("membersList", membersList);
    
    if (StringUtil.isNotEmpty(address.getId())) {
      address = addressService.getEntity(AddressEntity.class, address.getId());
      req.setAttribute("addressPage", address);
    }
    return new ModelAndView("com/buss/xinji/address");
  }
}
