<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/bootstrap-table.min.css" rel="stylesheet">

<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap-table.min.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap-table-zh-CN.min.js"></script>

<title>商品列表</title>

<script type="text/javascript">

$(function(){
	$('#table').bootstrapTable({
	    url: '<%=request.getContextPath()%>/item/itemList',
	    queryParams:function(params) {	//重写请求参数
	    	return params;
	    },
	    queryParamsType:'suiyi',
	    columns: [{
	        field: 'title',
	        title: '标题'
	    }, {
	        field: 'sellPoint',
	        title: '卖点'
	    },{
	        field: 'price',
	        title: '价格'
	    },{
	        field: 'num',
	        title: '库存'
	    },{
	        field: 'cid',
	        title: 'cid'
	    },{
	        field: 'image',
	        title: '图片'
	    },],
	    pagination: 'ture',		//启用分页 
	    sidePagination: 'server',	//服务端分页，设置这个后，服务器请求的参数需要有total和rows
	    striped: 'ture',		//隔行变色
	    showRefresh: true,     //是否显示刷新按钮
	    search: true, //启用搜索框 
	    searchOnEnterKey: true, //按回车键才搜索 ！ 
	    //searchText : '标题', // 初始化搜索
	});
});


</script>

</head>
<body>
<!-- <div class="container">
	<div class="row">
		
	</div>
</div> -->
<h1>商品列表</h1>
<table id="table"></table>
</body>
</html>