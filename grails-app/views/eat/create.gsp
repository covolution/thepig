<%@ page import="thepig.Portion" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'meal.label', default: 'Meal')}" />
		<title>Create a pig feast</title>
	</head>
	<body>
		<div id="create-meal" class="content scaffold-create" role="main">
			<h1>Create your Pig Meal for the Feast at <joda:format value="${mealInstance?.feast?.dueAt}" /> with ${mealInstance?.feast?.host?.forename}</h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${mealInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${mealInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form action="save" name="eatForm" >
				<fieldset class="form">
					<g:render template="form"/>
				</fieldset>
				<fieldset class="buttons">
					<g:submitButton name="create" class="save" value="Create My Pig Order" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
