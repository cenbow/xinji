<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>App Build信息</title>
    <t:base type="jquery,easyui,tools,DatePicker"></t:base>
    <script src="plug-in/jquery-plugs/fileupload/js/vendor/jquery.ui.widget.js"></script>
    <script src="plug-in/jquery-plugs/fileupload/js/jquery.fileupload.js"></script>
    <!-- we code these -->
    <link href="plug-in/jquery-plugs/fileupload/css/dropzone.css" type="text/css" rel="stylesheet" />
    <script src="plug-in/jquery-plugs/fileupload/js/xj.uploadfunction.js"></script>
  </head>
  <body style="overflow-y: auto">
    <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="appInfoController.do?save">
      <input id="id" name="id" type="hidden" value="${appInfoPage.id }">
      <table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
        <tr>
          <td align="right">
            <label class="Validform_label">名称:</label>
          </td>
          <td class="value">
            <input class="inputxt" id="name" name="name" datatype="*" value="${appInfoPage.name}">
            <span class="Validform_checktip"></span>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="Validform_label">版本号:</label>
          </td>
          <td class="value">
            <input class="inputxt" id="version" name="version" datatype="*" value="${appInfoPage.version}">
            <span class="Validform_checktip"></span>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="Validform_label">类型:</label>
          </td>
          <td class="value">
            <t:dictSelect field="type" typeGroupCode="appType" hasLabel="false" defaultVal="${appInfoPage.type}"></t:dictSelect>
            <span class="Validform_checktip"></span>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="Validform_label">Build文件:</label>
          </td>
          <td class="value">
            <input class="inputxt xj_uploader_input" id="buildUrl" name="buildUrl" value="${appInfoPage.buildUrl}" placeholder="点击选择文件" datatype="*">
            <input class="file_uploader" type="file" name="files[]" data-url="fileUploaderController.do?upload&folder=app" style="display:none;" forinput='buildUrl'>
            <span class="Validform_checktip"></span>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="Validform_label">简介:</label>
          </td>
          <td class="value">
            <input class="inputxt" id="description" name="description" ignore="ignore" value="${appInfoPage.description}">
            <span class="Validform_checktip"></span>
          </td>
        </tr>
      </table>
    </t:formvalid>
 </body>