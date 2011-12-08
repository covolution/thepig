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
	<g:select id="person" name="person.id" from="${com.thepig.Person.list()}" optionKey="id" optionValue="username" required="" value="${mealInstance?.person?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: mealInstance, field: 'portions', 'error')} ">
	<label for="portions">
		<g:message code="meal.portions.label" default="Portions" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${mealInstance?.portions?}" var="p">
    <li><g:link controller="portion" action="show" id="${p.id}">${p?.ingredient.name}</g:link></li>
</g:each>
<li class="add">
<g:link controller="portion" action="create" params="['meal.id': mealInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'portion.label', default: 'Portion')])}</g:link>
</li>
</ul>

</div>

