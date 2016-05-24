package com.buss.entity.xinji;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

/**   
 * @Title: Entity
 * @Description: 会员
 * @author liliming
 * @date 2016-03-30 19:38:43
 * @version V1.0   
 *
 */
@Entity
@Table(name = "xj_members", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class MembersEntity implements java.io.Serializable {
  /**主键*/
  private java.lang.String id;
  /**手机号，用于登录*/
  private java.lang.String phone;
  /**登录密码，md5加密*/
  private java.lang.String password;
  /**会员号，注册时生成的随机唯一编码，也可用于登录*/
  private java.lang.String memberNo;
  /**状态，启用：1，停用：0*/
  private java.lang.String status;
  /**会员昵称*/
  private java.lang.String nickName;
  /**性别*/
  private java.lang.String sex;
  /**电子邮箱*/
  private java.lang.String email;
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
   *@return: java.lang.String  手机号，用于登录
   */
  @Column(name ="PHONE",nullable=true,length=50)
  public java.lang.String getPhone(){
    return this.phone;
  }

  /**
   *方法: 设置java.lang.String
   *@param: java.lang.String  手机号，用于登录
   */
  public void setPhone(java.lang.String phone){
    this.phone = phone;
  }
  /**
   *方法: 取得java.lang.String
   *@return: java.lang.String  登录密码，md5加密
   */
  @Column(name ="PASSWORD",nullable=true,length=100)
  public java.lang.String getPassword(){
    return this.password;
  }

  /**
   *方法: 设置java.lang.String
   *@param: java.lang.String  登录密码，md5加密
   */
  public void setPassword(java.lang.String password){
    this.password = password;
  }
  /**
   *方法: 取得java.lang.String
   *@return: java.lang.String  会员号，注册时生成的随机唯一编码，也可用于登录
   */
  @Column(name ="MEMBER_NO",nullable=true,length=50)
  public java.lang.String getMemberNo(){
    return this.memberNo;
  }

  /**
   *方法: 设置java.lang.String
   *@param: java.lang.String  会员号，注册时生成的随机唯一编码，也可用于登录
   */
  public void setMemberNo(java.lang.String memberNo){
    this.memberNo = memberNo;
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
   *@return: java.lang.String  会员昵称
   */
  @Column(name ="NICK_NAME",nullable=true,length=20)
  public java.lang.String getNickName(){
    return this.nickName;
  }

  /**
   *方法: 设置java.lang.String
   *@param: java.lang.String  会员昵称
   */
  public void setNickName(java.lang.String nickName){
    this.nickName = nickName;
  }
  /**
   *方法: 取得java.lang.String
   *@return: java.lang.String  性别
   */
  @Column(name ="SEX",nullable=true,length=20)
  public java.lang.String getSex() {
    return sex;
  }
  
  /**
   *方法: 设置java.lang.String
   *@param: java.lang.String  性别
   */
  public void setSex(java.lang.String sex) {
    this.sex = sex;
  }

  /**
   *方法: 取得java.lang.String
   *@return: java.lang.String  电子邮箱
   */
  @Column(name ="EMAIL",nullable=true,length=50)
  public java.lang.String getEmail() {
    return email;
  }

  /**
   *方法: 设置java.lang.String
   *@param: java.lang.String  电子邮箱
   */
  public void setEmail(java.lang.String email) {
    this.email = email;
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
