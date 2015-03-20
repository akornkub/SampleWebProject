<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="/SampleWebProject/js/jquery.min.js"></script>

<script type="text/javascript">
$(document).ready(function(){
	$("#submitBtn").click(
		function(){			
		    $.get("/SampleWebProject/spring/hello/message",
		    function(data, status){
		        //alert("Output: " + data + "\nStatus: " + status);
		        $("#message").text(data);
		    });
	});
});
</script>

</head>
<body>

<button id="submitBtn">Display message</button>: <label id="message"></label>

</body>
</html>