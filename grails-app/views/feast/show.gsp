
<%@ page import="thepig.Feast" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'feast.label', default: 'Feast')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-feast" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-feast" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list feast">
			
				<g:if test="${feastInstance?.dueAt}">
				<li class="fieldcontain">
					<span id="dueAt-label" class="property-label"><g:message code="feast.dueAt.label" default="Due At" /></span>
					
						<span class="property-value" aria-labelledby="dueAt-label"><joda:format value="${feastInstance?.dueAt}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${feastInstance?.host}">
				<li class="fieldcontain">
					<span id="host-label" class="property-label"><g:message code="feast.host.label" default="Host" /></span>
					
						<span class="property-value" aria-labelledby="host-label"><g:link controller="person" action="show" id="${feastInstance?.host?.id}">${feastInstance?.host?.username}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${feastInstance?.status}">
				<li class="fieldcontain">
					<span id="status-label" class="property-label"><g:message code="feast.status.label" default="Status" /></span>
					
						<span class="property-value" aria-labelledby="status-label"><g:fieldValue bean="${feastInstance}" field="status"/></span>
					
				</li>
				</g:if>
				
				<g:if test="${feastInstance?.meals}">
				<li class="fieldcontain">
					<span id="meals-label" class="property-label"><g:message code="meal.label" default="Meals" /></span>
					
						<g:each in="${feastInstance.meals}" var="m">
						<span class="property-value" aria-labelledby="meals-label"><g:link controller="meal" action="show" id="${m.id}">${m?.person.username}</g:link></span>
						<span class="property-value" aria-labelledby="portions-label">
							<g:join in="${m.portions*.ingredient.sort{it.id}.name}" delimiter=", "/>
						</span>
						</g:each>
					
				</li>
				</g:if>	
				<li class="fieldcontain">
					<g:link controller="meal" action="create" params="['feast.id': feastInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'meal.label', default: 'meal')])}</g:link>
				</li>		
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${feastInstance?.id}" />
					<g:link class="edit" action="edit" id="${feastInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
