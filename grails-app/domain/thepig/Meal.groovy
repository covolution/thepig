package thepig

import com.thepig.Person

class Meal {

	Person person
	
	static hasMany = [ portions : Portion]	
	static belongsTo = [ feast: Feast]
	
    static constraints = {
		person(unique:'feast')
    }
}
