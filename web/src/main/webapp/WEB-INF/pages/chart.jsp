<%@ include file="/common/taglibs.jsp"%>
<c:set var="base" value="${pageContext.request.contextPath}"/>

<link rel="stylesheet" href="${base}/scripts/morris.js-0.5.1/morris.css">
<script src="${base}/scripts/morris.js-0.5.1/morris.min.js"></script>
<script 
    src="http://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js">
</script>



<head>
  <title><fmt:message key="home.title"/></title>
  <meta name="menu" content="Home"/>
  <t:assets/>
</head>
<body class="home">

<div class="span6">
    <div class="graph-container">
      <div class="caption">Donut flavours</div>
      <div id="hero-donut" class="graph"></div>
    </div>
  </div>
  
  
  <script>
$( document ).ready(function() {
    console.log( "ready!" );
    
    Morris.Donut({
    	  element: 'hero-donut',
    	  data: [
    	    {label: "Download Sales", value: 12},
    	    {label: "In-Store Sales", value: 30},
    	    {label: "Mail-Order Sales", value: 20}
    	  ]
    	});
});

</script>
</body>



