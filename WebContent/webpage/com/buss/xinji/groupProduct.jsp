<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>团购商品</title>
    <t:base type="jquery,easyui,tools"></t:base>
  </head>
  <body style="overflow-y: hidden" scroll="no">
    <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="groupProductController.do?save">
      <input id="id" name="id" type="hidden" value="${groupProductPage.id }">
      <input name="groupId" type="hidden" value="${groupid}">
      <table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
        <tr>
          <td align="right">
            <label class="Validform_label">商品:</label>
          </td>
          <td class="value">
            <select id="productId" name="productId" datatype="*">
              <c:forEach items="${products}" var="prod">
                <option value="${prod.id}" <c:if test="${prod.id==groupProductPage.productId}">selected="selected"</c:if>>${prod.name}</option>
              </c:forEach>
            </select>
            <span class="Validform_checktip"></span>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="Validform_label">数量:</label>
          </td>
          <td class="value">
            <input class="inputxt" id="productQty" name="productQty" value="${groupProductPage.productQty}" datatype="n">
            <span class="Validform_checktip"></span>
          </td>
        </tr>
      </table>
    </t:formvalid>
 </body>
</html>