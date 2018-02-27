<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	
	<!-- Bootstrap -->
	<link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">

	<!-- https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js -->
    <script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
    
    <script type="text/javascript">
    
    	function aa(){
    		$("#hh").html("123123123");
    	}
    
    </script>
    
    
</head>
<body>

<div class="jumbotron">
  <h1>Hello, world!</h1>
  <p>This is a simple hero unit, a simple jumbotron-style component for calling extra attention to featured content or information.</p>
  <p><a class="btn btn-primary btn-lg" href=" javascript:void(0)" role="button">Learn more</a></p>
</div>


<span class="glyphicon glyphicon-send"></span>
<h1 id="hh">Hell</h1>
<input type="button" onclick="aa()" value="BUTTON">
<div class="alert alert-success" role="alert">提示语</div>

  <button type="button" class="btn btn-default">Left</button>
<!-- <div class="btn-group" role="group" aria-label="123123">
  <button type="button" class="btn btn-default">Middle</button>
  <button type="button" class="btn btn-default">Right</button>
</div> -->
</body>
</html>