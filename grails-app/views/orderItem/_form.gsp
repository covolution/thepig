<%@ page import="thepig.OrderItem" %>



<div class="fieldcontain ${hasErrors(bean: orderItemInstance, field: 'ingredient', 'error')} required">
	<label for="ingredient">
		<g:message code="orderItem.ingredient.label" default="Ingredient" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="ingredient" name="ingredient.id" from="${thepig.Ingredient.list()}" optionKey="id" required="" value="${orderItemInstance?.ingredient?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: orderItemInstance, field: 'orderLine', 'error')} required">
	<label for="orderLine">
		<g:message code="orderItem.orderLine.label" default="Order Line" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="orderLine" name="orderLine.id" from="${thepig.OrderLine.list()}" optionKey="id" required="" value="${orderItemInstance?.orderLine?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: orderItemInstance, field: 'quantity', 'error')} required">
	<label for="quantity">
		<g:message code="orderItem.quantity.label" default="Quantity" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="quantity" required="" value="${fieldValue(bean: orderItemInstance, field: 'quantity')}"/>
</div>

