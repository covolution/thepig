<%@ page import="thepig.Portion" %>



<div class="fieldcontain ${hasErrors(bean: portionInstance, field: 'quantity', 'error')} required">
	<label for="quantity">
		<g:message code="portion.quantity.label" default="Quantity" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="quantity" from="${1..5}" class="range" required="" value="${fieldValue(bean: portionInstance, field: 'quantity')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: portionInstance, field: 'ingredient', 'error')} required">
	<label for="ingredient">
		<g:message code="portion.ingredient.label" default="Ingredient" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="ingredient" name="ingredient.id" from="${thepig.Ingredient.list()}" optionKey="id" required="" optionValue="name" value="${portionInstance?.ingredient?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: portionInstance, field: 'meal', 'error')} required">
	<label for="meal">
		<g:message code="portion.meal.label" default="Meal" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="meal" name="meal.id" from="${thepig.Meal.list()}" optionKey="id" required="" value="${portionInstance?.meal?.id}" class="many-to-one"/>
</div>

