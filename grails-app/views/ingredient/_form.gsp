<%@ page import="thepig.Ingredient" %>



<div class="fieldcontain ${hasErrors(bean: ingredientInstance, field: 'ingredientGroup', 'error')} required">
	<label for="ingredientGroup">
		<g:message code="ingredient.ingredientGroup.label" default="Ingredient Group" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="ingredientGroup" from="${thepig.IngredientGroup?.values()}" keys="${thepig.IngredientGroup.values()*.name()}" required="" value="${ingredientInstance?.ingredientGroup?.name()}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: ingredientInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="ingredient.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${ingredientInstance?.name}"/>
</div>

