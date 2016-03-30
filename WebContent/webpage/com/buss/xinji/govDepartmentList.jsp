<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="govDepartmentList" title="政务部门" actionUrl="govDepartmentController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="名称" field="name"   width="120"></t:dgCol>
   <t:dgCol title="缩略图" field="thumbnail"   width="120"></t:dgCol>
<%--    <t:dgCol title="banner图片，多张以（|） 分隔" field="bannerImgs"   width="120"></t:dgCol> --%>
   <t:dgCol title="排序" field="sortOrder"   width="120"></t:dgCol>
   <t:dgCol title="状态" field="status" dictionary="status" width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="govDepartmentController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="govDepartmentController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="govDepartmentController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="govDepartmentController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
</div>