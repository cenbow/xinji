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
import org.jeecgframework.core.util.oConvertUtils;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.buss.entity.xinji.GroupProductEntity;
import com.buss.entity.xinji.ProductEntity;
import com.buss.service.xinji.GroupProductServiceI;

/**   
 * @Title: Controller
 * @Description: 团购商品
 * @author liliming
 * @date 2016-04-02 22:58:12
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/groupProductController")
public class GroupProductController extends BaseController {
  /**
   * Logger for this class
   */
  private static final Logger logger = Logger.getLogger(GroupProductController.class);

  @Autowired
  private GroupProductServiceI groupProductService;
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
   * 团购商品列表 页面跳转
   * 
   * @return
   */
  @RequestMapping(params = "groupProduct")
  public ModelAndView groupProduct(HttpServletRequest request) {
    String groupId = oConvertUtils.getString(request.getParameter("groupid"));
    request.setAttribute("groupid", groupId);
    return new ModelAndView("com/buss/xinji/groupProductList");
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
  public void datagrid(GroupProductEntity groupProduct,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
    String groupId = oConvertUtils.getString(request.getParameter("groupid"));
    CriteriaQuery cq = new CriteriaQuery(GroupProductEntity.class, dataGrid);
    //查询条件组装器
    org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, groupProduct, request.getParameterMap());
    cq.eq("groupId", groupId);
    cq.add();
    this.groupProductService.getDataGridReturn(cq, true);
    
    //遍历设置商品名称
    List<GroupProductEntity> cfeList = new ArrayList<GroupProductEntity>();
    for (Object o : dataGrid.getResults()) {
      if (o instanceof GroupProductEntity) {
        GroupProductEntity cfe = (GroupProductEntity) o;
        if (cfe.getProductId() != null && !"".equals(cfe.getProductId())) {
          ProductEntity product = systemService.get(ProductEntity.class, cfe.getProductId());
          if (product != null) {
            cfe.setProductName(product.getName());
          }
        }
        
        cfeList.add(cfe);
      }
    }
    
    TagUtil.datagrid(response, dataGrid);
  }

  /**
   * 删除团购商品
   * 
   * @return
   */
  @RequestMapping(params = "del")
  @ResponseBody
  public AjaxJson del(GroupProductEntity groupProduct, HttpServletRequest request) {
    AjaxJson j = new AjaxJson();
    groupProduct = systemService.getEntity(GroupProductEntity.class, groupProduct.getId());
    message = "团购商品删除成功";
    groupProductService.delete(groupProduct);
    systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
    
    j.setMsg(message);
    return j;
  }


  /**
   * 添加团购商品
   * 
   * @param ids
   * @return
   */
  @RequestMapping(params = "save")
  @ResponseBody
  public AjaxJson save(GroupProductEntity groupProduct, HttpServletRequest request) {
    AjaxJson j = new AjaxJson();
    if (StringUtil.isNotEmpty(groupProduct.getId())) {
      message = "团购商品更新成功";
      GroupProductEntity t = groupProductService.get(GroupProductEntity.class, groupProduct.getId());
      try {
        MyBeanUtils.copyBeanNotNull2Bean(groupProduct, t);
        groupProductService.saveOrUpdate(t);
        systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
      } catch (Exception e) {
        e.printStackTrace();
        message = "团购商品更新失败";
      }
    } else {
      message = "团购商品添加成功";
      groupProductService.save(groupProduct);
      systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
    }
    j.setMsg(message);
    return j;
  }

  /**
   * 团购商品列表页面跳转
   * 
   * @return
   */
  @RequestMapping(params = "addorupdate")
  public ModelAndView addorupdate(GroupProductEntity groupProduct, HttpServletRequest req) {
    String groupId = oConvertUtils.getString(req.getParameter("groupid"));
    List<ProductEntity> products = systemService.getList(ProductEntity.class);
    req.setAttribute("groupid", groupId);
    req.setAttribute("products", products);
    
    if (StringUtil.isNotEmpty(groupProduct.getId())) {
      groupProduct = groupProductService.getEntity(GroupProductEntity.class, groupProduct.getId());
      req.setAttribute("groupProductPage", groupProduct);
    }
    return new ModelAndView("com/buss/xinji/groupProduct");
  }
}
