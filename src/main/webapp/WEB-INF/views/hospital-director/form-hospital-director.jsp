<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form Hospital Director</title>
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
                Form Hospital's Director Page
            </div>
            <div class="container container-bordered container-margin-bottom">
                Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusamus alias cum debitis, delectus deserunt illum laborum necessitatibus nihil nisi optio pariatur porro, quae quibusdam reprehenderit ullam unde ut vero vitae?
            </div>
        </div>
        <div class="center-container">

            <div class="container-bordered container-margin-bottom">
                <div class="form-wrapper">
                    <form method="post" action="${pageContext.request.contextPath}/hospital-director/form-hospital-director">
                        <div class="form-row clearfix">
                            <label for="director_name" class="form-label-left">Director Name</label>
                            <input type="text" name="director_name" class="form-input-left" id="director_name"/>
                        </div>
                        <div class="form-row clearfix">
                            <label for="director_hospital" class="form-label-left">Hospital List</label>
                            <select name="director_hospital" id="director_hospital" class="form-input-left">
                                <c:forEach var="hospital" items="${hospitalList}">
                                    <option value="${hospital.hospitalId}">${hospital.hospitalName}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-row">
                            <input type="submit" value="Submit Data" onclick="return submitHD()" class="form-button"/>
                        </div>
                    </form>
                </div>
            </div>

            <div class="container-bordered">
                <table class="table" border="2">
                    <tr>
                        <td>Director Name</td>
                        <td>Hospital Name</td>
                        <td>Hospital Address</td>
                    </tr>
                    <c:forEach items="${hospitalDirectorList}" var="hd">
                        <tr>
                            <td>${hd.directorName}</td>
                            <td>${hd.hospital.hospitalName}</td>
                            <td>${hd.hospital.hospitalAddress}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>

        </div>
    </div>

</body>
    <script src="${pageContext.servletContext.contextPath}/resources/js/global.js"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/js/hd.js"></script>
</html>
