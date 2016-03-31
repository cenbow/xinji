<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="productList" title="商品管理" actionUrl="productController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="SKU" field="sku"   width="120"></t:dgCol>
   <t:dgCol title="商品名称" field="name"   width="120"></t:dgCol>
<%--    <t:dgCol title="缩略图，列表上显示" field="thumbnail"   width="120"></t:dgCol> --%>
<%--    <t:dgCol title="商品图片，多张图片以（|）分隔（预留）" field="imgs"   width="120"></t:dgCol> --%>
   <t:dgCol title="原价" field="originalPrice"   width="120"></t:dgCol>
   <t:dgCol title="现价" field="price"   width="120"></t:dgCol>
   <t:dgCol title="单位" field="unit"   width="120"></t:dgCol>
<%--    <t:dgCol title="商品详情，富文本商品详情" field="description"   width="120"></t:dgCol> --%>
   <t:dgCol title="状态" field="status" dictionary="status" width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="productController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="productController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="productController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="productController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
</div>