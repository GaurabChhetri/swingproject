<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Student Form</h1>
<hr>

<spring:form action="${pageContext.request.contextPath }/update" method="post" modelAttribute="stud">
<table>
<tr>
<td><spring:label path="fname">FirstName</spring:label></td>
<td><spring:input path="fname"/></td>
</tr>
<tr>
<td><spring:label path="lname">LastName</spring:label></td>
<td><spring:input path="lname"/></td>
</tr>

<tr>
<td><spring:label path="gender">Gender</spring:label></td>
<td>

      <spring:radiobutton path="gender" value="male"/>Male
     <spring:radiobutton path="gender" value="female"/>Female
      </td>
</tr>

<tr>
<td><spring:label path="dob">DOB</spring:label></td>
<td><spring:input path="dob" type="date"/></td>
</tr>


<tr>
<td><spring:label path="phone">Phone</spring:label></td>
<td><spring:input path="phone"/></td>
</tr>

<tr>
<td><spring:label path="college">College</spring:label></td>
<td><spring:input path="college"/></td>
</tr>

<tr>
<td><spring:label path="semester">Semester</spring:label></td>
<td><spring:input path="semester"/></td>
</tr>

<tr>
<td><spring:label path="faculty">Faculty</spring:label></td>
<td><spring:input path="faculty"/></td>
</tr>

<tr>
<td><spring:label path="rollno">rollno</spring:label></td>
<td><spring:input path="rollno" type="number"/></td>
</tr>

<tr>

<td><input type="submit" value=update></td>
</tr>
</table>


<spring:hidden path="id"/>

</spring:form>
</body>
</html>