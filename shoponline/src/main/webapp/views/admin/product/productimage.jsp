<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>File Upload:</h3>
	Select a file to upload:
	<br />
	<form action="/admin-picProduct?productid=${idproduct }" method="post"
		enctype="multipart/form-data">
		<input type="file" name="file" size="50" /> <br /> <input
			type="submit" value="Upload File" /> <input type="hidden" value="${idproduct }"
			id="page" name="page" />
	</form>
</body>
</html>