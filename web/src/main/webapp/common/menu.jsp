<%@ include file="/common/taglibs.jsp"%>

<menu:useMenuDisplayer name="Velocity" config="navbarMenu.vm" permissions="rolesAdapter">
<div class="collapse navbar-collapse" id="navbar">
<ul class="nav navbar-nav">
    <c:if test="${empty pageContext.request.remoteUser}">
        <li class="active">
            <a href="<c:url value="/login"/>"><fmt:message key="login.title"/></a>
        </li>
    </c:if>
    <menu:displayMenu name="Home"/>
    <!--DonationRequest-START-->
    <menu:displayMenu name="DonationRequestMenu"/>
    <!--DonationRequest-END-->
    <!--DonationItem-START-->
    <menu:displayMenu name="DonationItemMenu"/>
    <!--DonationItem-END-->
    <!--Organization-START-->
    <menu:displayMenu name="OrganizationMenu"/>
    <!--Organization-END-->
    <menu:displayMenu name="UserMenu"/>
    <menu:displayMenu name="AdminMenu"/>
    <menu:displayMenu name="Logout"/>

</ul>
</div>
</menu:useMenuDisplayer>
