package com.buss.entity.xinji;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;

/**   
 * @Title: Entity
 * @Description: 商品明细
 * @author liliming
 * @date 2016-04-03 17:14:55
 * @version V1.0   
 *
 */
@Entity
@Table(name = "xj_order_item", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class OrderItemEntity implements java.io.Serializable {
  /**主键*/
  private java.lang.String id;
  /**会员ID（冗余）*/
  private java.lang.String memberId;
  /**订单ID*/
  private java.lang.String orderId;
  /**项目ID，对应的团购ID*/
  private java.lang.String itemId;
  /**价格，购买的价格*/
  private BigDecimal price;
  /**数量，购买的团购份数*/
  private java.lang.Integer qty;
  /**备注，可对每个项目进行备注*/
  private java.lang.String comment;
  /**购物车ID，用于记录购物车项目转化率*/
  private java.lang.String shoppingCarId;
  /**创建人登录名称*/
  private java.lang.String createBy;
  /**创建人名字*/
  private java.lang.String createName;
  /**创建日期*/
  private java.util.Date createDate;
  /**更新人登录名称*/
  private java.lang.String updateBy;
  /**更新人名字*/
  private java.lang.String updateName;
  /**更新日期*/
  private java.util.Date updateDate;
  
  /**
   *方法: 取得java.lang.String
   *@return: java.lang.String  主键
   */
  
  @Id
  @GeneratedValue(generator = "paymentableGenerator")
  @GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
  @Column(name ="ID",nullable=false,length=50)
  public java.lang.String getId(){
    return this.id;
  }

  /**
   *方法: 设置java.lang.String
   *@param: java.lang.String  主键
   */
  public void setId(java.lang.String id){
    this.id = id;
  }
  /**
   *方法: 取得java.lang.String
   *@return: java.lang.String  会员ID（冗余）
   */
  @Column(name ="MEMBER_ID",nullable=true,length=50)
  public java.lang.String getMemberId(){
    return this.memberId;
  }

  /**
   *方法: 设置java.lang.String
   *@param: java.lang.String  会员ID（冗余）
   */
  public void setMemberId(java.lang.String memberId){
    this.memberId = memberId;
  }
  /**
   *方法: 取得java.lang.String
   *@return: java.lang.String  订单ID
   */
  @Column(name ="ORDER_ID",nullable=true,length=50)
  public java.lang.String getOrderId(){
    return this.orderId;
  }

  /**
   *方法: 设置java.lang.String
   *@param: java.lang.String  订单ID
   */
  public void setOrderId(java.lang.String orderId){
    this.orderId = orderId;
  }
  /**
   *方法: 取得java.lang.String
   *@return: java.lang.String  项目ID，对应的团购ID
   */
  @Column(name ="ITEM_ID",nullable=true,length=50)
  public java.lang.String getItemId(){
    return this.itemId;
  }

  /**
   *方法: 设置java.lang.String
   *@param: java.lang.String  项目ID，对应的团购ID
   */
  public void setItemId(java.lang.String itemId){
    this.itemId = itemId;
  }
  /**
   *方法: 取得BigDecimal
   *@return: BigDecimal  价格，购买的价格
   */
  @Column(name ="PRICE",nullable=true,precision=10,scale=2)
  public BigDecimal getPrice(){
    return this.price;
  }

  /**
   *方法: 设置BigDecimal
   *@param: BigDecimal  价格，购买的价格
   */
  public void setPrice(BigDecimal price){
    this.price = price;
  }
  /**
   *方法: 取得java.lang.Integer
   *@return: java.lang.Integer  数量，购买的团购份数
   */
  @Column(name ="QTY",nullable=true,precision=10,scale=0)
  public java.lang.Integer getQty(){
    return this.qty;
  }

  /**
   *方法: 设置java.lang.Integer
   *@param: java.lang.Integer  数量，购买的团购份数
   */
  public void setQty(java.lang.Integer qty){
    this.qty = qty;
  }
  /**
   *方法: 取得java.lang.String
   *@return: java.lang.String  备注，可对每个项目进行备注
   */
  @Column(name ="COMMENT",nullable=true,length=500)
  public java.lang.String getComment(){
    return this.comment;
  }

  /**
   *方法: 设置java.lang.String
   *@param: java.lang.String  备注，可对每个项目进行备注
   */
  public void setComment(java.lang.String comment){
    this.comment = comment;
  }
  /**
   *方法: 取得java.lang.String
   *@return: java.lang.String  购物车ID，用于记录购物车项目转化率
   */
  @Column(name ="SHOPPING_CAR_ID",nullable=true,length=50)
  public java.lang.String getShoppingCarId(){
    return this.shoppingCarId;
  }

  /**
   *方法: 设置java.lang.String
   *@param: java.lang.String  购物车ID，用于记录购物车项目转化率
   */
  public void setShoppingCarId(java.lang.String shoppingCarId){
    this.shoppingCarId = shoppingCarId;
  }
  /**
   *方法: 取得java.lang.String
   *@return: java.lang.String  创建人登录名称
   */
  @Column(name ="CREATE_BY",nullable=true,length=50)
  public java.lang.String getCreateBy(){
    return this.createBy;
  }

  /**
   *方法: 设置java.lang.String
   *@param: java.lang.String  创建人登录名称
   */
  public void setCreateBy(java.lang.String createBy){
    this.createBy = createBy;
  }
  /**
   *方法: 取得java.lang.String
   *@return: java.lang.String  创建人名字
   */
  @Column(name ="CREATE_NAME",nullable=true,length=50)
  public java.lang.String getCreateName(){
    return this.createName;
  }

  /**
   *方法: 设置java.lang.String
   *@param: java.lang.String  创建人名字
   */
  public void setCreateName(java.lang.String createName){
    this.createName = createName;
  }
  /**
   *方法: 取得java.util.Date
   *@return: java.util.Date  创建日期
   */
  @Column(name ="CREATE_DATE",nullable=true)
  public java.util.Date getCreateDate(){
    return this.createDate;
  }

  /**
   *方法: 设置java.util.Date
   *@param: java.util.Date  创建日期
   */
  public void setCreateDate(java.util.Date createDate){
    this.createDate = createDate;
  }
  /**
   *方法: 取得java.lang.String
   *@return: java.lang.String  更新人登录名称
   */
  @Column(name ="UPDATE_BY",nullable=true,length=50)
  public java.lang.String getUpdateBy(){
    return this.updateBy;
  }

  /**
   *方法: 设置java.lang.String
   *@param: java.lang.String  更新人登录名称
   */
  public void setUpdateBy(java.lang.String updateBy){
    this.updateBy = updateBy;
  }
  /**
   *方法: 取得java.lang.String
   *@return: java.lang.String  更新人名字
   */
  @Column(name ="UPDATE_NAME",nullable=true,length=50)
  public java.lang.String getUpdateName(){
    return this.updateName;
  }

  /**
   *方法: 设置java.lang.String
   *@param: java.lang.String  更新人名字
   */
  public void setUpdateName(java.lang.String updateName){
    this.updateName = updateName;
  }
  /**
   *方法: 取得java.util.Date
   *@return: java.util.Date  更新日期
   */
  @Column(name ="UPDATE_DATE",nullable=true)
  public java.util.Date getUpdateDate(){
    return this.updateDate;
  }

  /**
   *方法: 设置java.util.Date
   *@param: java.util.Date  更新日期
   */
  public void setUpdateDate(java.util.Date updateDate){
    this.updateDate = updateDate;
  }
}
