<%@ page import="thepig.Portion" %>

<div class="fieldcontain ${hasErrors(bean: portionInstance, field: 'meal', 'error')} required">
	<span id="feast-label" class="property-label"><g:message code="meal.feast.label" default="Feast" /></span>
	<span class="property-value" aria-labelledby="feast-label"><joda:format value="${mealInstance?.feast?.dueAt}" /></span>
</div>
<g:hiddenField name="feast.id" value="${mealInstance?.feast?.id}" />

<div class="fieldcontain ${hasErrors(bean: portionInstance, field: 'quantity', 'error')} required">
	<label for="quantity">
		<g:message code="portion.quantity.label" default="Quantity" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="portions[0].quantity" value="1"/>
	<g:textField name="portions[0].ingredient.id" value="1"/>
	
	<g:textField name="portions[1].quantity" value="3"/>
	<g:textField name="portions[1].ingredient.id" value="2"/>
	
	<g:textField name="portions[2].quantity" value="1"/>
	<g:textField name="portions[2].ingredient.id" value="5"/>
</div>

<div class="fieldcontain ${hasErrors(bean: portionInstance, field: 'ingredient', 'error')} required">
	<label for="ingredient">
		<g:message code="portion.ingredient.label" default="Ingredient" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="ingredient" name="ingredient.id" from="${thepig.Ingredient.list()}" optionKey="id" required="" value="${portionInstance?.ingredient?.id}" class="many-to-one"/>
</div>


