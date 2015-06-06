<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="donationItemDetail.title"/></title>
    <meta name="heading" content="<fmt:message key='donationItemDetail.heading'/>"/>
</head>

<c:set var="delObject" scope="request"><fmt:message key="donationItemList.donationItem"/></c:set>
<script type="text/javascript">var msgDelConfirm =
   "<fmt:message key="delete.confirm"><fmt:param value="${delObject}"/></fmt:message>";
</script>

<div class="col-sm-2">
    <h2><fmt:message key="donationItemDetail.heading"/></h2>
    <fmt:message key="donationItemDetail.message"/>
</div>

<div class="col-sm-7">
<form:errors path="*" cssClass="alert alert-danger alert-dismissable" element="div"/>
<form:form commandName="donationItem" method="post" action="donationItemform" cssClass="well"
           id="donationItemForm" onsubmit="return validateDonationItem(this)">
<form:hidden path="id"/>
    <%--<!-- todo: change this to read the identifier field from the other pojo -->--%>
    <%--<form:select cssClass="form-control" path="category" items="categoryList" itemLabel="label" itemValue="value"/>--%>
    <spring:bind path="donationItem.itemDescription">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="donationItem.itemDescription" styleClass="control-label"/>
        <form:input cssClass="form-control" path="itemDescription" id="itemDescription"  maxlength="255" readonly="true"/>
        <form:errors path="itemDescription" cssClass="help-block"/>
    </div>
    <spring:bind path="donationItem.qty">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="donationItem.qty" styleClass="control-label"/>
        <form:input cssClass="form-control" path="qty" id="qty"  maxlength="255" readonly="true"/>
        <form:errors path="qty" cssClass="help-block"/>
    </div>

    <hr/>


    <spring:bind path="donationRequest.user.username">
        <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
    <appfuse:label key="donationItem.userReq" styleClass="control-label"/>
    <form:input cssClass="form-control" path="donationRequest.user.username" id="qty"  maxlength="255" readonly="true"/>
    <form:errors path="donationRequest.user.username" cssClass="help-block"/>
    </div>


    <div class="row">
        <div class="col-sm-6">
            <spring:bind path="donationRequest.registeredDate">
            <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
                </spring:bind>
                <appfuse:label key="donationRequest.registeredDate" styleClass="control-label"/>
                <form:input cssClass="form-control" path="donationRequest.registeredDate" id="qty"  maxlength="255" readonly="true"/>
                <form:errors path="donationRequest.registeredDate" cssClass="help-block"/>
            </div>
        </div>
        <div class="col-sm-6">
            <spring:bind path="donationRequest.expiredDate">
            <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
                </spring:bind>
                <appfuse:label key="donationRequest.expiredDate" styleClass="control-label"/>
                <form:input cssClass="form-control" path="donationRequest.expiredDate" id="qty"  maxlength="255" readonly="true"/>
                <form:errors path="donationRequest.expiredDate" cssClass="help-block"/>
            </div>
        </div>
    </div>

    <div class="form-group">
        <appfuse:label styleClass="control-label" key="user.address.address"/>
        <form:input cssClass="form-control" path="donationRequest.user.address.address" id="address.address" readonly="true"/>
    </div>
    <div class="row">
        <div class="col-sm-7 form-group">
            <appfuse:label styleClass="control-label" key="user.address.city"/>
            <form:input cssClass="form-control" path="donationRequest.user.address.city" id="address.city" readonly="true"/>
        </div>
        <div class="col-sm-2 form-group">
            <appfuse:label styleClass="control-label" key="user.address.province"/>
            <form:input cssClass="form-control" path="donationRequest.user.address.province" id="address.province" readonly="true"/>
        </div>
        <div class="col-sm-3 form-group">
            <appfuse:label styleClass="control-label" key="user.address.postalCode"/>
            <form:input cssClass="form-control" path="donationRequest.user.address.postalCode" id="address.postalCode" readonly="true"/>
        </div>
    </div>
    <div class="form-group">
        <appfuse:label styleClass="control-label" key="user.address.country"/>
        <form:input cssClass="form-control" path="donationRequest.user.address.country" readonly="true"/>
    </div>

    <hr/>
    <c:if test="${not empty donationItem.donatorUser.username}">
        <div class="row">
            <div class="col-sm-6">
                <spring:bind path="donatorUser.username">
                <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
                    </spring:bind>
                    <appfuse:label key="donationItem.userDon" styleClass="control-label"/>
                    <form:input cssClass="form-control" path="donatorUser.username" id="qty"  maxlength="255" readonly="true"/>
                    <form:errors path="donatorUser.username" cssClass="help-block"/>
                </div>
            </div>
            <div class="col-sm-6">
                <spring:bind path="donatedDate">
                <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
                    </spring:bind>
                    <appfuse:label key="donationItem.donatedDate" styleClass="control-label"/>
                    <form:input cssClass="form-control" path="donatedDate" id="qty"  maxlength="255" readonly="true"/>
                    <form:errors path="donatedDate" cssClass="help-block"/>
                </div>
            </div>
        </div>
    </c:if>

<hr/>

    <div class="form-group">
        <c:if test="${empty donationItem.donatorUser.id}">
            <button type="submit" class="btn btn-warning" name="donate" onclick="bCancel=false">
                <i class="icon-ok icon-white"></i> <fmt:message key="button.donate"/>
            </button>
        </c:if>


        <%--<button type="submit" class="btn btn-primary" name="save" onclick="bCancel=false">--%>
            <%--<i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>--%>
        <%--</button>--%>
        <%--<c:if test="${not empty donationItem.id}">--%>
            <%--<button type="submit" class="btn btn-warning" name="delete" onclick="bCancel=true;return confirmMessage(msgDelConfirm)">--%>
                <%--<i class="icon-trash icon-white"></i> <fmt:message key="button.delete"/>--%>
            <%--</button>--%>
        <%--</c:if>--%>

        <button type="submit" class="btn btn-default" name="cancel" onclick="bCancel=true">
            <i class="icon-remove"></i> <fmt:message key="button.cancel"/>
        </button>
    </div>
</form:form>
</div>

<v:javascript formName="donationItem" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value='/scripts/validator.jsp'/>"></script>

<script type="text/javascript">
    $(document).ready(function() {
        $("input[type='text']:visible:enabled:first", document.forms['donationItemForm']).focus();
    });
</script>
