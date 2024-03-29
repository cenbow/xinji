<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="adList" title="广告管理" actionUrl="adController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="标题" field="title" sortable="true" width="120"></t:dgCol>
   <t:dgCol title="广告图片" field="adImg"   width="120"></t:dgCol>
<%--    <t:dgCol title="广告内容" field="adContent"   width="120"></t:dgCol> --%>
   <t:dgCol title="状态" field="status" dictionary="status" sortable="true" width="120"></t:dgCol>
   <t:dgCol title="广告外部URL" field="adUrl"   width="120"></t:dgCol>
   <t:dgCol title="描述" field="description"   width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="adController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="adController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="adController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="adController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
  </div>