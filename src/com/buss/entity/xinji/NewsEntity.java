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
 * @Description: 资讯
 * @author liliming
 * @date 2016-03-30 23:28:43
 * @version V1.0   
 *
 */
@Entity
@Table(name = "xj_news", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class NewsEntity implements java.io.Serializable {
  /**主键*/
  private java.lang.String id;
  /**标题*/
  private java.lang.String title;
  /**副标题*/
  private java.lang.String subTitle;
  /**分类：辛集资讯-0，办事指南-1，劳务招聘-2，劳务维权-3，劳务政策-4，个人求职-5*/
  private java.lang.String category;
  /**缩略图，列表上显示*/
  private java.lang.String thumbnail;
  /**发布人名称*/
  private java.lang.String author;
  /**来源，来自哪里*/
  private java.lang.String fromUnit;
  /**资讯内容，富文本内容*/
  private java.lang.String contents;
  /**资讯状态，启用：1，停用：0*/
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
   *@return: java.lang.String  分类：辛集资讯-0，办事指南-1，劳务招聘-2，劳务维权-3，劳务政策-4，个人求职-5
   */
  @Column(name ="CATEGORY",nullable=true,length=20)
  public java.lang.String getCategory(){
    return this.category;
  }

  /**
   *方法: 设置java.lang.String
   *@param: java.lang.String  分类：辛集资讯-0，办事指南-1，劳务招聘-2，劳务维权-3，劳务政策-4，个人求职-5
   */
  public void setCategory(java.lang.String category){
    this.category = category;
  }
  /**
   *方法: 取得java.lang.String
   *@return: java.lang.String  缩略图，列表上显示
   */
  @Column(name ="THUMBNAIL",nullable=true,length=1000)
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
   *@return: java.lang.String  来源，来自哪里
   */
  @Column(name ="FROM_UNIT",nullable=true,length=200)
  public java.lang.String getFromUnit(){
    return this.fromUnit;
  }

  /**
   *方法: 设置java.lang.String
   *@param: java.lang.String  来源，来自哪里
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
   *@return: java.lang.String  资讯状态，启用：1，停用：0
   */
  @Column(name ="STATUS",nullable=true,length=20)
  public java.lang.String getStatus(){
    return this.status;
  }

  /**
   *方法: 设置java.lang.String
   *@param: java.lang.String  资讯状态，启用：1，停用：0
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
