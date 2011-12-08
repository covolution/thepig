<%@ page import="thepig.Meal" %>



<div class="fieldcontain ${hasErrors(bean: mealInstance, field: 'feast', 'error')} required">
	<label for="feast">
		<g:message code="meal.feast.label" default="Feast" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="feast" name="feast.id" from="${thepig.Feast.list()}" optionKey="id" required="" value="${mealInstance?.feast?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: mealInstance, field: 'person', 'error')} required">
	<label for="person">
		<g:message code="meal.person.label" default="Person" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="person" name="person.id" from="${com.thepig.Person.list()}" optionKey="id" required="" value="${mealInstance?.person?.id}" class="many-to-one"/>
</div>

