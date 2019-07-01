<#import "parts/common.ftl" as c> 
<@c.page>

<div class="form-row mt-3">
	<div class="form-group col-md-6">
		<form method="get" action="main" class="form-inline">
			<input type="text" class="form-control" name="filter"
				value="${filter?ifExists}" placeholder="Search by tag">
			<button type="submit" class="btn btn-primary ml-3">search
				recipe</button>
		</form>
	</div>
</div>

<a class="btn btn-primary mt-4" data-toggle="collapse"
	href="#collapseExample" role="button" aria-expanded="false"
	aria-controls="collapseExample"> Press to Enter new recipe </a>
<div class="collapse" id="collapseExample">
	<form method="post" enctype="multipart/form-data" action="main">
		<input type="hidden" name="_csrf" value="${_csrf.token}" />
		<div class="form-group mt-3">
			<label for="formGroupExampleInput">Enter recipe</label> <input
				type="text" name="text" id="formGroupExampleInput"
				class="form-control" placeholder="Enter recipe">
		</div>
		<div class="form-group">
			<label for="formGroupExampleInput2">Enter tag</label> <input
				type="text" name="tag" id="formGroupExampleInput2"
				class="form-control" placeholder="Enter tag">
		</div>
		<div class="form-group">
			<div class="custom-file">
				<input type="file" name="file" id="customFile" /> <label
					class="custom-file-label" for="customFile">choose foto</label>
			</div>
		</div>
		<div class="form-group">
			<button type="submit" class="btn btn-primary ml-3">save
				recipe</button>
		</div>

</form>
</div>

<div class="my-4"><h2>recipe list:</h1></div>

<div class="card-columns">
<#list recipes as recipe>
<div class="card">
	<#if recipe.filename??>
    <img src="/img/${recipe.filename}" class="card-img-top" alt="foto">
    </#if>
    <div class="card-body">
      <h5 class="card-title">${recipe.authorName}</h5>
      <p class="card-text">${recipe.text}</p>
      <p class="card-text"><small class="text-muted">${recipe.tag}</small></p>
    </div>
</div>
<#else> 
	no recipes
</#list>
</div>

</@c.page>