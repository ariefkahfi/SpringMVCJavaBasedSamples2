<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index Page</title>
    <link href="https://fonts.googleapis.com/css?family=Lobster" rel="stylesheet"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/global.css"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/form.css"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/responsive.css"/>
</head>
<body>
    <c:import url="/resources/html/top-navbar.html"/>


    <div class="wrapper clearfix" id="main-container">
        <c:import url="/resources/html/left-sidebar.html"/>

        <div id="inner-center-container" class="clearfix">
            <div class="card">
                <img src="${pageContext.servletContext.contextPath}/resources/images/hospital.png" class="card-image"/>
                <div class="card-desc">
                    <div>Page Hospital</div>
                </div>
            </div>
            <div class="card">
                <img src="${pageContext.servletContext.contextPath}/resources/images/doctor.png" class="card-image"/>
                <div class="card-desc">
                    <div>Page Doctor</div>
                </div>
            </div>
            <div class="card">
                <img src="${pageContext.servletContext.contextPath}/resources/images/director.png" class="card-image"/>
                <div class="card-desc">
                    <div>Page Hospital's Director</div>
                </div>
            </div>
        </div>

        <c:import url="/resources/html/right-sidebar.html"/>

    </div>






</body>
</html>
