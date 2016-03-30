<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>地址</title>
    <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  </head>
  <body style="overflow-y: hidden" scroll="no">
    <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="addressController.do?save">
      <input id="id" name="id" type="hidden" value="${addressPage.id }">
      <table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
        <tr>
          <td align="right">
            <label class="Validform_label">会员:</label>
          </td>
          <td class="value">
            <select id="memberId" name="memberId" datatype="*">
              <c:forEach items="${membersList}" var="m">
                <option value="${m.id}" <c:if test="${m.id==addressPage.memberId}">selected="selected"</c:if>>${m.phone}</option>
              </c:forEach>
            </select>
            <span class="Validform_checktip"></span>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="Validform_label">收货人姓名:</label>
          </td>
          <td class="value">
            <input class="inputxt" id="contactUser" name="contactUser" datatype="*" value="${addressPage.contactUser}">
            <span class="Validform_checktip"></span>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="Validform_label">收货人电话:</label>
          </td>
          <td class="value">
            <input class="inputxt" id="contactPhone" name="contactPhone" datatype="*" value="${addressPage.contactPhone}">
            <span class="Validform_checktip"></span>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="Validform_label">省份:</label>
          </td>
          <td class="value">
            <input class="inputxt" id="province" name="province" ignore="ignore" value="${addressPage.province}">
            <span class="Validform_checktip"></span>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="Validform_label">城市:</label>
          </td>
          <td class="value">
            <input class="inputxt" id="city" name="city" ignore="ignore" value="${addressPage.city}">
            <span class="Validform_checktip"></span>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="Validform_label">地区:</label>
          </td>
          <td class="value">
            <input class="inputxt" id="district" name="district" ignore="ignore" value="${addressPage.district}">
            <span class="Validform_checktip"></span>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="Validform_label">详细地址:</label>
          </td>
          <td class="value">
            <input class="inputxt" id="detailLocation" name="detailLocation" ignore="ignore" value="${addressPage.detailLocation}">
            <span class="Validform_checktip"></span>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="Validform_label">邮编:</label>
          </td>
          <td class="value">
            <input class="inputxt" id="zipCode" name="zipCode" ignore="ignore" value="${addressPage.zipCode}">
            <span class="Validform_checktip"></span>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="Validform_label">是否默认:</label>
          </td>
          <td class="value">
            <t:dictSelect field="isDefault" typeGroupCode="yesorno" hasLabel="false" defaultVal="${addressPage.isDefault}" ></t:dictSelect>
            <span class="Validform_checktip"></span>
          </td>
        </tr>
      </table>
    </t:formvalid>
 </body>