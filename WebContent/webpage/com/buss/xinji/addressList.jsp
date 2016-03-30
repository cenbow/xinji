<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="addressList" title="地址" actionUrl="addressController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="会员" field="memberPhone"   width="120"></t:dgCol>
   <t:dgCol title="收货人姓名" field="contactUser"   width="120"></t:dgCol>
   <t:dgCol title="收货人电话" field="contactPhone"   width="120"></t:dgCol>
   <t:dgCol title="省份" field="province"   width="120"></t:dgCol>
   <t:dgCol title="城市" field="city"   width="120"></t:dgCol>
   <t:dgCol title="地区" field="district"   width="120"></t:dgCol>
   <t:dgCol title="详细地址" field="detailLocation"   width="120"></t:dgCol>
   <t:dgCol title="邮编" field="zipCode"   width="120"></t:dgCol>
   <t:dgCol title="是否默认" field="isDefault" dictionary="yesorno"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="addressController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="addressController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="addressController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="addressController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
</div>