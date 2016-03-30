<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>广告位管理</title>
    <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  </head>
  <body style="overflow-y: hidden" scroll="no">
    <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="adPlaceController.do?save">
      <input id="id" name="id" type="hidden" value="${adPlacePage.id }">
      <table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
        <tr>
          <td align="right">
            <label class="Validform_label">名称:</label>
          </td>
          <td class="value">
            <input class="inputxt" id="name" name="name" value="${adPlacePage.name}" datatype="*">
            <span class="Validform_checktip"></span>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="Validform_label">类型</label>
          </td>
          <td class="value">
            <t:dictSelect field="type" typeGroupCode="adPosType" hasLabel="false" defaultVal="${adPlacePage.type}" ></t:dictSelect>
            <span class="Validform_checktip"></span>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="Validform_label">广告位标识:</label>
          </td>
          <td class="value">
            <input class="inputxt" id="tag" name="tag" ignore="ignore" value="${adPlacePage.tag}">（跟APP匹配的位置标识）
            <span class="Validform_checktip"></span>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="Validform_label">当前广告</label>
          </td>
          <td class="value">
            <select id="adId" name="adId" datatype="*">
              <c:forEach items="${adList}" var="ad">
                <option value="${ad.id}" <c:if test="${ad.id==adPlacePage.adId}">selected="selected"</c:if>>${ad.title}</option>
              </c:forEach>
            </select>
            <span class="Validform_checktip">请选择广告</span>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="Validform_label">排序</label>
          </td>
          <td class="value">
            <input class="inputxt" id="sortOrder" name="sortOrder" ignore="ignore" value="${adPlacePage.sortOrder}" datatype="n">
            <span class="Validform_checktip"></span>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="Validform_label">状态</label>
          </td>
          <td class="value">
            <t:dictSelect field="status" typeGroupCode="status" hasLabel="false" defaultVal="${adPlacePage.status}" ></t:dictSelect>
            <span class="Validform_checktip"></span>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="Validform_label">描述:</label>
          </td>
          <td class="value">
            <input class="inputxt" id="description" name="description" ignore="ignore" value="${adPlacePage.description}">
            <span class="Validform_checktip"></span>
          </td>
        </tr>
      </table>
    </t:formvalid>
 </body>