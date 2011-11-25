<%@ page import="thepig.Order" %>
<r:script>
 $(function() {
    if (!Modernizr.inputtypes.date) {
        $("input[type=date]").datepicker({dateFormat: $.datepicker.W3C});
    }
 });
</r:script>


<div class="fieldcontain ${hasErrors(bean: orderInstance, field: 'dueAt', 'error')} required">
	<label for="dueAt">
		<g:message code="order.dueAt.label" default="Due At" />
		<span class="required-indicator">*</span>
	</label>
	<joda:dateTimePicker name="dueAt" value="${orderInstance?.dueAt}" ></joda:dateTimePicker>
</div>

<div class="fieldcontain ${hasErrors(bean: orderInstance, field: 'status', 'error')} required">
	<label for="status">
		<g:message code="order.status.label" default="Status" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="status" from="${thepig.OrderStatus?.values()}" keys="${thepig.OrderStatus.values()*.name()}" required="" value="${orderInstance?.status?.name()}"/>
</div>

