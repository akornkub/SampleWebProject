<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="/SampleWebProject/js/jquery.min.js"></script>

<script type="text/javascript">

function getMessage() {
	var url = "/SampleWebProject/resteasy/UserProfile/" + $("#userName").val();	
    
	$.ajax({
        type: "GET",
        dataType: "json",
        url: url,
        async: false,
        contenttype: "application/x-www-form-urlencoded;charset=utf-8",
        success: function(data) {
        	alert("data=" + JSON.stringify(data));
        	var userProfile = data.userName + ", " + data.firstName + " " + data.lastName
        		+ ", " + data.email;
        	
        	$("#message").text(userProfile);
        },
        error: function() {
        }
	});
	
	$("#dentistry_activityBaseApproachTab").tabs('select', 0);
}

</script>

</head>
<body>

<input type=text id="userName" style="width:30px">
<button id="submitBtn" onclick="getMessage()">Display message</button>
<div id="message">
</div>

</body>
</html>