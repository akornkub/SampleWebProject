<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="/SampleWebProject/userprofile/css/themes/default/easyui.css" />
<script type="text/javascript" src="/SampleWebProject/userprofile/js/jquery.min.js"></script>  
<script type="text/javascript" src="/SampleWebProject/userprofile/js/jquery.easyui.min.js"></script>

<style>
#formTitle {
    color: orange;
    font-weight: bold;
    margin-bottom: 15px;
}

.formElement {
	font-size: 16px;
}

.formLabel {
	margin-right:15px;
}

.submitBtn {
	font-size: 16px;
	margin-top: 15px;
	margin-left: 90px;
}
</style>

<script type="text/javascript">
$(document).ready(function(){
	$("#userProfileFormSubmitBtn").click(
		function(){
			userNameVal = $("#userNameTF").val();
			passwordVal = $("#passwordTF").val();
			firstNameVal = $("#firstNameTF").val();
			lastNameVal = $("#lastNameTF").val();
			emailVal = $("#emailTF").val();

			var userProfile = {};
			userProfile.userName = userNameVal;
			userProfile.password = passwordVal;
			userProfile.firstName = firstNameVal;
			userProfile.lastName = lastNameVal;
			userProfile.email = emailVal;

			alert(JSON.stringify(userProfile));

			var request = $.ajax({
	            type: "POST",
	            url: "/SampleWebProject/resteasy/UserProfile",
	            contentType: 'application/json',
	            data: JSON.stringify(userProfile),
	            dataType: "application/json"
	        });
	        request.always(function(data) {
	        	if (data.statusText == 'OK') {
	            	alert("บันทึกรายการเรียบร้อย");
	        	} else {
	        		alert("พบข้อผิดพลาด ไม่สามารถบันทึกรายการได้");
	        	}
	        });
	});
});
</script>

<title>Insert title here</title>
</head>
<body>
	<div id="formTitle">
		<label>User Profile Form</label>
	</div>
	<div class="formElement">
        <label for="userNameTF" class="formLabel">User name:</label>
        <input class="easyui-validatebox" type="text" id="userNameTF" data-options="required:true" />
    </div>
    <div class="formElement">
        <label for="passwordTF" class="formLabel">Password:</label>
        <input class="easyui-validatebox" type="password" id="passwordTF" data-options="required:true" />
    </div>
    <div class="formElement">
        <label for="firstNameTF" class="formLabel">First name:</label>
        <input class="easyui-validatebox" type="text" id="firstNameTF" data-options="required:true" />
    </div>
    <div class="formElement">
        <label for="lastNameTF" class="formLabel">Last name:</label>
        <input class="easyui-validatebox" type="text" id="lastNameTF" data-options="required:true" />
    </div>
    <div class="formElement">
        <label for="emailTF" class="formLabel" style="margin-right:42px;">Email:</label>
        <input class="easyui-validatebox" type="text" id="emailTF" data-options="validType:'email'" />
    </div>
    <div class="submitBtn">
    	<button id="userProfileFormSubmitBtn">Submit</button>
    </div>
</form>
</body>
</html>