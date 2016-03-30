<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>广告管理</title>
    <t:base type="jquery,easyui,tools,DatePicker,ckeditor"></t:base>
    <script src="plug-in/jquery-plugs/fileupload/js/vendor/jquery.ui.widget.js"></script>
    <script src="plug-in/jquery-plugs/fileupload/js/jquery.fileupload.js"></script>
    <!-- we code these -->
    <link href="plug-in/jquery-plugs/fileupload/css/dropzone.css" type="text/css" rel="stylesheet" />
    <script src="plug-in/jquery-plugs/fileupload/js/xj.uploadfunction.js"></script>
  </head>
  <body style="overflow-y:scroll">
    <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="adController.do?save">
      <input id="id" name="id" type="hidden" value="${adPage.id }">
      <table style="width: 1200px;" cellpadding="0" cellspacing="1" class="formtable">
        <tr>
          <td align="right">
            <label class="Validform_label">标题:</label>
          </td>
          <td class="value">
            <input class="inputxt" id="title" name="title" value="${adPage.title}" datatype="*">
            <span class="Validform_checktip"></span>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="Validform_label">图片:</label>
          </td>
          <td class="value">
<%--             <t:upload name="adImg" uploader="" extend="pic;" id="adImg" formId="formobj" buttonText="上传"></t:upload> --%>
            <input class="inputxt xj_uploader_input" id="adImg" name="adImg" value="${adPage.adImg}" placeholder="点击选择文件">
            <input class="file_uploader" type="file" name="files[]" data-url="fileUploaderController.do?upload&folder=ad" multiple style="display:none;" forinput='adImg'>
            <span class="Validform_checktip"></span>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="Validform_label">状态:</label>
          </td>
          <td class="value">
            <t:dictSelect field="status" typeGroupCode="status" hasLabel="false" defaultVal="${adPage.status}" ></t:dictSelect>
            <span class="Validform_checktip"></span>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="Validform_label">广告URL:</label>
          </td>
          <td class="value">
            <input class="inputxt" id="adUrl" name="adUrl" ignore="ignore" value="${adPage.adUrl}">
            <span class="Validform_checktip"></span>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="Validform_label">描述:</label>
          </td>
          <td class="value">
            <input class="inputxt" id="description" name="description" ignore="ignore" value="${adPage.description}">
            <span class="Validform_checktip"></span>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="Validform_label">广告内容:</label>
          </td>
          <td class="value">
<!--             <input class="inputxt" id="adContent" name="adContent"  -->
<%--                  value="${adPage.adContent}"> --%>
            <t:ckeditor name="adContent" isfinder="false" type="width:1000" value="${adPage.adContent}"></t:ckeditor>
            <span class="Validform_checktip"></span>
          </td>
        </tr>
      </table>
    </t:formvalid>
  </body>