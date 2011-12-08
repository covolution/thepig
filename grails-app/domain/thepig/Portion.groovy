package thepig

class Portion {

	int quantity
	Ingredient ingredient
	
	static belongsTo = [ meal: Meal]
	
    static constraints = {
		quantity(range:1..5)
    }
}
