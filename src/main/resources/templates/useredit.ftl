<#import "parts/common.ftl" as c>

<@c.page>
User editor

<form action="/user" method="post">
	<input type="text" name="username" value="${user.username}">
	<#list roles as role>
		<div>
			<lable><input type="checkbox" name="${role}"  ${user.role?seq_contains(role)?string("checked", "")}>${role}</lable>
		</div>
	</#list>
	<input type="hidden" name="userid" value="${user.id}">
	<button type="submit">save</button>
	<input type="hidden" name="_csrf" value="${_csrf.token}">
</form>
</@c.page>