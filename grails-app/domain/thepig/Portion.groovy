package thepig

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@ToString
@EqualsAndHashCode
class Portion {

	int quantity = 1
	Ingredient ingredient
	
	static belongsTo = [ meal: Meal]
	
    static constraints = {
		quantity(range:1..5)
    }
}
