<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>乡镇资讯</title>
    <t:base type="jquery,easyui,tools,DatePicker,ckeditor"></t:base>
    <script src="plug-in/jquery-plugs/fileupload/js/vendor/jquery.ui.widget.js"></script>
    <script src="plug-in/jquery-plugs/fileupload/js/jquery.fileupload.js"></script>
    <!-- we code these -->
    <link href="plug-in/jquery-plugs/fileupload/css/dropzone.css" type="text/css" rel="stylesheet" />
    <script src="plug-in/jquery-plugs/fileupload/js/xj.uploadfunction.js"></script>
  </head>
  <body style="overflow-y: auto">
    <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="townNewsController.do?save">
      <input id="id" name="id" type="hidden" value="${townNewsPage.id }">
      <table style="width: 1200px;" cellpadding="0" cellspacing="1" class="formtable">
        <tr>
          <td align="right">
            <label class="Validform_label">标题:</label>
          </td>
          <td class="value">
            <input class="inputxt" id="title" name="title" datatype="*" value="${townNewsPage.title}">
            <span class="Validform_checktip"></span>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="Validform_label">副标题:</label>
          </td>
          <td class="value">
            <input class="inputxt" id="subTitle" name="subTitle" ignore="ignore" value="${townNewsPage.subTitle}">
            <span class="Validform_checktip"></span>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="Validform_label">乡镇:</label>
          </td>
          <td class="value">
            <select id="townId" name="townId" datatype="*">
              <c:forEach items="${townList}" var="town">
                <option value="${town.id}" <c:if test="${town.id==townNewsPage.townId}">selected="selected"</c:if>>${town.name}</option>
              </c:forEach>
            </select>
            <span class="Validform_checktip"></span>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="Validform_label">栏目:</label>
          </td>
          <td class="value">
            <select id="categoryId" name="categoryId" datatype="*">
              <c:forEach items="${categoryList}" var="category">
                <option value="${category.id}" <c:if test="${category.id==townNewsPage.categoryId}">selected="selected"</c:if>>${category.name}</option>
              </c:forEach>
            </select>
            <span class="Validform_checktip"></span>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="Validform_label">缩略图:</label>
          </td>
          <td class="value">
            <input class="inputxt xj_uploader_input" id="thumbnail" name="thumbnail" value="${townNewsPage.thumbnail}" placeholder="点击选择图片">
            <input class="file_uploader" type="file" name="files[]" data-url="fileUploaderController.do?upload&folder=thumbnail" style="display:none;" forinput='thumbnail'>
            <span class="Validform_checktip"></span>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="Validform_label">发布人:</label>
          </td>
          <td class="value">
            <input class="inputxt" id="author" name="author" ignore="ignore" value="${townNewsPage.author}">
            <span class="Validform_checktip"></span>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="Validform_label">来源:</label>
          </td>
          <td class="value">
            <input class="inputxt" id="fromUnit" name="fromUnit" ignore="ignore" value="${townNewsPage.fromUnit}">
            <span class="Validform_checktip"></span>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="Validform_label">状态:</label>
          </td>
          <td class="value">
            <t:dictSelect field="status" typeGroupCode="status" hasLabel="false" defaultVal="${townNewsPage.status}" ></t:dictSelect>
            <span class="Validform_checktip"></span>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="Validform_label">资讯内容:</label>
          </td>
          <td class="value">
            <t:ckeditor name="contents" isfinder="false" type="width:1000" value="${townNewsPage.contents}"></t:ckeditor>
            <span class="Validform_checktip"></span>
          </td>
        </tr>
      </table>
    </t:formvalid>
 </body>