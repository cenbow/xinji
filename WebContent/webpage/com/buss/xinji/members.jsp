<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>会员</title>
    <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  </head>
  <body style="overflow-y: hidden" scroll="no">
    <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="membersController.do?save">
      <input id="id" name="id" type="hidden" value="${membersPage.id }">
      <table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
        <tr>
          <td align="right">
            <label class="Validform_label">手机号:</label>
          </td>
          <td class="value">
            <input class="inputxt" id="phone" name="phone" datatype="*" value="${membersPage.phone}">
            <span class="Validform_checktip"></span>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="Validform_label">登录密码:</label>
          </td>
          <td class="value">
            <input class="inputxt" id="password" name="password" datatype="*" type="password" value="${membersPage.password}">
            <span class="Validform_checktip"></span>
          </td>
        </tr>
        <c:if test="${isDetail != null && isDetail == 1}">
        <tr>
          <td align="right">
            <label class="Validform_label">会员号:</label>
          </td>
          <td class="value">
            <input class="inputxt" id="memberNo" name="memberNo" ignore="ignore" value="${membersPage.memberNo}">
            <span class="Validform_checktip"></span>
          </td>
        </tr>
        </c:if>
        <tr>
          <td align="right">
            <label class="Validform_label">状态:</label>
          </td>
          <td class="value">
            <t:dictSelect field="status" typeGroupCode="status" hasLabel="false" defaultVal="${membersPage.status}" ></t:dictSelect>
            <span class="Validform_checktip"></span>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="Validform_label">会员昵称:</label>
          </td>
          <td class="value">
            <input class="inputxt" id="nickName" name="nickName" ignore="ignore" value="${membersPage.nickName}">
            <span class="Validform_checktip"></span>
          </td>
        </tr>
      </table>
    </t:formvalid>
 </body>