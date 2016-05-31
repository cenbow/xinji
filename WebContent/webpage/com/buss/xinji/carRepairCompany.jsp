<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>汽修公司</title>
    <t:base type="jquery,easyui,tools,DatePicker"></t:base>
    <t:base type="jquery,easyui,tools,DatePicker,ckeditor"></t:base>
    <script src="plug-in/jquery-plugs/fileupload/js/vendor/jquery.ui.widget.js"></script>
    <script src="plug-in/jquery-plugs/fileupload/js/jquery.fileupload.js"></script>
    <!-- we code these -->
    <link href="plug-in/jquery-plugs/fileupload/css/dropzone.css" type="text/css" rel="stylesheet" />
    <script src="plug-in/jquery-plugs/fileupload/js/xj.uploadfunction.js"></script>
  </head>
  <body style="overflow-y: scroll">
    <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="carRepairCompanyController.do?save">
      <input id="id" name="id" type="hidden" value="${carRepairCompanyPage.id }">
      <table style="width: 1200px;" cellpadding="0" cellspacing="1" class="formtable">
        <tr>
          <td align="right">
            <label class="Validform_label">名称:</label>
          </td>
          <td class="value">
            <input class="inputxt" id="name" name="name" ignore="ignore" value="${carRepairCompanyPage.name}">
            <span class="Validform_checktip"></span>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="Validform_label">缩略图:</label>
          </td>
          <td class="value">
            <input class="inputxt xj_uploader_input" id="thumbnail" name="thumbnail" value="${carRepairCompanyPage.thumbnail}" placeholder="点击选择文件">
            <input class="file_uploader" type="file" name="files[]" data-url="fileUploaderController.do?upload&folder=thumbnail" style="display:none;" forinput='thumbnail'>
            <span class="Validform_checktip"></span>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="Validform_label">排序:</label>
          </td>
          <td class="value">
            <input class="inputxt" id="sortOrder" name="sortOrder" ignore="ignore" value="${carRepairCompanyPage.sortOrder}" datatype="n">
            <span class="Validform_checktip"></span>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="Validform_label">状态:</label>
          </td>
          <td class="value">
            <t:dictSelect field="status" typeGroupCode="status" hasLabel="false" defaultVal="${carRepairCompanyPage.status}" ></t:dictSelect>
            <span class="Validform_checktip"></span>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="Validform_label">详细内容:</label>
          </td>
          <td class="value">
            <t:ckeditor name="content" isfinder="true" type="width:1000" value="${carRepairCompanyPage.content}"></t:ckeditor>
            <span class="Validform_checktip"></span>
          </td>
        </tr>
      </table>
    </t:formvalid>
 </body>