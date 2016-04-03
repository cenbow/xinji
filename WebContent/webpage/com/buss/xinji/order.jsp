<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>订单</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //初始化下标
  function resetTrNum(tableId) {
    $tbody = $("#"+tableId+"");
    $tbody.find('>tr').each(function(i){
      $(':input, select', this).each(function(){
        var $this = $(this), name = $this.attr('name'), val = $this.val();
        if(name!=null){
          if (name.indexOf("#index#") >= 0){
            $this.attr("name",name.replace('#index#',i));
          }else{
            var s = name.indexOf("[");
            var e = name.indexOf("]");
            var new_name = name.substring(s+1,e);
            $this.attr("name",name.replace(new_name,i));
          }
        }
      });
      $(this).find('div[name=\'xh\']').html(i+1);
    });
  }
  $(document).ready(function(){
    if(location.href.indexOf("load=detail")!=-1){
      $("#addressDetailTr").show();
    }
  });
 </script>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="orderController.do?save">
      <input id="id" name="id" type="hidden" value="${orderPage.id }">
      <table cellpadding="0" cellspacing="1" class="formtable">
      <tr>
      <td align="right"><label class="Validform_label">订单号:</label></td>
      <td class="value">
        <input class="inputxt" id="orderCode" name="orderCode" value="${orderCode}" readonly="readonly">
        <span class="Validform_checktip"></span>
      </td>
      <td align="right"><label class="Validform_label">会员:</label></td>
      <td class="value">
        <select id="memberId" name="memberId" datatype="*" nullmsg="请选择会员">
          <c:forEach items="${memberList}" var="member">
            <option value="${member.id}" <c:if test="${member.id==orderPage.memberId}">selected="selected"</c:if>>${member.phone}</option>
          </c:forEach>
        </select>
        <span class="Validform_checktip"></span>
      </td>
      </tr>
      <tr>
      <td align="right"><label class="Validform_label">地址ID:</label></td>
      <td class="value">
        <select id="addressId" name="addressId" datatype="*" nullmsg="请选择会员">
          <c:forEach items="${addressList}" var="address">
            <option value="${address.id}" <c:if test="${address.id==orderPage.addressId}">selected="selected"</c:if>>${address.id}</option>
          </c:forEach>
        </select>
        <span class="Validform_checktip"></span>
      </td>
      <td align="right"><label class="Validform_label">订单总额:</label></td>
      <td class="value">
        <input class="inputxt" id="orderAmount" name="orderAmount" value="${orderPage.orderAmount}" datatype="d">
        <span class="Validform_checktip"></span>
      </td>
      </tr>
      <tr>
      <td align="right"><label class="Validform_label">商品总额:</label></td>
      <td class="value">
        <input class="inputxt" id="productAmount" name="productAmount" value="${orderPage.productAmount}" datatype="d">
        <span class="Validform_checktip"></span>
      </td>
      <td align="right"><label class="Validform_label">运费:</label></td>
      <td class="value">
        <input class="inputxt" id="shipAmount" name="shipAmount" value="${orderPage.shipAmount}" datatype="d">
        <span class="Validform_checktip"></span>
      </td>
      </tr>
      <tr>
      <td align="right"><label class="Validform_label">状态</label></td>
      <td class="value">
        <t:dictSelect field="status" typeGroupCode="orderState" hasLabel="false" defaultVal="${orderPage.status}" ></t:dictSelect>
        <span class="Validform_checktip"></span>
      </td>
      <td align="right"><label class="Validform_label">支付方式:</label></td>
      <td class="value">
        <t:dictSelect field="paymentType" typeGroupCode="payWay" hasLabel="false" defaultVal="${orderPage.paymentType}" ></t:dictSelect>
        <span class="Validform_checktip"></span>
      </td>
      </tr>
      <tr>
      <td align="right"><label class="Validform_label">支付金额:</label></td>
      <td class="value">
        <input class="inputxt" id="paymentAmount" name="paymentAmount" value="${orderPage.paymentAmount}" datatype="d">
        <span class="Validform_checktip"></span>
      </td>
      <td align="right"><label class="Validform_label">支付时间:</label></td>
      <td class="value">
        <input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width: 150px" id="paidTime" name="paidTime" ignore="ignore" value="<fmt:formatDate value='${orderPage.paidTime}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>">
        <span class="Validform_checktip"></span>
      </td>
      </tr>
      <tr style="display:none;" id='addressDetailTr'>
        <td align="right"><label class="Validform_label">详细地址:</label></td>
        <td class="value" colspan="3"><label>${addressDetail}</label></td>
      </tr>
      </table>
      <div style="width: auto;height: 200px;">
        <%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
        <div style="width:690px;height:1px;"></div>
        <t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
         <t:tab href="orderController.do?orderItemList&id=${orderPage.id}" icon="icon-search" title="商品明细" id="orderItem"></t:tab>
        </t:tabs>
      </div>
      </t:formvalid>
      <!-- 添加 明细 模版 -->
    <table style="display:none">
    <tbody id="add_orderItem_table_template">
      <tr>
       <td align="center"><div style="width: 25px;" name="xh"></div></td>
       <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
<%--           <td align="left"><input name="orderItemList[#index#].memberId" maxlength="50" type="text" style="width:120px;"></td> --%>
          <td align="left">
<%--             <input name="orderItemList[#index#].itemId" maxlength="50" type="text" style="width:120px;"> --%>
            <select name="orderItemList[#index#].itemId" datatype="*">
              <c:forEach items="${itemList}" var="item">
                <option value="${item.id}">${item.title}</option>
              </c:forEach>
            </select>
          </td>
          <td align="left"><input name="orderItemList[#index#].price" maxlength="" type="text" style="width:120px;"></td>
          <td align="left"><input name="orderItemList[#index#].qty" maxlength="" type="text" style="width:120px;"></td>
          <td align="left"><input name="orderItemList[#index#].comment" maxlength="500" type="text" style="width:120px;"></td>
<%--           <td align="left"><input name="orderItemList[#index#].shoppingCarId" maxlength="50" type="text" style="width:120px;"></td> --%>
      </tr>
     </tbody>
    </table>
 </body>