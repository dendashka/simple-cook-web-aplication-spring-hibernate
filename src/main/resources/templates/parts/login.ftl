<#macro login path>

<form action="${path}" method="post">
<input type="hidden" name="_csrf" value="${_csrf.token}" />
	<div class="form-group row">
		<label for="inputEmail3" class="col-sm-2 col-form-label"> User Name : </label>
		<div class="col-sm-4">
			<input type="text" name="username" class="form-control" id="inputEmail3" placeholder="Email" />
		</div>
	</div>
	<div class="form-group row">
		<label for="inputPassword3" class="col-sm-2 col-form-label"> Password : </label>
		<div class="col-sm-4">
		<input type="password" name="password" class="form-control" id="inputPassword3" placeholder="Password"/>
		</div>
	</div>
	<div class="form-group row">
    <div class="col-sm-10">
      <button type="submit" class="btn btn-primary">Sign in</button>
    </div>
    </div>

</form>
</#macro>

