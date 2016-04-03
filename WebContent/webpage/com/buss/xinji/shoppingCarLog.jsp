<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>购物车记录</title>
    <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  </head>
  <body style="overflow-y: auto">
    <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="shoppingCarLogController.do?save">
      <input id="id" name="id" type="hidden" value="${shoppingCarLogPage.id }">
      <table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
        <tr>
          <td align="right">
            <label class="Validform_label">会员手机号:</label>
          </td>
          <td class="value">
            <select id="memberId" name="memberId" datatype="*">
              <c:forEach items="${memberList}" var="member">
                <option value="${member.id}" <c:if test="${member.id==shoppingCarLogPage.memberId}">selected="selected"</c:if>>${member.phone}</option>
              </c:forEach>
            </select>
            <span class="Validform_checktip"></span>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="Validform_label">团购项目:</label>
          </td>
          <td class="value">
            <select id="itemId" name="itemId" datatype="*">
              <c:forEach items="${itemList}" var="item">
                <option value="${item.id}" <c:if test="${item.id==shoppingCarLogPage.itemId}">selected="selected"</c:if>>${item.title}</option>
              </c:forEach>
            </select>
            <span class="Validform_checktip"></span>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="Validform_label">价格:</label>
          </td>
          <td class="value">
            <input class="inputxt" id="price" name="price" value="${shoppingCarLogPage.price}" datatype="d">
            <span class="Validform_checktip"></span>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="Validform_label">数量:</label>
          </td>
          <td class="value">
            <input class="inputxt" id="qty" name="qty" value="${shoppingCarLogPage.qty}" datatype="n">
            <span class="Validform_checktip"></span>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="Validform_label">状态:</label>
          </td>
          <td class="value">
            <t:dictSelect field="status" typeGroupCode="spcStatus" hasLabel="false" defaultVal="${shoppingCarLogPage.status}" ></t:dictSelect>
            <span class="Validform_checktip"></span>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="Validform_label">备注:</label>
          </td>
          <td class="value">
            <input class="inputxt" id="comment" name="comment" value="${shoppingCarLogPage.comment}">
            <span class="Validform_checktip"></span>
          </td>
        </tr>
      </table>
    </t:formvalid>
 </body>