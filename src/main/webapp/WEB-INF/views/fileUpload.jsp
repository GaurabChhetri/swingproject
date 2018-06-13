<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<hr>
 
 <form method= "post"  action="upload" enctype="multipart/form-data">
 
 File to upload:<input type="file" name="file"><br><br>
                <input type="submit" value="upload"/>
                  
 
 </form>
 
 <br><br>
 <label style="color:red">${Msg}</label>
 
</body>
</html>