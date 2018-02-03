<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form Doctor Page</title>
    <link href="https://fonts.googleapis.com/css?family=Lobster" rel="stylesheet"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/global.css"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/form.css"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/responsive.css"/>
</head>
<body>

    <nav id="top-navbar">
        <div class="wrapper clearfix">
            <h1 id="top-navbar-title">Spring MVC WebApp</h1>
            <div id="top-navbar-right-button-container">
                <button id="top-navbar-button-home" class="button button-bordered-white">
                    <i class="fa fa-home fa-fw" id="home-page"></i>Home Page
                </button>
                <button id="top-navbar-button-contact" class="button button-bordered-white">
                    <i class="fa fa-phone fa-fw"></i>
                    Contact Us
                </button>
            </div>
        </div>
    </nav>

    <div class="wrapper clearfix" id="main-container">
        <div id="inner-left-container">
            <div class="container container-bordered container-margin-bottom">
                Form Doctor Page
            </div>
            <div class="container container-bordered container-margin-bottom">
                Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusamus alias cum debitis, delectus deserunt illum laborum necessitatibus nihil nisi optio pariatur porro, quae quibusdam reprehenderit ullam unde ut vero vitae?
            </div>
        </div>
        <div class="center-container">
            <div class="container-bordered">
                <div class="form-wrapper">
                    <form:form modelAttribute="doctor" method="post" action="${pageContext.request.contextPath}/doctor/form-doctor">
                        <div class="form-row clearfix">
                            <label for="doctor_id" class="form-label-left">Doctor ID</label>
                            <form:input path="doctorId" id="doctor_id" cssClass="form-input-left"/>
                            <span>
                                <form:errors path="doctorId"/>
                            </span>
                        </div>
                        <div class="form-row clearfix">
                            <label for="doctor_name" class="form-label-left">Doctor Name</label>
                            <form:input path="doctorName" id="doctor_name" cssClass="form-input-left"/>
                            <span>
                                <form:errors path="doctorName"/>
                            </span>
                        </div>
                        <div class="form-row clearfix">
                            <label for="doctor_hospital" class="form-label-left">Choose hospital</label>
                            <select name="doctor_hospital" id="doctor_hospital" class="form-input-left">
                                <c:forEach var="hospital" items="${hospitalList}">
                                    <option value="${hospital.hospitalId}">${hospital.hospitalName}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-row">
                            <input type="submit" value="Submit Data" onclick="return submitDoctor()" class="form-button"/>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>

</body>
    <script src="${pageContext.servletContext.contextPath}/resources/js/global.js"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/js/doctor.js"></script>
</html>
