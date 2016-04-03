package com.buss.entity.xinji;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

/**   
 * @Title: Entity
 * @Description: 团购商品
 * @author liliming
 * @date 2016-04-02 22:58:12
 * @version V1.0   
 *
 */
@Entity
@Table(name = "xj_group_product", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class GroupProductEntity implements java.io.Serializable {
  /**主键*/
  private java.lang.String id;
  /**团购ID*/
  private java.lang.String groupId;
  /**商品ID*/
  private java.lang.String productId;
  /**数量，一次团购中包含该商品的数量*/
  private java.lang.Integer productQty;
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
  private java.lang.String productName;
  
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
   *@return: java.lang.String  团购ID
   */
  @Column(name ="GROUP_ID",nullable=true,length=50)
  public java.lang.String getGroupId(){
    return this.groupId;
  }

  /**
   *方法: 设置java.lang.String
   *@param: java.lang.String  团购ID
   */
  public void setGroupId(java.lang.String groupId){
    this.groupId = groupId;
  }
  /**
   *方法: 取得java.lang.String
   *@return: java.lang.String  商品ID
   */
  @Column(name ="PRODUCT_ID",nullable=true,length=50)
  public java.lang.String getProductId(){
    return this.productId;
  }

  /**
   *方法: 设置java.lang.String
   *@param: java.lang.String  商品ID
   */
  public void setProductId(java.lang.String productId){
    this.productId = productId;
  }
  /**
   *方法: 取得java.lang.Integer
   *@return: java.lang.Integer  数量，一次团购中包含该商品的数量
   */
  @Column(name ="PRODUCT_QTY",nullable=true,precision=10,scale=0)
  public java.lang.Integer getProductQty(){
    return this.productQty;
  }

  /**
   *方法: 设置java.lang.Integer
   *@param: java.lang.Integer  数量，一次团购中包含该商品的数量
   */
  public void setProductQty(java.lang.Integer productQty){
    this.productQty = productQty;
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
  public java.lang.String getProductName() {
    return productName;
  }

  public void setProductName(java.lang.String productName) {
    this.productName = productName;
  }
}
