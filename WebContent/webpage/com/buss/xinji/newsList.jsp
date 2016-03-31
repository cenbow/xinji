<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="newsList" title="${categoryName }" actionUrl="newsController.do?datagrid&category=${category}" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="标题" field="title" query="true" width="120"></t:dgCol>
<%--    <t:dgCol title="副标题" field="subTitle"   width="120"></t:dgCol> --%>
   <t:dgCol title="分类" field="category" dictionary="newsType" width="120"></t:dgCol>
<%--    <t:dgCol title="缩略图" field="thumbnail"   width="120"></t:dgCol> --%>
   <t:dgCol title="发布人" field="author"   width="120"></t:dgCol>
   <t:dgCol title="来源" field="fromUnit"   width="120"></t:dgCol>
<%--    <t:dgCol title="资讯内容，富文本内容" field="contents"   width="120"></t:dgCol> --%>
   <t:dgCol title="状态" field="status" dictionary="status" width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="newsController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="newsController.do?addorupdate&category=${category}" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="newsController.do?addorupdate&category=${category}" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="newsController.do?addorupdate&category=${category}" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
</div>