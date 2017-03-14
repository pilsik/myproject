<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
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
</head>
<body>
<div class="wrapper">

    <header class="header">
        <tiles:insertAttribute name="header"/>
    </header><!-- .header-->

    <div class="middle">

        <div class="container">
            <main class="content">
            <tiles:insertAttribute name="body"/>
            </main><!-- .content -->        </div><!-- .container-->

        <aside class="left-sidebar">
            <tiles:insertAttribute name="menu"/>
        </aside><!-- .left-sidebar -->

    </div><!-- .middle-->

</div><!-- .wrapper -->

<footer class="footer">
    <tiles:insertAttribute name="footer"/>
</footer><!-- .footer -->


</body>
</html>