package com.buss.entity.xinji;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

/**   
 * @Title: Entity
 * @Description: 订单
 * @author liliming
 * @date 2016-04-03 17:14:57
 * @version V1.0   
 *
 */
@Entity
@Table(name = "xj_order", schema = "")
@SuppressWarnings("serial")
public class OrderEntity implements java.io.Serializable {
  /**主键*/
  private java.lang.String id;
  /**订单号，随机生成*/
  private java.lang.String orderCode;
  /**会员ID*/
  private java.lang.String memberId;
  /**地址ID*/
  private java.lang.String addressId;
  /**订单总额，商品总金额*/
  private BigDecimal orderAmount;
  /**商品总额*/
  private BigDecimal productAmount;
  /**运费*/
  private BigDecimal shipAmount;
  /**状态，1：待支付，2：已支付，3：已发货，4：已收货，5：不成团，6：用户取消*/
  private java.lang.String status;
  /**支付方式，1：货到付款，2：微信支付，3：支付宝支付*/
  private java.lang.String paymentType;
  /**支付金额，一般等于订单金额*/
  private BigDecimal paymentAmount;
  /**支付时间*/
  private java.util.Date paidTime;
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
  
  private java.lang.String memberName;
  private java.lang.String addressDetail;
  
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
   *@return: java.lang.String  订单号，随机生成
   */
  @Column(name ="ORDER_CODE",nullable=true,length=100)
  public java.lang.String getOrderCode(){
    return this.orderCode;
  }

  /**
   *方法: 设置java.lang.String
   *@param: java.lang.String  订单号，随机生成
   */
  public void setOrderCode(java.lang.String orderCode){
    this.orderCode = orderCode;
  }
  /**
   *方法: 取得java.lang.String
   *@return: java.lang.String  会员ID
   */
  @Column(name ="MEMBER_ID",nullable=true,length=50)
  public java.lang.String getMemberId(){
    return this.memberId;
  }

  /**
   *方法: 设置java.lang.String
   *@param: java.lang.String  会员ID
   */
  public void setMemberId(java.lang.String memberId){
    this.memberId = memberId;
  }
  /**
   *方法: 取得java.lang.String
   *@return: java.lang.String  地址ID
   */
  @Column(name ="ADDRESS_ID",nullable=true,length=50)
  public java.lang.String getAddressId(){
    return this.addressId;
  }

  /**
   *方法: 设置java.lang.String
   *@param: java.lang.String  地址ID
   */
  public void setAddressId(java.lang.String addressId){
    this.addressId = addressId;
  }
  /**
   *方法: 取得BigDecimal
   *@return: BigDecimal  订单总额，商品总金额
   */
  @Column(name ="ORDER_AMOUNT",nullable=true,precision=10,scale=2)
  public BigDecimal getOrderAmount(){
    return this.orderAmount;
  }

  /**
   *方法: 设置BigDecimal
   *@param: BigDecimal  订单总额，商品总金额
   */
  public void setOrderAmount(BigDecimal orderAmount){
    this.orderAmount = orderAmount;
  }
  /**
   *方法: 取得BigDecimal
   *@return: BigDecimal  商品总额
   */
  @Column(name ="PRODUCT_AMOUNT",nullable=true,precision=10,scale=2)
  public BigDecimal getProductAmount(){
    return this.productAmount;
  }

  /**
   *方法: 设置BigDecimal
   *@param: BigDecimal  商品总额
   */
  public void setProductAmount(BigDecimal productAmount){
    this.productAmount = productAmount;
  }
  /**
   *方法: 取得BigDecimal
   *@return: BigDecimal  运费
   */
  @Column(name ="SHIP_AMOUNT",nullable=true,precision=10,scale=2)
  public BigDecimal getShipAmount(){
    return this.shipAmount;
  }

  /**
   *方法: 设置BigDecimal
   *@param: BigDecimal  运费
   */
  public void setShipAmount(BigDecimal shipAmount){
    this.shipAmount = shipAmount;
  }
  /**
   *方法: 取得java.lang.String
   *@return: java.lang.String  状态，1：待支付，2：已支付，3：已发货，4：已收货，5：不成团，6：用户取消
   */
  @Column(name ="STATUS",nullable=true,length=20)
  public java.lang.String getStatus(){
    return this.status;
  }

  /**
   *方法: 设置java.lang.String
   *@param: java.lang.String  状态，1：待支付，2：已支付，3：已发货，4：已收货，5：不成团，6：用户取消
   */
  public void setStatus(java.lang.String status){
    this.status = status;
  }
  /**
   *方法: 取得java.lang.String
   *@return: java.lang.String  支付方式，1：货到付款，2：微信支付，3：支付宝支付
   */
  @Column(name ="PAYMENT_TYPE",nullable=true,length=20)
  public java.lang.String getPaymentType(){
    return this.paymentType;
  }

  /**
   *方法: 设置java.lang.String
   *@param: java.lang.String  支付方式，1：货到付款，2：微信支付，3：支付宝支付
   */
  public void setPaymentType(java.lang.String paymentType){
    this.paymentType = paymentType;
  }
  /**
   *方法: 取得BigDecimal
   *@return: BigDecimal  支付金额，一般等于订单金额
   */
  @Column(name ="PAYMENT_AMOUNT",nullable=true,precision=10,scale=2)
  public BigDecimal getPaymentAmount(){
    return this.paymentAmount;
  }

  /**
   *方法: 设置BigDecimal
   *@param: BigDecimal  支付金额，一般等于订单金额
   */
  public void setPaymentAmount(BigDecimal paymentAmount){
    this.paymentAmount = paymentAmount;
  }
  /**
   *方法: 取得java.util.Date
   *@return: java.util.Date  支付时间
   */
  @Column(name ="PAID_TIME",nullable=true)
  public java.util.Date getPaidTime(){
    return this.paidTime;
  }

  /**
   *方法: 设置java.util.Date
   *@param: java.util.Date  支付时间
   */
  public void setPaidTime(java.util.Date paidTime){
    this.paidTime = paidTime;
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

  @Transient
  public java.lang.String getMemberName() {
    return memberName;
  }

  public void setMemberName(java.lang.String memberName) {
    this.memberName = memberName;
  }

  @Transient
  public java.lang.String getAddressDetail() {
    return addressDetail;
  }

  public void setAddressDetail(java.lang.String addressDetail) {
    this.addressDetail = addressDetail;
  }
}
