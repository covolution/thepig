<%@ page import="com.thepig.Person" %>



<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'username', 'error')} required">
	<label for="username">
		<g:message code="person.username.label" default="Username" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="username" required="" value="${personInstance?.username}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'password', 'error')} required">
	<label for="password">
		<g:message code="person.password.label" default="Password" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="password" required="" value="${personInstance?.password}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'forename', 'error')} required">
	<label for="forename">
		<g:message code="person.forename.label" default="Forename" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="forename" required="" value="${personInstance?.forename}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'surname', 'error')} required">
	<label for="surname">
		<g:message code="person.surname.label" default="Surname" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="surname" required="" value="${personInstance?.surname}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'email', 'error')} required">
	<label for="email">
		<g:message code="person.email.label" default="Email" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="email" name="email" required="" value="${personInstance?.email}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'accountExpired', 'error')} ">
	<label for="accountExpired">
		<g:message code="person.accountExpired.label" default="Account Expired" />
		
	</label>
	<g:checkBox name="accountExpired" value="${personInstance?.accountExpired}" />
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'accountLocked', 'error')} ">
	<label for="accountLocked">
		<g:message code="person.accountLocked.label" default="Account Locked" />
		
	</label>
	<g:checkBox name="accountLocked" value="${personInstance?.accountLocked}" />
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'enabled', 'error')} ">
	<label for="enabled">
		<g:message code="person.enabled.label" default="Enabled" />
		
	</label>
	<g:checkBox name="enabled" value="${personInstance?.enabled}" />
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'passwordExpired', 'error')} ">
	<label for="passwordExpired">
		<g:message code="person.passwordExpired.label" default="Password Expired" />
		
	</label>
	<g:checkBox name="passwordExpired" value="${personInstance?.passwordExpired}" />
</div>

