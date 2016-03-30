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
 * @Description: 政务资讯栏目
 * @author liliming
 * @date 2016-03-30 21:39:52
 * @version V1.0   
 *
 */
@Entity
@Table(name = "xj_gov_news_category", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class GovNewsCategoryEntity implements java.io.Serializable {
  /**主键*/
  private java.lang.String id;
  /**名称*/
  private java.lang.String name;
  /**图标*/
  private java.lang.String icon;
  /**序号*/
  private java.lang.Integer sortOrder;
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
   *@return: java.lang.String  名称
   */
  @Column(name ="NAME",nullable=true,length=200)
  public java.lang.String getName(){
    return this.name;
  }

  /**
   *方法: 设置java.lang.String
   *@param: java.lang.String  名称
   */
  public void setName(java.lang.String name){
    this.name = name;
  }
  /**
   *方法: 取得java.lang.String
   *@return: java.lang.String  图标
   */
  @Column(name ="ICON",nullable=true,length=200)
  public java.lang.String getIcon(){
    return this.icon;
  }

  /**
   *方法: 设置java.lang.String
   *@param: java.lang.String  图标
   */
  public void setIcon(java.lang.String icon){
    this.icon = icon;
  }
  /**
   *方法: 取得java.lang.Integer
   *@return: java.lang.Integer  序号
   */
  @Column(name ="SORT_ORDER",nullable=true,precision=10,scale=0)
  public java.lang.Integer getSortOrder(){
    return this.sortOrder;
  }

  /**
   *方法: 设置java.lang.Integer
   *@param: java.lang.Integer  序号
   */
  public void setSortOrder(java.lang.Integer sortOrder){
    this.sortOrder = sortOrder;
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
