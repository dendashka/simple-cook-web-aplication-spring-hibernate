<#import "parts/common.ftl" as c> 
<#import "parts/login.ftl" as e> 

<@c.page> 

Add new user:
<div>${message?ifExists}</div>
<@e.login "/registration" /> 
<br />
<a href="login">Login page</a> 

</@c.page>