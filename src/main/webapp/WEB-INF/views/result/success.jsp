<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Request Success</h1>

    <div>
        <p>${result}</p>
        <div>
            <c:if test="${obj != null}">
                ${obj}
            </c:if>
        </div>
        <div>
            <a href="${pageContext.servletContext.contextPath}">Home Page</a>
        </div>
    </div>
</body>
</html>
