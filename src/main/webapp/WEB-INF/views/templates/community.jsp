<%@include file="/WEB-INF/resources/includes/taglib.jspf"%>

<table>
<tr>
<td>
{{#link-to 'forum'}} Forum {{/link-to}}
</td>
</tr>

<security:authorize access="isAuthenticated()">
<tr>
<td>
{{#link-to 'profile'}} Profile {{/link-to}}
</td>
</tr>

<tr>
<td>
{{#link-to 'decks'}} Decks {{/link-to}}
</td>
</tr>
</security:authorize>

<tr>
<td>
{{#link-to 'events'}} Events {{/link-to}}
</td>
</tr>

</table>

&nbsp;&nbsp; {{outlet}}