<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="contactDetail.title"/></title>
    <meta name="heading" content="<fmt:message key='contactDetail.heading'/>"/>
</head>

<c:set var="delObject" scope="request"><fmt:message key="contactList.contact"/></c:set>
<script type="text/javascript">var msgDelConfirm =
   "<fmt:message key="delete.confirm"><fmt:param value="${delObject}"/></fmt:message>";
</script>

<div class="col-sm-2">
    <h2><fmt:message key="contactDetail.heading"/></h2>
    <fmt:message key="contactDetail.message"/>
</div>

<div class="col-sm-7">
<form:errors path="*" cssClass="alert alert-danger alert-dismissable" element="div"/>
<form:form commandName="contact" method="post" action="contactform" cssClass="well"
           id="contactForm" onsubmit="return validateContact(this)">
<form:hidden path="id"/>
    <spring:bind path="contact.email">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="contact.email" styleClass="control-label"/>
        <form:input cssClass="form-control" path="email" id="email"  maxlength="255"/>
        <form:errors path="email" cssClass="help-block"/>
    </div>
    <spring:bind path="contact.message">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="contact.message" styleClass="control-label"/>
        <form:input cssClass="form-control" path="message" id="message"  maxlength="255"/>
        <form:errors path="message" cssClass="help-block"/>
    </div>
    <spring:bind path="contact.name">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="contact.name" styleClass="control-label"/>
        <form:input cssClass="form-control" path="name" id="name"  maxlength="255"/>
        <form:errors path="name" cssClass="help-block"/>
    </div>
    <spring:bind path="contact.phoneNo">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="contact.phoneNo" styleClass="control-label"/>
        <form:input cssClass="form-control" path="phoneNo" id="phoneNo"  maxlength="255"/>
        <form:errors path="phoneNo" cssClass="help-block"/>
    </div>

    <div class="form-group">
        <button type="submit" class="btn btn-primary" name="save" onclick="bCancel=false">
            <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
        </button>
        <c:if test="${not empty contact.id}">
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

<v:javascript formName="contact" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value='/scripts/validator.jsp'/>"></script>

<script type="text/javascript">
    $(document).ready(function() {
        $("input[type='text']:visible:enabled:first", document.forms['contactForm']).focus();
    });
</script>
