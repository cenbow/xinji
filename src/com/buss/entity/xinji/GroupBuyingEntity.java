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
 * @Description: 团购
 * @author liliming
 * @date 2016-04-01 13:57:18
 * @version V1.0   
 *
 */
@Entity
@Table(name = "xj_group_buying", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class GroupBuyingEntity implements java.io.Serializable {
  /**主键*/
  private java.lang.String id;
  /**标题*/
  private java.lang.String title;
  /**副标题*/
  private java.lang.String subTitle;
  /**缩略图*/
  private java.lang.String thumbnail;
  /**轮播图片，多张图片以（|）分隔*/
  private java.lang.String bannerImgs;
  /**原价，订单上的对应原价以此为准（每次团购价可能不一样）*/
  private BigDecimal originalPrice;
  /**价格，订单上的对应现价以此为准（每次团购价可能不一样）*/
  private BigDecimal price;
  /**单位*/
  private java.lang.String unit;
  /**标签分类*/
  private java.lang.String tag;
  /**详情，富文本*/
  private java.lang.String description;
  /**开团人数，达到多少人便成团，以下单的人数为准*/
  private java.lang.Integer groupLimit;
  /**开始时间，团购开放时间*/
  private java.util.Date startDate;
  /**结束时间，团购结束时间*/
  private java.util.Date endDate;
  /**运费，为0则为免运费*/
  private BigDecimal shipAmount;
  /**参团人数，当前已购买人数*/
  private java.lang.Integer currentNum;
  /**状态，0：停用，1：进行中，2：成团，3：已结束，4：不满团*/
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
   *@return: java.lang.String  标题
   */
  @Column(name ="TITLE",nullable=true,length=500)
  public java.lang.String getTitle(){
    return this.title;
  }

  /**
   *方法: 设置java.lang.String
   *@param: java.lang.String  标题
   */
  public void setTitle(java.lang.String title){
    this.title = title;
  }
  /**
   *方法: 取得java.lang.String
   *@return: java.lang.String  副标题
   */
  @Column(name ="SUB_TITLE",nullable=true,length=500)
  public java.lang.String getSubTitle(){
    return this.subTitle;
  }

  /**
   *方法: 设置java.lang.String
   *@param: java.lang.String  副标题
   */
  public void setSubTitle(java.lang.String subTitle){
    this.subTitle = subTitle;
  }
  /**
   *方法: 取得java.lang.String
   *@return: java.lang.String  缩略图
   */
  @Column(name ="THUMBNAIL",nullable=true,length=200)
  public java.lang.String getThumbnail(){
    return this.thumbnail;
  }

  /**
   *方法: 设置java.lang.String
   *@param: java.lang.String  缩略图
   */
  public void setThumbnail(java.lang.String thumbnail){
    this.thumbnail = thumbnail;
  }
  /**
   *方法: 取得java.lang.String
   *@return: java.lang.String  轮播图片，多张图片以（|）分隔
   */
  @Column(name ="BANNER_IMGS",nullable=true,length=1000)
  public java.lang.String getBannerImgs(){
    return this.bannerImgs;
  }

  /**
   *方法: 设置java.lang.String
   *@param: java.lang.String  轮播图片，多张图片以（|）分隔
   */
  public void setBannerImgs(java.lang.String bannerImgs){
    this.bannerImgs = bannerImgs;
  }
  /**
   *方法: 取得BigDecimal
   *@return: BigDecimal  原价，订单上的对应原价以此为准（每次团购价可能不一样）
   */
  @Column(name ="ORIGINAL_PRICE",nullable=true,precision=10,scale=2)
  public BigDecimal getOriginalPrice(){
    return this.originalPrice;
  }

  /**
   *方法: 设置BigDecimal
   *@param: BigDecimal  原价，订单上的对应原价以此为准（每次团购价可能不一样）
   */
  public void setOriginalPrice(BigDecimal originalPrice){
    this.originalPrice = originalPrice;
  }
  /**
   *方法: 取得BigDecimal
   *@return: BigDecimal  价格，订单上的对应现价以此为准（每次团购价可能不一样）
   */
  @Column(name ="PRICE",nullable=true,precision=10,scale=2)
  public BigDecimal getPrice(){
    return this.price;
  }

  /**
   *方法: 设置BigDecimal
   *@param: BigDecimal  价格，订单上的对应现价以此为准（每次团购价可能不一样）
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
   *方法: 取得java.lang.String
   *@return: java.lang.String  标签/分类，多个以（|）分隔
   */
  @Column(name ="TAG",nullable=true,length=1000)
  public java.lang.String getTag() {
    return tag;
  }

  /**
   *方法: 设置java.lang.String
   *@param: java.lang.String  标签/分类，多个以（|）分隔
   */
  public void setTag(java.lang.String tag) {
    this.tag = tag;
  }

  /**
   *方法: 取得java.lang.Object
   *@return: java.lang.Object  详情，富文本
   */
  @Column(name ="DESCRIPTION",nullable=true,length=65535)
  public java.lang.String getDescription(){
    return this.description;
  }

  /**
   *方法: 设置java.lang.Object
   *@param: java.lang.Object  详情，富文本
   */
  public void setDescription(java.lang.String description){
    this.description = description;
  }
  /**
   *方法: 取得java.lang.Integer
   *@return: java.lang.Integer  开团人数，达到多少人便成团，以下单的人数为准
   */
  @Column(name ="GROUP_LIMIT",nullable=true,precision=10,scale=0)
  public java.lang.Integer getGroupLimit(){
    return this.groupLimit;
  }

  /**
   *方法: 设置java.lang.Integer
   *@param: java.lang.Integer  开团人数，达到多少人便成团，以下单的人数为准
   */
  public void setGroupLimit(java.lang.Integer groupLimit){
    this.groupLimit = groupLimit;
  }
  /**
   *方法: 取得java.util.Date
   *@return: java.util.Date  开始时间，团购开放时间
   */
  @Column(name ="START_DATE",nullable=true)
  public java.util.Date getStartDate(){
    return this.startDate;
  }

  /**
   *方法: 设置java.util.Date
   *@param: java.util.Date  开始时间，团购开放时间
   */
  public void setStartDate(java.util.Date startDate){
    this.startDate = startDate;
  }
  /**
   *方法: 取得java.util.Date
   *@return: java.util.Date  结束时间，团购结束时间
   */
  @Column(name ="END_DATE",nullable=true)
  public java.util.Date getEndDate(){
    return this.endDate;
  }

  /**
   *方法: 设置java.util.Date
   *@param: java.util.Date  结束时间，团购结束时间
   */
  public void setEndDate(java.util.Date endDate){
    this.endDate = endDate;
  }
  /**
   *方法: 取得BigDecimal
   *@return: BigDecimal  运费，为0则为免运费
   */
  @Column(name ="SHIP_AMOUNT",nullable=true,precision=10,scale=2)
  public BigDecimal getShipAmount(){
    return this.shipAmount;
  }

  /**
   *方法: 设置BigDecimal
   *@param: BigDecimal  运费，为0则为免运费
   */
  public void setShipAmount(BigDecimal shipAmount){
    this.shipAmount = shipAmount;
  }
  /**
   *方法: 取得java.lang.Integer
   *@return: java.lang.Integer  参团人数，当前已购买人数
   */
  @Column(name ="CURRENT_NUM",nullable=true,precision=10,scale=0)
  public java.lang.Integer getCurrentNum(){
    return this.currentNum;
  }

  /**
   *方法: 设置java.lang.Integer
   *@param: java.lang.Integer  参团人数，当前已购买人数
   */
  public void setCurrentNum(java.lang.Integer currentNum){
    this.currentNum = currentNum;
  }
  /**
   *方法: 取得java.lang.String
   *@return: java.lang.String  状态，0：停用，1：进行中，2：成团，3：已结束，4：不满团
   */
  @Column(name ="STATUS",nullable=true,length=20)
  public java.lang.String getStatus(){
    return this.status;
  }

  /**
   *方法: 设置java.lang.String
   *@param: java.lang.String  状态，0：停用，1：进行中，2：成团，3：已结束，4：不满团
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
