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
 * @Description: 乡镇资讯
 * @author liliming
 * @date 2016-03-30 21:41:43
 * @version V1.0   
 *
 */
@Entity
@Table(name = "xj_town_news", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class TownNewsEntity implements java.io.Serializable {
  /**主键*/
  private java.lang.String id;
  /**乡镇ID*/
  private java.lang.String townId;
  /**分类ID*/
  private java.lang.String categoryId;
  /**标题*/
  private java.lang.String title;
  /**副标题*/
  private java.lang.String subTitle;
  /**缩略图，列表上显示*/
  private java.lang.String thumbnail;
  /**发布人名称*/
  private java.lang.String author;
  /**来源*/
  private java.lang.String fromUnit;
  /**资讯内容，富文本内容*/
  private java.lang.String contents;
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
  
  private java.lang.String townName;
  private java.lang.String categoryName;
  
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
   *@return: java.lang.String  乡镇ID
   */
  @Column(name ="TOWN_ID",nullable=true,length=50)
  public java.lang.String getTownId(){
    return this.townId;
  }

  /**
   *方法: 设置java.lang.String
   *@param: java.lang.String  乡镇ID
   */
  public void setTownId(java.lang.String townId){
    this.townId = townId;
  }
  /**
   *方法: 取得java.lang.String
   *@return: java.lang.String  分类ID
   */
  @Column(name ="CATEGORY_ID",nullable=true,length=50)
  public java.lang.String getCategoryId(){
    return this.categoryId;
  }

  /**
   *方法: 设置java.lang.String
   *@param: java.lang.String  分类ID
   */
  public void setCategoryId(java.lang.String categoryId){
    this.categoryId = categoryId;
  }
  /**
   *方法: 取得java.lang.String
   *@return: java.lang.String  标题
   */
  @Column(name ="TITLE",nullable=true,length=1000)
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
  @Column(name ="SUB_TITLE",nullable=true,length=1000)
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
   *@return: java.lang.String  发布人名称
   */
  @Column(name ="AUTHOR",nullable=true,length=200)
  public java.lang.String getAuthor(){
    return this.author;
  }

  /**
   *方法: 设置java.lang.String
   *@param: java.lang.String  发布人名称
   */
  public void setAuthor(java.lang.String author){
    this.author = author;
  }
  /**
   *方法: 取得java.lang.String
   *@return: java.lang.String  来源
   */
  @Column(name ="FROM_UNIT",nullable=true,length=500)
  public java.lang.String getFromUnit(){
    return this.fromUnit;
  }

  /**
   *方法: 设置java.lang.String
   *@param: java.lang.String  来源
   */
  public void setFromUnit(java.lang.String fromUnit){
    this.fromUnit = fromUnit;
  }
  /**
   *方法: 取得java.lang.Object
   *@return: java.lang.Object  资讯内容，富文本内容
   */
  @Column(name ="CONTENTS",nullable=true,length=65535)
  public java.lang.String getContents(){
    return this.contents;
  }

  /**
   *方法: 设置java.lang.Object
   *@param: java.lang.Object  资讯内容，富文本内容
   */
  public void setContents(java.lang.String contents){
    this.contents = contents;
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

  @Transient
  public java.lang.String getTownName() {
    return townName;
  }

  public void setTownName(java.lang.String townName) {
    this.townName = townName;
  }

  @Transient
  public java.lang.String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(java.lang.String categoryName) {
    this.categoryName = categoryName;
  }
}
