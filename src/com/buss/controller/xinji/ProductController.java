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

import com.buss.entity.xinji.ProductEntity;
import com.buss.service.xinji.ProductServiceI;

/**   
 * @Title: Controller
 * @Description: 商品
 * @author liliming
 * @date 2016-03-31 22:25:39
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/productController")
public class ProductController extends BaseController {
  /**
   * Logger for this class
   */
  private static final Logger logger = Logger.getLogger(ProductController.class);

  @Autowired
  private ProductServiceI productService;
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
   * 商品列表 页面跳转
   * 
   * @return
   */
  @RequestMapping(params = "product")
  public ModelAndView product(HttpServletRequest request) {
    return new ModelAndView("com/buss/xinji/productList");
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
  public void datagrid(ProductEntity product,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
    CriteriaQuery cq = new CriteriaQuery(ProductEntity.class, dataGrid);
    //查询条件组装器
    org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, product, request.getParameterMap());
    this.productService.getDataGridReturn(cq, true);
    TagUtil.datagrid(response, dataGrid);
  }

  /**
   * 删除商品
   * 
   * @return
   */
  @RequestMapping(params = "del")
  @ResponseBody
  public AjaxJson del(ProductEntity product, HttpServletRequest request) {
    AjaxJson j = new AjaxJson();
    product = systemService.getEntity(ProductEntity.class, product.getId());
    message = "商品删除成功";
    productService.delete(product);
    systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
    
    j.setMsg(message);
    return j;
  }


  /**
   * 添加商品
   * 
   * @param ids
   * @return
   */
  @RequestMapping(params = "save")
  @ResponseBody
  public AjaxJson save(ProductEntity product, HttpServletRequest request) {
    AjaxJson j = new AjaxJson();
    if (StringUtil.isNotEmpty(product.getId())) {
      message = "商品更新成功";
      ProductEntity t = productService.get(ProductEntity.class, product.getId());
      try {
        MyBeanUtils.copyBeanNotNull2Bean(product, t);
        productService.saveOrUpdate(t);
        systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
      } catch (Exception e) {
        e.printStackTrace();
        message = "商品更新失败";
      }
    } else {
      message = "商品添加成功";
      productService.save(product);
      systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
    }
    j.setMsg(message);
    return j;
  }

  /**
   * 商品列表页面跳转
   * 
   * @return
   */
  @RequestMapping(params = "addorupdate")
  public ModelAndView addorupdate(ProductEntity product, HttpServletRequest req) {
    if (StringUtil.isNotEmpty(product.getId())) {
      product = productService.getEntity(ProductEntity.class, product.getId());
      req.setAttribute("productPage", product);
    }
    return new ModelAndView("com/buss/xinji/product");
  }
}
