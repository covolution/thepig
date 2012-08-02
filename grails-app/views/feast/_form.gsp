<%@ page import="thepig.Feast" %>

<div class="fieldcontain ${hasErrors(bean: feastInstance, field: 'dueAt', 'error')} required">
	<label for="dueAt">
		<g:message code="feast.dueAt.label" default="Due At" />
		<span class="required-indicator">*</span>
	</label>
	<joda:dateTimePicker name="dueAt" value="${feastInstance?.dueAt}" ></joda:dateTimePicker>
</div>

<div class="fieldcontain ${hasErrors(bean: feastInstance, field: 'host', 'error')} required">
	<label for="host">
		<g:message code="feast.host.label" default="Host" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="host" name="host.id" from="${com.thepig.Person.list()}" optionKey="id" optionValue="username" required=""
	 value="2" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: feastInstance, field: 'status', 'error')} required">
	<label for="status">
		<g:message code="feast.status.label" default="Status" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="status" from="${thepig.FeastStatus?.values()}" keys="${thepig.FeastStatus.values()*.name()}" required="" value="${feastInstance?.status?.name()}"/>
</div>

