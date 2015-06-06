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
    <!-- todo: change this to read the identifier field from the other pojo -->
    <form:select cssClass="form-control" path="category" items="categoryList" itemLabel="label" itemValue="value"/>
    <spring:bind path="donationItem.itemDescription">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="donationItem.itemDescription" styleClass="control-label"/>
        <form:input cssClass="form-control" path="itemDescription" id="itemDescription"  maxlength="255"/>
        <form:errors path="itemDescription" cssClass="help-block"/>
    </div>
    <spring:bind path="donationItem.qty">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="donationItem.qty" styleClass="control-label"/>
        <form:input cssClass="form-control" path="qty" id="qty"  maxlength="255"/>
        <form:errors path="qty" cssClass="help-block"/>
    </div>

    <div class="form-group">
        <button type="submit" class="btn btn-primary" name="save" onclick="bCancel=false">
            <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
        </button>
        <c:if test="${not empty donationItem.id}">
            <button type="submit" class="btn btn-warning" name="delete" onclick="bCancel=true;return confirmMessage(msgDelConfirm)">
                <i class="icon-trash icon-white"></i> <fmt:message key="button.delete"/>
            </button>
        </c:if>

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
