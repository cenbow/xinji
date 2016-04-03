<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="shoppingCarLogList" title="购物车记录" actionUrl="shoppingCarLogController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="会员手机号" field="memberName"   width="120"></t:dgCol>
   <t:dgCol title="团购项目" field="itemName"   width="120"></t:dgCol>
   <t:dgCol title="价格" field="price"   width="120"></t:dgCol>
   <t:dgCol title="数量" field="qty"   width="120"></t:dgCol>
   <t:dgCol title="状态" field="status" dictionary="spcStatus" width="120"></t:dgCol>
   <t:dgCol title="备注" field="comment"   width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="shoppingCarLogController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="shoppingCarLogController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="shoppingCarLogController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="shoppingCarLogController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
</div>