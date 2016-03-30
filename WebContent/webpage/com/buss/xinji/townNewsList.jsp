<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="townNewsList" title="乡镇资讯" actionUrl="townNewsController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="乡镇" field="townName"   width="120"></t:dgCol>
   <t:dgCol title="栏目" field="categoryName"   width="120"></t:dgCol>
   <t:dgCol title="标题" field="title"   width="120"></t:dgCol>
<%--    <t:dgCol title="副标题" field="subTitle"   width="120"></t:dgCol> --%>
<%--    <t:dgCol title="缩略图，列表上显示" field="thumbnail"   width="120"></t:dgCol> --%>
   <t:dgCol title="发布人" field="author"   width="120"></t:dgCol>
   <t:dgCol title="来源" field="fromUnit"   width="120"></t:dgCol>
<%--    <t:dgCol title="资讯内容，富文本内容" field="contents"   width="120"></t:dgCol> --%>
   <t:dgCol title="状态" field="status" dictionary="status" width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="townNewsController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="townNewsController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="townNewsController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="townNewsController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
</div>