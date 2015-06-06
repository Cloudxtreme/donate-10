<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="donationRequestDetail.title"/></title>
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
<form:form commandName="donationRequest" method="post" action="donationRequestform" cssClass="well"
           id="donationRequestForm" onsubmit="return validateDonationRequest(this)">
<form:hidden path="id"/>
    <spring:bind path="donationRequest.expiredDate">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="donationRequest.expiredDate" styleClass="control-label"/>
        <form:input cssClass="form-control" path="expiredDate" id="expiredDate" size="11" title="date" datepicker="true"/>
        <form:errors path="expiredDate" cssClass="help-block"/>
    </div>
    <spring:bind path="donationRequest.registeredDate">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="donationRequest.registeredDate" styleClass="control-label"/>
        <form:input cssClass="form-control" path="registeredDate" id="registeredDate" size="11" title="date" datepicker="true"/>
        <form:errors path="registeredDate" cssClass="help-block"/>
    </div>
    <spring:bind path="donationRequest.userId">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="donationRequest.userId" styleClass="control-label"/>
        <form:input cssClass="form-control" path="userId" id="userId"  maxlength="255"/>
        <form:errors path="userId" cssClass="help-block"/>
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

<v:javascript formName="donationRequest" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value='/scripts/validator.jsp'/>"></script>

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/webjars/bootstrap-datepicker/1.2.0/css/datepicker.css'/>" />
<script type="text/javascript" src="<c:url value='/webjars/bootstrap-datepicker/1.2.0/js/bootstrap-datepicker.js'/>"></script>
<c:if test="${pageContext.request.locale.language != 'en'}">
<script type="text/javascript" src="<c:url value='/webjars/bootstrap-datepicker/1.2.0/js/locales/bootstrap-datepicker.${pageContext.request.locale.language}.js'/>"></script>
</c:if>
<script type="text/javascript">
    $(document).ready(function() {
        $("input[type='text']:visible:enabled:first", document.forms['donationRequestForm']).focus();
        $('.text-right.date').datepicker({format: "<fmt:message key='calendar.format'/>", weekStart: "<fmt:message key='calendar.weekstart'/>", language: '${pageContext.request.locale.language}'});
    });
</script>
