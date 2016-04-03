<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>

<div class="easyui-layout" fit="true">
  <div region="center" style="padding: 1px;">
    <t:datagrid name="groupProductList" title="团购商品" actionUrl="groupProductController.do?datagrid&groupid=${groupid }" idField="id" fit="true">
      <t:dgCol title="编码" field="id" hidden="true"></t:dgCol>
      <t:dgCol title="商品名称" field="productName"   width="120"></t:dgCol>
      <t:dgCol title="数量" field="productQty"   width="120"></t:dgCol>
      <t:dgDelOpt title="删除" url="groupProductController.do?del&id={id}" />
      <t:dgToolBar title="录入" icon="icon-add" url="groupProductController.do?addorupdate&groupid=${groupid}" funname="add"></t:dgToolBar>
      <t:dgToolBar title="编辑" icon="icon-edit" url="groupProductController.do?addorupdate&groupid=${groupid}" funname="update"></t:dgToolBar>
    </t:datagrid>
  </div>
</div>
<script type="text/javascript">
function editoperation(operationId,operationname) {
  createwindow("<t:mutiLang langKey="common.edit.param" langArg="common.operation"/>","functionController.do?addorupdaterule&functionId=${functionId}&id="+operationId);
}
</script>
