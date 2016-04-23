<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div id="group_product_list" class="easyui-layout" fit="true">
  <div region="center" style="padding: 1px;">
    <t:datagrid name="groupBuyingList" title="团购" actionUrl="groupBuyingController.do?datagrid" idField="id" fit="true" onLoadSuccess="loadSuccess">
     <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
     <t:dgCol title="标题" field="title"   width="120"></t:dgCol>
<%--      <t:dgCol title="副标题" field="subTitle"   width="120"></t:dgCol> --%>
<%--      <t:dgCol title="缩略图" field="thumbnail"   width="120"></t:dgCol> --%>
<%--      <t:dgCol title="轮播图片，多张图片以（|）分隔" field="bannerImgs"   width="120"></t:dgCol> --%>
     <t:dgCol title="原价" field="originalPrice"   width="120"></t:dgCol>
     <t:dgCol title="价格" field="price"   width="120"></t:dgCol>
     <t:dgCol title="单位" field="unit"   width="120"></t:dgCol>
     <t:dgCol title="分类" field="tag" dictionary="gbTags" width="80"></t:dgCol>
<%--      <t:dgCol title="详情，富文本" field="description"   width="120"></t:dgCol> --%>
     <t:dgCol title="开团人数" field="groupLimit"   width="120"></t:dgCol>
     <t:dgCol title="开始时间" field="startDate" formatter="yyyy-MM-dd"  width="120"></t:dgCol>
     <t:dgCol title="结束时间" field="endDate" formatter="yyyy-MM-dd"  width="120"></t:dgCol>
     <t:dgCol title="运费（元）" field="shipAmount"   width="120"></t:dgCol>
     <t:dgCol title="当前人数" field="currentNum"   width="120"></t:dgCol>
     <t:dgCol title="状态" field="status" dictionary="status" width="80"></t:dgCol>
     <t:dgCol title="操作" field="opt" width="140"></t:dgCol>
     <t:dgDelOpt title="删除" url="groupBuyingController.do?del&id={id}" />
     <t:dgFunOpt funname="groupProductList(id,title)" title="商品列表"></t:dgFunOpt>
     <t:dgToolBar title="录入" icon="icon-add" url="groupBuyingController.do?addorupdate" funname="add"></t:dgToolBar>
     <t:dgToolBar title="编辑" icon="icon-edit" url="groupBuyingController.do?addorupdate" funname="update"></t:dgToolBar>
     <t:dgToolBar title="查看" icon="icon-search" url="groupBuyingController.do?addorupdate" funname="detail"></t:dgToolBar>
    </t:datagrid>
  </div>
</div>
<div data-options="region:'east',
  title:'mytitle',
  collapsed:true,
  split:true,
  border:false,
  onExpand : function(){
    li_east = 1;
  },
  onCollapse : function() {
      li_east = 0;
  }"
  style="width: 400px; overflow: hidden;">
<div class="easyui-panel" style="padding: 1px;" fit="true" border="false" id="groupProductPanel"></div>
</div>
<script type="text/javascript">
    $(function() {
        var li_east = 0;
    });

    function groupProductList(groupid, groupname){
        var title = '团购: ' + groupname;
        if(li_east == 0){
            $('#group_product_list').layout('expand','east');
        }
        $('#group_product_list').layout('panel','east').panel('setTitle', title);
        $('#groupProductPanel').panel("refresh", "groupProductController.do?groupProduct&groupid=" + groupid);
    }
    function loadSuccess() {
        $('#group_product_list').layout('panel','east').panel('setTitle', "");
        $('#group_product_list').layout('collapse','east');
        $('#groupProductPanel').empty();
    }
</script>
