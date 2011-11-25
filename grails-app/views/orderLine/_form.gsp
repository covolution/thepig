<%@ page import="thepig.OrderLine" %>



<div class="fieldcontain ${hasErrors(bean: orderLineInstance, field: 'orderHeader', 'error')} required">
	<label for="orderHeader">
		<g:message code="orderLine.orderHeader.label" default="Order Header" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="orderHeader" name="orderHeader.id" from="${thepig.Order.list()}" optionKey="id" required="" value="${orderLineInstance?.orderHeader?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: orderLineInstance, field: 'person', 'error')} required">
	<label for="person">
		<g:message code="orderLine.person.label" default="Person" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="person" name="person.id" from="${com.thepig.Person.list()}" optionKey="id" required="" value="${orderLineInstance?.person?.id}" class="many-to-one"/>
</div>

