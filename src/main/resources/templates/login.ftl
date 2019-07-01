<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as e>

<@c.page>
    	Login:
       		<@e.login "login" />
        <br/>
        <a href="/registration">Registration page</a>
</@c.page>