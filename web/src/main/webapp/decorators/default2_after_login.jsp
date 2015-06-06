<!DOCTYPE html>
<%@ include file="/common/taglibs.jsp"%>



<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Helping Hand</title>

  <!-- Bootstrap Core CSS - Uses Bootswatch Flatly Theme: http://bootswatch.com/flatly/ -->
  <link href="${base}/styles/helpinghand/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom CSS -->
  <link href="${base}/styles/helpinghand/css/freelancer.css" rel="stylesheet">

  <!-- Custom Fonts -->
  <link href="${base}/styles/helpinghand/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <link href="http://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
  <link href="http://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
  <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
  <![endif]-->




  <decorator:head/>


</head>

<body id="page-top" class="index">

  <!-- Navigation -->
  <nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
      <!-- Brand and toggle get grouped for better mobile display -->
      <div class="navbar-header page-scroll">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="#page-top">Helping Hand Ninjas</a>
      </div>

      <!-- Collect the nav links, forms, and other content for toggling -->
      <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <%@ include file="/common/menu.jsp" %>
      </div>
      <!-- /.navbar-collapse -->
    </div>
    <!-- /.container-fluid -->
  </nav>

  <!-- Header -->
  <header>
    <div class="container">
      <div class="row">
        <decorator:body/>
      </div>
    </div>
  </header>



<!-- Footer -->
<footer class="text-center">
  <div class="footer-above">
    <div class="container">
      <div class="row">
        <div class="footer-col col-md-4">
          <h3>Location</h3>
          <p>3481 Melrose Place<br>Beverly Hills, CA 90210</p>
        </div>
        <div class="footer-col col-md-4">
          <h3>Around the Web</h3>
          <ul class="list-inline">
            <li>
              <a href="#" class="btn-social btn-outline"><i class="fa fa-fw fa-facebook"></i></a>
            </li>
            <li>
              <a href="#" class="btn-social btn-outline"><i class="fa fa-fw fa-google-plus"></i></a>
            </li>
            <li>
              <a href="#" class="btn-social btn-outline"><i class="fa fa-fw fa-twitter"></i></a>
            </li>
            <li>
              <a href="#" class="btn-social btn-outline"><i class="fa fa-fw fa-linkedin"></i></a>
            </li>
            <li>
              <a href="#" class="btn-social btn-outline"><i class="fa fa-fw fa-dribbble"></i></a>
            </li>
          </ul>
        </div>
        <div class="footer-col col-md-4">
          <h3>About Freelancer</h3>
          <p>Freelance is a free to use, open source Bootstrap theme created by <a href="http://startbootstrap.com">Start Bootstrap</a>.</p>
        </div>
      </div>
    </div>
  </div>
  <div class="footer-below">
    <div class="container">
      <div class="row">
        <div class="col-lg-12">
          Copyright &copy; Your Website 2014
        </div>
      </div>
    </div>
  </div>
</footer>



<!-- jQuery -->
<script src="${base}/styles/helpinghand/js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="${base}/styles/helpinghand/js/bootstrap.min.js"></script>

<!-- Plugin JavaScript -->
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
<script src="${base}/styles/helpinghand/js/classie.js"></script>
<script src="${base}/styles/helpinghand/js/cbpAnimatedHeader.js"></script>

<!-- Contact Form JavaScript -->
<script src="${base}/styles/helpinghand/js/jqBootstrapValidation.js"></script>
<script src="${base}/styles/helpinghand/js/contact_me.js"></script>

<!-- Custom Theme JavaScript -->
<script src="${base}/styles/helpinghand/js/freelancer.js"></script>

</body>

</html>
