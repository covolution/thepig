<%@ page import="thepig.Portion" %>
<g:hiddenField name="feast.id" value="${mealInstance?.feast?.id}" />
<style type="text/css" media="screen">

	#theOrder fieldset {
		border:1px solid #CCCCCC;
		margin: 0.2em;
	}
	
	#theOrder legend {
		padding: 0.2em 0.5em;
		font-weight: bold;
	}

	#theOrder input {
		margin: 0.4em;
	}	
</style>
<div id="theOrder">
  <fieldset>
  <legend>Bread</legend>
    <g:each in="${thepig.Ingredient.findAllWhere(ingredientGroup:thepig.IngredientGroup.BREAD_TYPE)}">
    	${it.name}<input type="radio" value="${it.id}" name="BREAD_TYPE.ingredient.id">
    </g:each>    
   	<g:hiddenField name="BREAD_TYPE.quantity" value="1" /> 
    <br />
    <g:each in="${thepig.Ingredient.findAllWhere(ingredientGroup:thepig.IngredientGroup.BREAD_SHAPE)}">
    	${it.name}<input type="radio" value="${it.id}" name="BREAD_SHAPE.ingredient.id">
    </g:each>
   	<g:hiddenField name="BREAD_SHAPE.quantity" value="1" />    
  </fieldset>
  <% int portionId = 2 %>
   <fieldset>
  <legend>Pig Type</legend>
    <g:each in="${thepig.Ingredient.findAllWhere(ingredientGroup:thepig.IngredientGroup.PIG_TYPE)}">
    	${it.name}<input type="checkbox" value="${it.id}" name="PIG_TYPE.ingredient.id">
    	<g:hiddenField name="PIG_TYPE.quantity" value="1" />
    </g:each>
  </fieldset>
   <fieldset>
  <legend>Extras</legend>  
    <g:each in="${thepig.Ingredient.findAllWhere(ingredientGroup:thepig.IngredientGroup.VEG)}">
    	${it.name}<input type="checkbox" value="${it.id}" name="VEG.ingredient.id">
    	<g:hiddenField name="VEG.quantity" value="1" />
    </g:each>
    <br />  
    <g:each in="${thepig.Ingredient.findAllWhere(ingredientGroup:thepig.IngredientGroup.EXTRA)}">
    	${it.name}<input type="checkbox" value="${it.id}" name="EXTRA.ingredient.id">
    	<g:hiddenField name="EXTRA.quantity" value="1" />
    </g:each>
  </fieldset>
   <fieldset class="sauceSet">
  <legend>Sauce</legend>  
    <g:each in="${thepig.Ingredient.findAllWhere(ingredientGroup:thepig.IngredientGroup.SAUCE)}">
    	${it.name}<input type="radio" value="${it.id}" name="SAUCE.ingredient.id">
    </g:each>
    None<input type="radio" value="999" name="SAUCE.ingredient.id" id="noSauce">    
   	<g:hiddenField name="SAUCE.quantity" value="1" />                   
  </fieldset> 
</div>  
<r:script>
	$('#eatForm').submit(function() {
	  var checkedVal = $("#eatForm fieldset.sauceSet input[type='radio']:checked").val();
	  if (checkedVal == 999) {
	    //No sauce so disable this set from submission.
	    $("#eatForm fieldset.sauceSet input[type='radio']").attr('disabled', true);
	  }
	  $("#eatForm fieldset.buttons input").hide();
	});
</r:script>


