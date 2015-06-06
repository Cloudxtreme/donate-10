<%--
  Created by IntelliJ IDEA.
  User: aka
  Date: 6/6/15
  Time: 10:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Current Donations</title>
</head>
<body>


<display:table name="currentDonationItems" class="table table-condensed table-striped table-hover" requestURI="" id="currentDonationItems" export="true" pagesize="25">
  <display:column property="id" sortable="true" href="organizationform" media="html"
                  paramId="id" paramProperty="id" titleKey="organization.id"/>

  <display:column property="itemDescription" media="csv excel xml pdf" titleKey="organization.id"/>
  <display:column property="qty" sortable="true" titleKey="organization.contact"/>
  <display:column property="donationRequest.address" sortable="true" titleKey="organization.description"/>

  <display:setProperty name="paging.banner.item_name"><fmt:message key="organizationList.organization"/></display:setProperty>
  <display:setProperty name="paging.banner.items_name"><fmt:message key="organizationList.organizations"/></display:setProperty>

  <display:setProperty name="export.excel.filename"><fmt:message key="organizationList.title"/>.xls</display:setProperty>
  <display:setProperty name="export.csv.filename"><fmt:message key="organizationList.title"/>.csv</display:setProperty>
  <display:setProperty name="export.pdf.filename"><fmt:message key="organizationList.title"/>.pdf</display:setProperty>
</display:table>

</body>
</html>
