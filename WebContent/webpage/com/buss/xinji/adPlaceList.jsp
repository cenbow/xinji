<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="adPlaceList" title="广告位管理" actionUrl="adPlaceController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="名称" field="name"   width="120"></t:dgCol>
   <t:dgCol title="类型" field="type"   width="120" dictionary="adPosType" sortable="true"></t:dgCol>
   <t:dgCol title="广告位标识" field="tag"   width="120"></t:dgCol>
   <t:dgCol title="当前广告" field="adTitle"   width="120"></t:dgCol>
   <t:dgCol title="排序" field="sortOrder"   width="120"></t:dgCol>
   <t:dgCol title="状态" field="status"   width="120" dictionary="status" sortable="true"></t:dgCol>
   <t:dgCol title="描述" field="description"   width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="adPlaceController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="adPlaceController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="adPlaceController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="adPlaceController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
</div>