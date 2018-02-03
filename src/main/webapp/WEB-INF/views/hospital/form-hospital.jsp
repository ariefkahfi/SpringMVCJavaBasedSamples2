<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form Hospital</title>
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
                Form Hospital Page
            </div>
            <div class="container container-bordered container-margin-bottom">
                Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusamus alias cum debitis, delectus deserunt illum laborum necessitatibus nihil nisi optio pariatur porro, quae quibusdam reprehenderit ullam unde ut vero vitae?
            </div>
        </div>
        <div class="center-container">
            <div class="container-bordered">
                <div class="form-wrapper">
                    <form:form modelAttribute="hospital" method="post" action="${pageContext.request.contextPath}/hospital/form-hospital">
                        <div class="form-row clearfix">
                            <label for="hospital_id" class="form-label-left">Hospital ID</label>
                            <form:input path="hospitalId" id="hospital_id" cssClass="form-input-left"/>
                            <span>
                                <form:errors path="hospitalId"/>
                            </span>
                        </div>
                        <div class="form-row clearfix">
                            <label for="hospital_name" class="form-label-left">Hospital Name</label>
                            <form:input path="hospitalName" id="hospital_name" cssClass="form-input-left"/>
                            <span>
                                <form:errors path="hospitalName"/>
                            </span>
                        </div>
                        <div class="form-row clearfix">
                            <label for="hospital_address" class="form-label-left">Hospital Address</label>
                            <form:input path="hospitalAddress" id="hospital_address" cssClass="form-input-left"/>
                            <span>
                                <form:errors path="hospitalAddress"/>
                            </span>
                        </div>
                        <div class="form-row">
                            <input type="submit" value="Submit Data" class="form-button"/>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>

</body>
    <script src="${pageContext.servletContext.contextPath}/resources/js/global.js" type="text/javascript"></script>
</html>
