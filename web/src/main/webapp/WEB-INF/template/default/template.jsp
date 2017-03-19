<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <!--[if lt IE 9]>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js"></script><![endif]-->
    <title></title>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <link href="/css/style.css" rel="stylesheet">
    <link href="/css/bootstrap.css" rel="stylesheet"/>
    <tiles:insertAttribute name="angular" ignore="true"/>
</head>
<body>
<div class="wrapper">

    <header class="header">
        <tiles:insertAttribute name="header"/>
    </header><!-- .header-->

    <div class="middle">
        <div class="container">
            <div class="row">
                <div class="col-sm-4">
                    <tiles:insertAttribute name="menu"/>
                </div><!-- .left-sidebar -->
                <div class="col-md-8">
                    <tiles:insertAttribute name="body"/>
                </div><!-- .container-->
            </div>
        </div>
    </div><!-- .middle-->

</div><!-- .wrapper -->

<footer class="footer">
    <tiles:insertAttribute name="footer"/>
</footer><!-- .footer -->

</body>
</html>