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
 * @Description: 商品
 * @author liliming
 * @date 2016-03-31 22:25:39
 * @version V1.0   
 *
 */
@Entity
@Table(name = "xj_product", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class ProductEntity implements java.io.Serializable {
  /**主键*/
  private java.lang.String id;
  /**SKU*/
  private java.lang.String sku;
  /**商品名称*/
  private java.lang.String name;
  /**缩略图，列表上显示*/
  private java.lang.String thumbnail;
  /**商品图片，多张图片以（|）分隔（预留）*/
  private java.lang.String imgs;
  /**原价*/
  private BigDecimal originalPrice;
  /**现价*/
  private BigDecimal price;
  /**单位*/
  private java.lang.String unit;
  /**商品详情，富文本商品详情*/
  private java.lang.String description;
  /**状态，启用：1，停用：0*/
  private java.lang.String status;
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
   *@return: java.lang.String  SKU
   */
  @Column(name ="SKU",nullable=true,length=20)
  public java.lang.String getSku(){
    return this.sku;
  }

  /**
   *方法: 设置java.lang.String
   *@param: java.lang.String  SKU
   */
  public void setSku(java.lang.String sku){
    this.sku = sku;
  }
  /**
   *方法: 取得java.lang.String
   *@return: java.lang.String  商品名称
   */
  @Column(name ="NAME",nullable=true,length=200)
  public java.lang.String getName(){
    return this.name;
  }

  /**
   *方法: 设置java.lang.String
   *@param: java.lang.String  商品名称
   */
  public void setName(java.lang.String name){
    this.name = name;
  }
  /**
   *方法: 取得java.lang.String
   *@return: java.lang.String  缩略图，列表上显示
   */
  @Column(name ="THUMBNAIL",nullable=true,length=200)
  public java.lang.String getThumbnail(){
    return this.thumbnail;
  }

  /**
   *方法: 设置java.lang.String
   *@param: java.lang.String  缩略图，列表上显示
   */
  public void setThumbnail(java.lang.String thumbnail){
    this.thumbnail = thumbnail;
  }
  /**
   *方法: 取得java.lang.String
   *@return: java.lang.String  商品图片，多张图片以（|）分隔（预留）
   */
  @Column(name ="IMGS",nullable=true,length=1000)
  public java.lang.String getImgs(){
    return this.imgs;
  }

  /**
   *方法: 设置java.lang.String
   *@param: java.lang.String  商品图片，多张图片以（|）分隔（预留）
   */
  public void setImgs(java.lang.String imgs){
    this.imgs = imgs;
  }
  /**
   *方法: 取得BigDecimal
   *@return: BigDecimal  原价
   */
  @Column(name ="ORIGINAL_PRICE",nullable=true,precision=10,scale=2)
  public BigDecimal getOriginalPrice(){
    return this.originalPrice;
  }

  /**
   *方法: 设置BigDecimal
   *@param: BigDecimal  原价
   */
  public void setOriginalPrice(BigDecimal originalPrice){
    this.originalPrice = originalPrice;
  }
  /**
   *方法: 取得BigDecimal
   *@return: BigDecimal  现价
   */
  @Column(name ="PRICE",nullable=true,precision=10,scale=2)
  public BigDecimal getPrice(){
    return this.price;
  }

  /**
   *方法: 设置BigDecimal
   *@param: BigDecimal  现价
   */
  public void setPrice(BigDecimal price){
    this.price = price;
  }
  /**
   *方法: 取得java.lang.String
   *@return: java.lang.String  单位
   */
  @Column(name ="UNIT",nullable=true,length=20)
  public java.lang.String getUnit(){
    return this.unit;
  }

  /**
   *方法: 设置java.lang.String
   *@param: java.lang.String  单位
   */
  public void setUnit(java.lang.String unit){
    this.unit = unit;
  }
  /**
   *方法: 取得java.lang.Object
   *@return: java.lang.Object  商品详情，富文本商品详情
   */
  @Column(name ="DESCRIPTION",nullable=true,length=65535)
  public java.lang.String getDescription(){
    return this.description;
  }

  /**
   *方法: 设置java.lang.Object
   *@param: java.lang.Object  商品详情，富文本商品详情
   */
  public void setDescription(java.lang.String description){
    this.description = description;
  }
  /**
   *方法: 取得java.lang.String
   *@return: java.lang.String  状态，启用：1，停用：0
   */
  @Column(name ="STATUS",nullable=true,length=20)
  public java.lang.String getStatus(){
    return this.status;
  }

  /**
   *方法: 设置java.lang.String
   *@param: java.lang.String  状态，启用：1，停用：0
   */
  public void setStatus(java.lang.String status){
    this.status = status;
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
