<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>商品</title>
    <t:base type="jquery,easyui,tools,DatePicker,ckeditor"></t:base>
    <script src="plug-in/jquery-plugs/fileupload/js/vendor/jquery.ui.widget.js"></script>
    <script src="plug-in/jquery-plugs/fileupload/js/jquery.fileupload.js"></script>
    <!-- we code these -->
    <link href="plug-in/jquery-plugs/fileupload/css/dropzone.css" type="text/css" rel="stylesheet" />
    <script src="plug-in/jquery-plugs/fileupload/js/xj.uploadfunction.js"></script>
  </head>
  <body style="overflow-y: auto">
    <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="productController.do?save">
      <input id="id" name="id" type="hidden" value="${productPage.id }">
      <table style="width: 1200px;" cellpadding="0" cellspacing="1" class="formtable">
        <tr>
          <td align="right">
            <label class="Validform_label">SKU:</label>
          </td>
          <td class="value">
            <input class="inputxt" id="sku" name="sku" datatype="*" value="${productPage.sku}">
            <span class="Validform_checktip"></span>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="Validform_label">商品名称:</label>
          </td>
          <td class="value">
            <input class="inputxt" id="name" name="name" datatype="*" value="${productPage.name}">
            <span class="Validform_checktip"></span>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="Validform_label">缩略图:</label>
          </td>
          <td class="value">
            <input class="inputxt xj_uploader_input" id="thumbnail" name="thumbnail" value="${productPage.thumbnail}" datatype="*" placeholder="点击选择图片">
            <input class="file_uploader" type="file" name="files[]" data-url="fileUploaderController.do?upload&folder=thumbnail" style="display:none;" forinput='thumbnail'>
            <span class="Validform_checktip"></span>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="Validform_label">商品图片:</label>
          </td>
          <td class="value">
            <input class="inputxt xj_uploader_input" id="imgs" name="imgs" value="${productPage.imgs}" placeholder="点击选择，可选多张[选填]">
            <input class="file_uploader" type="file" name="files[]" data-url="fileUploaderController.do?upload&folder=products" multiple style="display:none;" forinput='imgs'>
            <span class="Validform_checktip"></span>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="Validform_label">原价:</label>
          </td>
          <td class="value">
            <input class="inputxt" id="originalPrice" name="originalPrice" value="${productPage.originalPrice}" datatype="d">
            <span class="Validform_checktip"></span>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="Validform_label">现价:</label>
          </td>
          <td class="value">
            <input class="inputxt" id="price" name="price" value="${productPage.price}" datatype="d">
            <span class="Validform_checktip"></span>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="Validform_label">单位:</label>
          </td>
          <td class="value">
            <input class="inputxt" id="unit" name="unit" datatype="*" value="${productPage.unit}">
            <span class="Validform_checktip"></span>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="Validform_label">状态:</label>
          </td>
          <td class="value">
            <t:dictSelect field="status" typeGroupCode="status" hasLabel="false" defaultVal="${productPage.status}" ></t:dictSelect>
            <span class="Validform_checktip"></span>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="Validform_label">商品详情:</label>
          </td>
          <td class="value">
            <t:ckeditor name="description" isfinder="false" type="width:1000" value="${productPage.description}"></t:ckeditor>
            <span class="Validform_checktip"></span>
          </td>
        </tr>
      </table>
    </t:formvalid>
 </body>