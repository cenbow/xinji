<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="membersList" title="会员管理" actionUrl="membersController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="手机号" field="phone"   width="120"></t:dgCol>
   <t:dgCol title="登录密码" field="password"   width="120"></t:dgCol>
   <t:dgCol title="会员号" field="memberNo"   width="120"></t:dgCol>
   <t:dgCol title="状态" field="status" dictionary="status"  width="120"></t:dgCol>
   <t:dgCol title="会员昵称" field="nickName"   width="120"></t:dgCol>
   <t:dgCol title="性别" field="sex" dictionary="sex" width="80"></t:dgCol>
   <t:dgCol title="电子邮箱" field="email"   width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="membersController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="membersController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="membersController.do?addorupdate" funname="update"></t:dgToolBar>
  </t:datagrid>
  </div>
</div>