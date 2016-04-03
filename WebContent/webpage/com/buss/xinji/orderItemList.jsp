<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
  $('#addOrderItemBtn').linkbutton({   
      iconCls: 'icon-add'  
  });  
  $('#delOrderItemBtn').linkbutton({   
      iconCls: 'icon-remove'  
  }); 
  $('#addOrderItemBtn').bind('click', function(){   
      var tr =  $("#add_orderItem_table_template tr").clone();
      $("#add_orderItem_table").append(tr);
      resetTrNum('add_orderItem_table');
    });  
  $('#delOrderItemBtn').bind('click', function(){   
        $("#add_orderItem_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_orderItem_table'); 
    }); 
    $(document).ready(function(){
      $(".datagrid-toolbar").parent().css("width","auto");
      if(location.href.indexOf("load=detail")!=-1){
        $(":input").attr("disabled","true");
      }
    });
</script>
<div style="padding: 3px; height: 25px;width:auto;" class="datagrid-toolbar">
  <a id="addOrderItemBtn" href="#">添加</a> <a id="delOrderItemBtn" href="#">删除</a> 
</div>
<div style="width: auto;height: 300px;overflow-y:auto;overflow-x:scroll;">
<table border="0" cellpadding="2" cellspacing="0" id="orderItem_table">
  <tr bgcolor="#E6E6E6">
    <td align="center" bgcolor="#EEEEEE">序号</td>
    <td align="center" bgcolor="#EEEEEE">操作</td>
<!--           <td align="left" bgcolor="#EEEEEE">会员ID</td> -->
          <td align="left" bgcolor="#EEEEEE">团购</td>
          <td align="left" bgcolor="#EEEEEE">价格</td>
          <td align="left" bgcolor="#EEEEEE">数量</td>
          <td align="left" bgcolor="#EEEEEE">备注</td>
<!--           <td align="left" bgcolor="#EEEEEE">购物车ID</td> -->
  </tr>
  <tbody id="add_orderItem_table">  
  <c:if test="${fn:length(orderItemList)  <= 0 }">
      <tr>
        <td align="center"><div style="width: 25px;" name="xh">1</div></td>
        <td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
<%--           <td align="left"><input name="orderItemList[0].memberId" maxlength="50" type="text" style="width:120px;" ></td> --%>
          <td align="left">
<%--             <input name="orderItemList[0].itemId" maxlength="50" type="text" style="width:120px;" > --%>
            <select name="orderItemList[0].itemId" datatype="*">
              <c:forEach items="${itemList}" var="item">
                <option value="${item.id}">${item.title}</option>
              </c:forEach>
            </select>
          </td>
          <td align="left"><input name="orderItemList[0].price" maxlength="" type="text" style="width:120px;" ></td>
          <td align="left"><input name="orderItemList[0].qty" maxlength="" type="text" style="width:120px;" ></td>
          <td align="left"><input name="orderItemList[0].comment" maxlength="500" type="text" style="width:120px;" ></td>
<%--           <td align="left"><input name="orderItemList[0].shoppingCarId" maxlength="50" type="text" style="width:120px;" ></td> --%>
         </tr>
  </c:if>
  <c:if test="${fn:length(orderItemList)  > 0 }">
    <c:forEach items="${orderItemList}" var="poVal" varStatus="stuts">
      <tr>
        <td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
        <td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
        <input name="orderItemList[${stuts.index }].id"  value="${poVal.id }" type="hidden" >
<%--            <td align="left"><input name="orderItemList[${stuts.index }].memberId" maxlength="50" value="${poVal.memberId }" type="text" style="width:120px;"></td> --%>
           <td align="left">
<%--              <input name="orderItemList[${stuts.index }].itemId" maxlength="50" value="${poVal.itemId }" type="text" style="width:120px;"> --%>
             <select name="orderItemList[${stuts.index }].itemId" datatype="*">
              <c:forEach items="${itemList}" var="item">
                <option value="${item.id}" <c:if test="${item.id==poVal.itemId}">selected="selected"</c:if>>${item.title}</option>
              </c:forEach>
            </select>
           </td>
           <td align="left"><input name="orderItemList[${stuts.index }].price" maxlength="" value="${poVal.price }" type="text" style="width:120px;"></td>
           <td align="left"><input name="orderItemList[${stuts.index }].qty" maxlength="" value="${poVal.qty }" type="text" style="width:120px;"></td>
           <td align="left"><input name="orderItemList[${stuts.index }].comment" maxlength="500" value="${poVal.comment }" type="text" style="width:120px;"></td>
<%--            <td align="left"><input name="orderItemList[${stuts.index }].shoppingCarId" maxlength="50" value="${poVal.shoppingCarId }" type="text" style="width:120px;"></td> --%>
         </tr>
    </c:forEach>
  </c:if>  
  </tbody>
</table>
</div>