<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="appInfoList" title="App Build列表" actionUrl="appInfoController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="名称" field="name"   width="120"></t:dgCol>
   <t:dgCol title="版本号" field="version"   width="120"></t:dgCol>
   <t:dgCol title="类型" field="type" dictionary="appType" width="120"></t:dgCol>
   <t:dgCol title="Build链接地址" field="buildUrl"   width="120"></t:dgCol>
<%--    <t:dgCol title="Build大小(KB)" field="buildSize"   width="120"></t:dgCol> --%>
   <t:dgCol title="简介" field="description"   width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="appInfoController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="appInfoController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="appInfoController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="appInfoController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
</div>