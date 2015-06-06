<%@ include file="/common/taglibs.jsp"%>

<head>
    <meta name="heading" content="<fmt:message key='donationRequestDetail.heading'/>"/>
</head>

<c:set var="delObject" scope="request"><fmt:message key="donationRequestList.donationRequest"/></c:set>
<script type="text/javascript">var msgDelConfirm =
        "<fmt:message key="delete.confirm"><fmt:param value="${delObject}"/></fmt:message>";
</script>

<div class="col-sm-2">
    <h2><fmt:message key="donationRequestDetail.heading"/></h2>
    <fmt:message key="donationRequestDetail.message"/>
</div>

<div class="col-sm-7">
    <form:errors path="*" cssClass="alert alert-danger alert-dismissable" element="div"/>
    <form:form commandName="donationItem" method="post" action="donationRequestItemForm" cssClass="well"
               id="donationRequestItemForm">
        <form:hidden path="id"/>
        <spring:bind path="donationItem.itemDescription">
            <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
        </spring:bind>
        <appfuse:label key="donationItem.itemDescription" styleClass="control-label"/>
        <form:input cssClass="form-control" path="itemDescription" id="itemDescription" size="30" title="itemDescription"/>
        <form:errors path="itemDescription" cssClass="help-block"/>
        </div>

        <spring:bind path="donationItem.qty">
            <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
        </spring:bind>
        <appfuse:label key="donationRequest.qty" styleClass="control-label"/>
        <form:input cssClass="form-control" path="qty" id="qty" size="11" title="qty"/>
        <form:errors path="qty" cssClass="help-block"/>
        </div>

        <div class="form-group">
            <button type="submit" class="btn btn-primary" name="save" onclick="bCancel=false">
                <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
            </button>
            <c:if test="${not empty donationRequest.id}">
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