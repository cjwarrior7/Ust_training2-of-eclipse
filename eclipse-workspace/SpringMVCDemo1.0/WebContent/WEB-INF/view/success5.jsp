+00000
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


    <!-- from jstl file viewall.jsp -->
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome success5 page</h1>
<c:forEach var="ele" items="${list}" >
${ele.getId() }<br>
${ele.getName()}<br>
</c:forEach>


</body>
</html>