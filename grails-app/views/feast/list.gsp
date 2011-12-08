
<%@ page import="thepig.Feast" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'feast.label', default: 'Feast')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-feast" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-feast" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="dueAt" title="${message(code: 'feast.dueAt.label', default: 'Due At')}" />
					
						<th><g:message code="feast.host.label" default="Host" /></th>
					
						<g:sortableColumn property="status" title="${message(code: 'feast.status.label', default: 'Status')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${feastInstanceList}" status="i" var="feastInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${feastInstance.id}">${fieldValue(bean: feastInstance, field: "dueAt")}</g:link></td>
					
						<td>${fieldValue(bean: feastInstance, field: "host.username")}</td>
					
						<td>${fieldValue(bean: feastInstance, field: "status")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${feastInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
