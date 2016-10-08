<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="orderList" fitColumns="true" title="订单" actionUrl="orderController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="订单号" field="orderCode" width="120" ></t:dgCol>
   <t:dgCol title="会员" field="memberName" width="120" sortable="false" ></t:dgCol>
<%--    <t:dgCol title="地址ID" field="addressDetail" ></t:dgCol> --%>
   <t:dgCol title="订单金额" field="orderAmount" width="120" ></t:dgCol>
   <t:dgCol title="商品金额" field="productAmount" width="120" ></t:dgCol>
   <t:dgCol title="运费" field="shipAmount" width="120" ></t:dgCol>
   <t:dgCol title="状态" dictionary="orderState" field="status" width="120" ></t:dgCol>
   <t:dgCol title="支付方式" dictionary="payWay" field="paymentType" width="120" ></t:dgCol>
<%--    <t:dgCol title="支付金额" field="paymentAmount" ></t:dgCol> --%>
   <t:dgCol title="支付时间" field="paidTime" formatter="yyyy-MM-dd hh:mm:ss" width="120" ></t:dgCol>
   <t:dgCol title="操作" field="opt" width="120" ></t:dgCol>
   <t:dgDelOpt title="删除" url="orderController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="orderController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="orderController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="orderController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>