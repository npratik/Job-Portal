<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Document Manager - viralpatel.net</title>
</head>
<body>
 
<h2>Document Manager</h2>
 
<h3>Add new document</h3>
<!--<form:form action="save.html" commandName="jobseeker" enctype="multipart/form-data"> </form:form>-->
<form:form>
   <table> 
    <tr>
        <td><form:label path="content">Document</form:label></td>
        <td><input type="file" name="file" id="file"></input></td>
    </tr>
   
</table>  
</form:form>
 
<br/>
<h3>Document List</h3>

</body>
</html>