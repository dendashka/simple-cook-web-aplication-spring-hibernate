<#import "parts/common.ftl" as c>

<@c.page>
List of user:
<table>
	<thead>
		<tr>
			<th>Name</th>
			<th>Role</th>
			<th></th>
		</tr>
	</thead>
	<tbody>
	<#list userlist as user>
	<tr>
			<td>${user.username}</td>
			<td><#list user.role as role>${role}<#sep>, </#list>></td>
			<td><a href="/user/${user.id}">edit</a></td>
	</tr>	
	</#list>
	</tbody>
</table>


</@c.page>