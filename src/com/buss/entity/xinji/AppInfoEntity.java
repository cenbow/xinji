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
 * @Description: app信息
 * @author liliming
 * @date 2016-05-23 17:34:28
 * @version V1.0   
 *
 */
@Entity
@Table(name = "xj_app_info", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class AppInfoEntity implements java.io.Serializable {
  /**主键*/
  private java.lang.String id;
  /**name*/
  private java.lang.String name;
  /**version*/
  private java.lang.String version;
  /**type*/
  private java.lang.String type;
  /**buildUrl*/
  private java.lang.String buildUrl;
  /**buildSize*/
  private java.lang.Integer buildSize;
  /**description*/
  private java.lang.String description;
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
   *@return: java.lang.String  name
   */
  @Column(name ="NAME",nullable=true,length=200)
  public java.lang.String getName(){
    return this.name;
  }

  /**
   *方法: 设置java.lang.String
   *@param: java.lang.String  name
   */
  public void setName(java.lang.String name){
    this.name = name;
  }
  /**
   *方法: 取得java.lang.String
   *@return: java.lang.String  version
   */
  @Column(name ="VERSION",nullable=true,length=50)
  public java.lang.String getVersion(){
    return this.version;
  }

  /**
   *方法: 设置java.lang.String
   *@param: java.lang.String  version
   */
  public void setVersion(java.lang.String version){
    this.version = version;
  }
  /**
   *方法: 取得java.lang.String
   *@return: java.lang.String  type
   */
  @Column(name ="TYPE",nullable=true,length=10)
  public java.lang.String getType(){
    return this.type;
  }

  /**
   *方法: 设置java.lang.String
   *@param: java.lang.String  type
   */
  public void setType(java.lang.String type){
    this.type = type;
  }
  /**
   *方法: 取得java.lang.String
   *@return: java.lang.String  buildUrl
   */
  @Column(name ="BUILD_URL",nullable=true,length=1000)
  public java.lang.String getBuildUrl(){
    return this.buildUrl;
  }

  /**
   *方法: 设置java.lang.String
   *@param: java.lang.String  buildUrl
   */
  public void setBuildUrl(java.lang.String buildUrl){
    this.buildUrl = buildUrl;
  }
  /**
   *方法: 取得java.lang.Integer
   *@return: java.lang.Integer  buildSize
   */
  @Column(name ="BUILD_SIZE",nullable=true,precision=19,scale=0)
  public java.lang.Integer getBuildSize(){
    return this.buildSize;
  }

  /**
   *方法: 设置java.lang.Integer
   *@param: java.lang.Integer  buildSize
   */
  public void setBuildSize(java.lang.Integer buildSize){
    this.buildSize = buildSize;
  }
  /**
   *方法: 取得java.lang.String
   *@return: java.lang.String  description
   */
  @Column(name ="DESCRIPTION",nullable=true,length=500)
  public java.lang.String getDescription(){
    return this.description;
  }

  /**
   *方法: 设置java.lang.String
   *@param: java.lang.String  description
   */
  public void setDescription(java.lang.String description){
    this.description = description;
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
