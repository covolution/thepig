<%@ page import="com.thepig.Person" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'person.label', default: 'Person')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#create-person" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div id="create-person" class="content scaffold-create" role="main">
			<h1>User Registration</h1>
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
			<g:form action="save" >
				<fieldset class="form">
					<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'username', 'error')} required">
						<label for="username">
							<g:message code="person.username.label" default="Username" />
							<span class="required-indicator">*</span>
						</label>
						<g:textField name="username" required="" value="${personInstance?.username}"/>
					</div>

					<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'password', 'error')} required">
						<label for="password">
							<g:message code="person.password.label" default="Password" />
							<span class="required-indicator">*</span>
						</label>
						<g:textField name="password" required="" value="${personInstance?.password}"/>
					</div>

					<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'forename', 'error')} required">
						<label for="forename">
							<g:message code="person.forename.label" default="Forename" />
							<span class="required-indicator">*</span>
						</label>
						<g:textField name="forename" required="" value="${personInstance?.forename}"/>
					</div>

					<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'surname', 'error')} required">
						<label for="surname">
							<g:message code="person.surname.label" default="Surname" />
							<span class="required-indicator">*</span>
						</label>
						<g:textField name="surname" required="" value="${personInstance?.surname}"/>
					</div>

					<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'email', 'error')} required">
						<label for="email">
							<g:message code="person.email.label" default="Email" />
							<span class="required-indicator">*</span>
						</label>
						<g:field type="email" name="email" required="" value="${personInstance?.email}"/>
					</div>
					<g:hiddenField name="enabled" value="${personInstance?.enabled}" />
				</fieldset>
				<fieldset class="buttons">
					<g:submitButton name="create" class="save" value="Register me for Pig Watch" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
