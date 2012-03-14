<%@ page import="com.thepig.Person" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'person.label', default: 'Person')}" />
		<title>Change Password</title>
	</head>
	<body>
		<a href="#edit-person" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div id="edit-person" class="content scaffold-edit" role="main">
			<h1>Change Password</h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${personInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${personInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form method="post" controller="person" action="update" >
				<g:hiddenField name="id" value="${personInstance?.id}" />
				<g:hiddenField name="version" value="${personInstance?.version}" />
				<fieldset class="form">
					<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'password', 'error')} required">
						<label for="password">
							<g:message code="person.password.label" default="Password" />
							<span class="required-indicator">*</span>
						</label>
						<g:textField name="password" required="" value=""/>
					</div>
				</fieldset>
				<fieldset class="buttons">
					<g:actionSubmit class="save" controller="person" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
