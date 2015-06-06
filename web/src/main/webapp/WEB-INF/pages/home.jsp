<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="home.title"/></title>
    <meta name="menu" content="Home"/>
    <link rel="stylesheet" type="text/css" href="<c:url value='/styles/helpinghand/css/login.css'/>"/>
</head>

<style>
#t-cards {
    padding-top: 20px;
    padding-bottom: 20px;
    padding-left: 25%;   
    background-position: center;
    height: 300px; 
    position: centre;
}

#title{
	color:#CCFFFF; 
	border:2; 
	border-width:5px;
	border-color:#fff
}

/********************************/
/*          Panel cards         */
/********************************/
.panel.panel-card {
    position: centre;
    height: 241px;
    border: 2;
    border-width:5px;
    border-color: #fff;
    overflow: hidden;
    position: centre;
}
.panel.panel-card .panel-heading {
    position: relative;
    z-index: 2;
    height: 120px;
    border-bottom-color: #fff;
    overflow: hidden;
    
    -webkit-transition: height 600ms ease-in-out;
            transition: height 600ms ease-in-out;
}
.panel.panel-card .panel-heading img {
    position: absolute;
    top: 50%;
    left: 50%;
    z-index: 1;
    width: 120%;
    
    -webkit-transform: translate3d(-50%,-50%,0);
            transform: translate3d(-50%,-50%,0);
}
.panel.panel-card .panel-heading button {
    position: absolute;
    top: 10px;
    right: 15px;
    z-index: 3;
}
.panel.panel-card .panel-figure {
    position: absolute;
    top: auto;
    left: 50%;
    z-index: 3;
    width: 85px;
    height: 85px;
    background-color: #fff;
    border-radius: 50%;
    opacity: 1;
    -webkit-box-shadow: 0 0 0 3px #fff;
            box-shadow: 0 0 0 3px #fff;
    
    -webkit-transform: translate3d(-50%,-50%,0);
            transform: translate3d(-50%,-50%,0);
    
    -webkit-transition: opacity 400ms ease-in-out;
            transition: opacity 400ms ease-in-out;
}

.panel.panel-card .panel-body {
    padding-top: 40px;
    padding-bottom: 20px;
    background-color: #A4F99B;

    -webkit-transition: padding 400ms ease-in-out;
            transition: padding 400ms ease-in-out;
} 

.panel.panel-card .panel-thumbnails {
    padding: 0 15px 20px;
}
.panel-thumbnails .thumbnail {
    width: 60px;
    max-width: 100%;
    margin: 0 auto;
    background-color: #fff;
} 


.panel.panel-card:hover .panel-heading {
    height: 55px;
    
    -webkit-transition: height 400ms ease-in-out;
            transition: height 400ms ease-in-out;
}
.panel.panel-card:hover .panel-figure {
    opacity: 0;
    
    -webkit-transition: opacity 400ms ease-in-out;
            transition: opacity 400ms ease-in-out;
}
.panel.panel-card:hover .panel-body {
    padding-top: 20px;
    
    -webkit-transition: padding 400ms ease-in-out;
            transition: padding 400ms ease-in-out;
}
</style>
<body class="home">
<%-- 	<form method="get" action="${ctx}/afterLogin" id="searchForm" class="form-inline"> --%>
		<div align="center">
			<div>
				<h2 class="panel-header" id="title"><b><fmt:message key="home.titles"/></b></h2>
			</div>
			<section id="t-cards">
			    <div class="container">
			        <div class="row">
			             <div class="col-sm-6 col-md-3">
			                <div class="panel panel-default panel-card">
			                    <div class="panel-heading">
			                        <img src="https://unsplash.imgix.net/41/bXoAlw8gT66vBo1wcFoO_IMG_9181.jpg?q=75&fm=jpg&s=a760fd82863937c841f4b3870cdef011" />
			                        <button class="btn btn-primary btn-sm" role="button">Follow</button>
			                    </div>
			                    <div class="panel-figure">
			                        <img class="img-responsive img-circle" src="/images/Hand_GET.png" />
			                    </div>
			                    <div class="panel-body text-center">
			                        <h4 class="panel-header"><a href='<c:url value="/donationRequests"/>'><b><fmt:message key="home.getHelp"/></b></a></h4>			                        
			                    </div>
			                </div>   
			    		</div>
					    
			            <div class="col-sm-6 col-md-3">
			                <div class="panel panel-default panel-card">
			                    <div class="panel-heading">
			                        <img src="https://unsplash.imgix.net/41/bXoAlw8gT66vBo1wcFoO_IMG_9181.jpg?q=75&fm=jpg&s=a760fd82863937c841f4b3870cdef011" />
			                        <button class="btn btn-primary btn-sm" role="button">Follow</button>
			                    </div>
			                    <div class="panel-figure">
			                        <img class="img-responsive img-circle" src="/images/Hand-GIVE.png" />
			                    </div>
			                    <div class="panel-body text-center">
			                        <h4 class="panel-header"><a href='<c:url value="/donationRequestsform"/>'><b><fmt:message key="home.giveHelp"/></b></a></h4> 
			                    </div>
			            	</div>  
			    		</div>
				    </div>
			    </div>
			</section>
		</div>
<!-- 	</form> -->
</body>
</html>