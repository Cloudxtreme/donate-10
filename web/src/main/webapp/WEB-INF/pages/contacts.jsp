<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="contactList.title"/></title>
    <meta name="menu" content="ContactMenu"/>
</head>

<c:if test="{'$'}{not empty searchError}">
    <div class="alert alert-danger alert-dismissable">
        <a href="#" data-dismiss="alert" class="close">&times;</a>
        <c:out value="{'$'}{searchError}"/>
    </div>
</c:if>

<div class="col-sm-10">
    <h2><fmt:message key="contactList.heading"/></h2>

    <form method="get" action="${ctx}/contacts" id="searchForm" class="form-inline">
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

    <fmt:message key="contactList.message"/>

    <br/><br/>
    <div id="actions" class="btn-group">
        <a href='<c:url value="/contactform"/>' class="btn btn-primary">
            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/></a>
        <a href='<c:url value="/home"/>' class="btn btn-default"><i class="icon-ok"></i> <fmt:message key="button.done"/></a>
    </div>

<display:table name="contactList" class="table table-condensed table-striped table-hover" requestURI="" id="contactList" export="true" pagesize="25">
    <display:column property="id" sortable="true" href="contactform" media="html"
        paramId="id" paramProperty="id" titleKey="contact.id"/>
    <display:column property="id" media="csv excel xml pdf" titleKey="contact.id"/>
    <display:column property="email" sortable="true" titleKey="contact.email"/>
    <display:column property="message" sortable="true" titleKey="contact.message"/>
    <display:column property="name" sortable="true" titleKey="contact.name"/>
    <display:column property="phoneNo" sortable="true" titleKey="contact.phoneNo"/>

    <display:setProperty name="paging.banner.item_name"><fmt:message key="contactList.contact"/></display:setProperty>
    <display:setProperty name="paging.banner.items_name"><fmt:message key="contactList.contacts"/></display:setProperty>

    <display:setProperty name="export.excel.filename"><fmt:message key="contactList.title"/>.xls</display:setProperty>
    <display:setProperty name="export.csv.filename"><fmt:message key="contactList.title"/>.csv</display:setProperty>
    <display:setProperty name="export.pdf.filename"><fmt:message key="contactList.title"/>.pdf</display:setProperty>
</display:table>
