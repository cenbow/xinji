package com.buss.entity.xinji;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;

/**   
 * @Title: Entity
 * @Description: 地址
 * @author liliming
 * @date 2016-03-30 17:57:20
 * @version V1.0   
 *
 */
@Entity
@Table(name = "xj_address", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class AddressEntity implements java.io.Serializable {
  /**主键*/
  private java.lang.String id;
  /**会员ID*/
  private java.lang.String memberId;
  /**省份*/
  private java.lang.String province;
  /**城市*/
  private java.lang.String city;
  /**地区*/
  private java.lang.String district;
  /**详细地址*/
  private java.lang.String detailLocation;
  /**邮编*/
  private java.lang.String zipCode;
  /**收货人姓名*/
  private java.lang.String contactUser;
  /**收货人电话*/
  private java.lang.String contactPhone;
  /**是否为默认当前使用的地址，0-否，1-是*/
  private java.lang.String isDefault;
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
  
  private java.lang.String memberPhone;
  
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
   *@return: java.lang.String  省份
   */
  @Column(name ="PROVINCE",nullable=true,length=100)
  public java.lang.String getProvince(){
    return this.province;
  }

  /**
   *方法: 设置java.lang.String
   *@param: java.lang.String  省份
   */
  public void setProvince(java.lang.String province){
    this.province = province;
  }
  /**
   *方法: 取得java.lang.String
   *@return: java.lang.String  城市
   */
  @Column(name ="CITY",nullable=true,length=100)
  public java.lang.String getCity(){
    return this.city;
  }

  /**
   *方法: 设置java.lang.String
   *@param: java.lang.String  城市
   */
  public void setCity(java.lang.String city){
    this.city = city;
  }
  /**
   *方法: 取得java.lang.String
   *@return: java.lang.String  地区
   */
  @Column(name ="DISTRICT",nullable=true,length=100)
  public java.lang.String getDistrict(){
    return this.district;
  }

  /**
   *方法: 设置java.lang.String
   *@param: java.lang.String  地区
   */
  public void setDistrict(java.lang.String district){
    this.district = district;
  }
  /**
   *方法: 取得java.lang.String
   *@return: java.lang.String  详细地址
   */
  @Column(name ="DETAIL_LOCATION",nullable=true,length=2000)
  public java.lang.String getDetailLocation(){
    return this.detailLocation;
  }

  /**
   *方法: 设置java.lang.String
   *@param: java.lang.String  详细地址
   */
  public void setDetailLocation(java.lang.String detailLocation){
    this.detailLocation = detailLocation;
  }
  /**
   *方法: 取得java.lang.String
   *@return: java.lang.String  邮编
   */
  @Column(name ="ZIP_CODE",nullable=true,length=20)
  public java.lang.String getZipCode(){
    return this.zipCode;
  }

  /**
   *方法: 设置java.lang.String
   *@param: java.lang.String  邮编
   */
  public void setZipCode(java.lang.String zipCode){
    this.zipCode = zipCode;
  }
  /**
   *方法: 取得java.lang.String
   *@return: java.lang.String  收货人姓名
   */
  @Column(name ="CONTACT_USER",nullable=true,length=100)
  public java.lang.String getContactUser(){
    return this.contactUser;
  }

  /**
   *方法: 设置java.lang.String
   *@param: java.lang.String  收货人姓名
   */
  public void setContactUser(java.lang.String contactUser){
    this.contactUser = contactUser;
  }
  /**
   *方法: 取得java.lang.String
   *@return: java.lang.String  收货人电话
   */
  @Column(name ="CONTACT_PHONE",nullable=true,length=50)
  public java.lang.String getContactPhone(){
    return this.contactPhone;
  }

  /**
   *方法: 设置java.lang.String
   *@param: java.lang.String  收货人电话
   */
  public void setContactPhone(java.lang.String contactPhone){
    this.contactPhone = contactPhone;
  }
  /**
   *方法: 取得java.lang.String
   *@return: java.lang.String  是否为默认当前使用的地址，0-否，1-是
   */
  @Column(name ="IS_DEFAULT",nullable=true,length=20)
  public java.lang.String getIsDefault(){
    return this.isDefault;
  }

  /**
   *方法: 设置java.lang.String
   *@param: java.lang.String  是否为默认当前使用的地址，0-否，1-是
   */
  public void setIsDefault(java.lang.String isDefault){
    this.isDefault = isDefault;
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
  public java.lang.String getMemberPhone() {
    return memberPhone;
  }

  public void setMemberPhone(java.lang.String memberPhone) {
    this.memberPhone = memberPhone;
  }
}
