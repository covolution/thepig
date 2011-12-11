package thepig

import groovy.transform.ToString

@ToString
class Ingredient {

	String name
	IngredientGroup ingredientGroup
	
    static constraints = {
		name(unique:'ingredientGroup')
    }
}
