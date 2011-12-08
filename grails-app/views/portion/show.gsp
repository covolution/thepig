
<%@ page import="thepig.Portion" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'portion.label', default: 'Portion')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-portion" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-portion" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list portion">
			
				<g:if test="${portionInstance?.quantity}">
				<li class="fieldcontain">
					<span id="quantity-label" class="property-label"><g:message code="portion.quantity.label" default="Quantity" /></span>
					
						<span class="property-value" aria-labelledby="quantity-label"><g:fieldValue bean="${portionInstance}" field="quantity"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${portionInstance?.ingredient}">
				<li class="fieldcontain">
					<span id="ingredient-label" class="property-label"><g:message code="portion.ingredient.label" default="Ingredient" /></span>
					
						<span class="property-value" aria-labelledby="ingredient-label"><g:link controller="ingredient" action="show" id="${portionInstance?.ingredient?.id}">${portionInstance?.ingredient?.name}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${portionInstance?.meal}">
				<li class="fieldcontain">
					<span id="meal-label" class="property-label"><g:message code="portion.meal.label" default="Meal" /></span>
					
						<span class="property-value" aria-labelledby="meal-label"><g:link controller="meal" action="show" id="${portionInstance?.meal?.id}">${portionInstance?.meal?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${portionInstance?.id}" />
					<g:link class="edit" action="edit" id="${portionInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
