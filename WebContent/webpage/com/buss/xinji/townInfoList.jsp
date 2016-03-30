<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="townInfoList" title="乡镇信息" actionUrl="townInfoController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="名称" field="name"   width="120"></t:dgCol>
   <t:dgCol title="缩略图" field="thumbnail"   width="120"></t:dgCol>
<%--    <t:dgCol title="banner图片，多张以（|） 分隔" field="bannerImgs"   width="120"></t:dgCol> --%>
   <t:dgCol title="排序" field="sortOrder"   width="120"></t:dgCol>
   <t:dgCol title="状态" field="status" dictionary="status" width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="townInfoController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="townInfoController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="townInfoController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="townInfoController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
</div>