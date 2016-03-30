<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>乡镇资讯栏目</title>
    <t:base type="jquery,easyui,tools,DatePicker"></t:base>
    <script src="plug-in/jquery-plugs/fileupload/js/vendor/jquery.ui.widget.js"></script>
    <script src="plug-in/jquery-plugs/fileupload/js/jquery.fileupload.js"></script>
    <!-- we code these -->
    <link href="plug-in/jquery-plugs/fileupload/css/dropzone.css" type="text/css" rel="stylesheet" />
    <script src="plug-in/jquery-plugs/fileupload/js/xj.uploadfunction.js"></script>
  </head>
  <body style="overflow-y: hidden" scroll="no">
    <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="townNewsCategoryController.do?save">
      <input id="id" name="id" type="hidden" value="${townNewsCategoryPage.id }">
      <table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
        <tr>
          <td align="right">
            <label class="Validform_label">名称:</label>
          </td>
          <td class="value">
            <input class="inputxt" id="name" name="name" datatype="*" value="${townNewsCategoryPage.name}">
            <span class="Validform_checktip"></span>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="Validform_label">图标:</label>
          </td>
          <td class="value">
            <input class="inputxt xj_uploader_input" id="icon" name="icon" value="${townNewsCategoryPage.icon}" placeholder="点击选择图片">
            <input class="file_uploader" type="file" name="files[]" data-url="fileUploaderController.do?upload&folder=icons" style="display:none;" forinput='icon'>
            <span class="Validform_checktip"></span>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="Validform_label">排序:</label>
          </td>
          <td class="value">
            <input class="inputxt" id="sortOrder" name="sortOrder" ignore="ignore" value="${townNewsCategoryPage.sortOrder}" datatype="n">
            <span class="Validform_checktip"></span>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="Validform_label">状态:</label>
          </td>
          <td class="value">
            <t:dictSelect field="status" typeGroupCode="status" hasLabel="false" defaultVal="${townNewsCategoryPage.status}" ></t:dictSelect>
            <span class="Validform_checktip"></span>
          </td>
        </tr>
      </table>
    </t:formvalid>
 </body>