<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <title>团购</title>
    <t:base type="jquery,easyui,tools,DatePicker,ckeditor"></t:base>
    <script src="plug-in/jquery-plugs/fileupload/js/vendor/jquery.ui.widget.js"></script>
    <script src="plug-in/jquery-plugs/fileupload/js/jquery.fileupload.js"></script>
    <!-- we code these -->
    <link href="plug-in/jquery-plugs/fileupload/css/dropzone.css" type="text/css" rel="stylesheet" />
    <script src="plug-in/jquery-plugs/fileupload/js/xj.uploadfunction.js"></script>
  </head>
  <body style="overflow-y: auto">
    <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="groupBuyingController.do?save">
      <input id="id" name="id" type="hidden" value="${groupBuyingPage.id }">
      <table style="width: 1000px;" cellpadding="0" cellspacing="1" class="formtable">
        <tr>
          <td align="right">
            <label class="Validform_label">标题:</label>
          </td>
          <td class="value">
            <input class="inputxt" id="title" name="title" datatype="*" value="${groupBuyingPage.title}">
            <span class="Validform_checktip"></span>
          </td>
          <td align="right">
            <label class="Validform_label">副标题:</label>
          </td>
          <td class="value">
            <input class="inputxt" id="subTitle" name="subTitle" ignore="ignore" value="${groupBuyingPage.subTitle}">
            <span class="Validform_checktip"></span>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="Validform_label">缩略图:</label>
          </td>
          <td class="value">
            <input class="inputxt xj_uploader_input" id="thumbnail" name="thumbnail" value="${groupBuyingPage.thumbnail}" placeholder="点击选择图片" datatype="*">
            <input class="file_uploader" type="file" name="files[]" data-url="fileUploaderController.do?upload&folder=thumbnail" style="display:none;" forinput='thumbnail'>
            <span class="Validform_checktip"></span>
          </td>
          <td align="right">
            <label class="Validform_label">轮播图片:</label>
          </td>
          <td class="value">
            <input class="inputxt xj_uploader_input" id="bannerImgs" name="bannerImgs" value="${groupBuyingPage.bannerImgs}" placeholder="点击选择图片，可选多张" datatype="*">
            <input class="file_uploader" type="file" name="files[]" data-url="fileUploaderController.do?upload&folder=banner" multiple style="display:none;" forinput='bannerImgs'>
            <span class="Validform_checktip"></span>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="Validform_label">原价:</label>
          </td>
          <td class="value">
            <input class="inputxt" id="originalPrice" name="originalPrice" value="${groupBuyingPage.originalPrice}" datatype="d">
            <span class="Validform_checktip"></span>
          </td>
          <td align="right">
            <label class="Validform_label">价格:</label>
          </td>
          <td class="value">
            <input class="inputxt" id="price" name="price" value="${groupBuyingPage.price}" datatype="d">
            <span class="Validform_checktip"></span>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="Validform_label">单位:</label>
          </td>
          <td class="value">
            <input class="inputxt" id="unit" name="unit" datatype="*" value="${groupBuyingPage.unit}">
            <span class="Validform_checktip"></span>
          </td>
          <td align="right">
            <label class="Validform_label">开团人数:</label>
          </td>
          <td class="value">
            <input class="inputxt" id="groupLimit" name="groupLimit" value="${groupBuyingPage.groupLimit}" datatype="n">
            <span class="Validform_checktip"></span>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="Validform_label">开始时间:</label>
          </td>
          <td class="value">
            <input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width: 150px" id="startDate" name="startDate" value="<fmt:formatDate value='${groupBuyingPage.startDate}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>">
            <span class="Validform_checktip"></span>
          </td>
          <td align="right">
            <label class="Validform_label">结束时间:</label>
          </td>
          <td class="value">
            <input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width: 150px" id="endDate" name="endDate" value="<fmt:formatDate value='${groupBuyingPage.endDate}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>">
            <span class="Validform_checktip"></span>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="Validform_label">运费:</label>
          </td>
          <td class="value">
            <input class="inputxt" id="shipAmount" name="shipAmount" value="${groupBuyingPage.shipAmount}" datatype="d">
            <span class="Validform_checktip"></span>
          </td>
          <td align="right">
            <label class="Validform_label">当前人数:</label>
          </td>
          <td class="value">
            <input class="inputxt" id="currentNum" name="currentNum" ignore="ignore" value="${groupBuyingPage.currentNum}" datatype="n">
            <span class="Validform_checktip"></span>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="Validform_label">状态:</label>
          </td>
          <td class="value">
            <t:dictSelect field="status" typeGroupCode="gbStatus" hasLabel="false" defaultVal="${groupBuyingPage.status}" ></t:dictSelect>
            <span class="Validform_checktip"></span>
          </td>
          <td align="right">
            <label class="Validform_label">标签分类:</label>
          </td>
          <td class="value">
            <t:dictSelect field="tag" typeGroupCode="gbTags" hasLabel="false" defaultVal="${groupBuyingPage.tag}" ></t:dictSelect>
            <span class="Validform_checktip"></span>
          </td>
        </tr>
        <tr>
          <td align="right">
            <label class="Validform_label">团购详情:</label>
          </td>
          <td class="value" colspan="3">
            <t:ckeditor name="description" isfinder="false" type="width:900" value="${groupBuyingPage.description}"></t:ckeditor>
            <span class="Validform_checktip"></span>
          </td>
        </tr>
      </table>
    </t:formvalid>
 </body>