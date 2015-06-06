<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="donationItemList.title"/></title>
    <meta name="menu" content="DonationItemMenu"/>
</head>

<c:if test="{'$'}{not empty searchError}">
    <div class="alert alert-danger alert-dismissable">
        <a href="#" data-dismiss="alert" class="close">&times;</a>
        <c:out value="{'$'}{searchError}"/>
    </div>
</c:if>

<div class="col-sm-11">
    <h2><fmt:message key="donationItemList.heading"/></h2>

    <form method="get" action="${ctx}/donationItems" id="searchForm" class="form-inline">
    <div id="search" class="text-right">
        <span class="col-sm-9">
            <input type="text" size="20" name="q" id="query" value="${param.q}"
                   placeholder="<fmt:message key="search.enterTerms"/>" class="form-control input-sm"/>
        </span>
        <button id="button.search" class="btn btn-sm" type="submit">
            <i class="icon-search"></i> <fmt:message key="button.search"/>
        </button>
    </div>
    </form>

    <fmt:message key="donationItemList.message"/>

    <br/><br/>
    <div id="actions" class="btn-group">
        <a href='<c:url value="/donationItemform"/>' class="btn btn-primary">
            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/></a>
        <a href='<c:url value="/home"/>' class="btn btn-default"><i class="icon-ok"></i> <fmt:message key="button.done"/></a>
    </div>

<display:table name="donationItemList" class="table table-condensed table-striped table-hover" requestURI="" id="donationItemList" export="true" pagesize="25">
    <display:column titleKey="donationItem.donate">
    <a href='<c:url value="/donationItemform?id=${donationItemList.id}"/>' class="btn btn-primary btn-sm">
        <i class="icon-plus icon-white"></i> <fmt:message key="button.donate"/></a>
    </display:column>
    <%--<display:column property="id" sortable="true" href="donationItemform" media="html"--%>
        <%--paramId="id" paramProperty="id" titleKey="donationItem.id"/>--%>
    <%--<display:column property="id" media="csv excel xml pdf" titleKey="donationItem.id"/>--%>
    <display:column property="itemDescription" sortable="true" titleKey="donationItem.itemDescription"/>
    <display:column property="qty" sortable="true" titleKey="donationItem.qty"/>
    <display:column property="donationRequest.user.username" sortable="true" titleKey="user.username"/>
    <display:column sortProperty="donationRequest.registeredDate" sortable="true" titleKey="donationRequest.registeredDate">
        <fmt:formatDate value="${donationItemList.donationRequest.registeredDate}" pattern="${datePattern}"/>
    </display:column>
    <display:column sortProperty="donationRequest.expiredDate" sortable="true" titleKey="donationRequest.expiredDate">
        <fmt:formatDate value="${donationItemList.donationRequest.expiredDate}" pattern="${datePattern}"/>
    </display:column>
   <display:column titleKey="donationItem.donated">
        <c:choose>
            <c:when test="${not empty donationItemList.donatorUserId}">DONATED!</c:when>
            <c:otherwise>OPEN!</c:otherwise>
        </c:choose>

   </display:column>


    <display:setProperty name="paging.banner.item_name"><fmt:message key="donationItemList.donationItem"/></display:setProperty>
    <display:setProperty name="paging.banner.items_name"><fmt:message key="donationItemList.donationItems"/></display:setProperty>

    <display:setProperty name="export.excel.filename"><fmt:message key="donationItemList.title"/>.xls</display:setProperty>
    <display:setProperty name="export.csv.filename"><fmt:message key="donationItemList.title"/>.csv</display:setProperty>
    <display:setProperty name="export.pdf.filename"><fmt:message key="donationItemList.title"/>.pdf</display:setProperty>
</display:table>
