package thepig

import groovy.transform.ToString

import com.thepig.Person

@ToString
class Meal {

	Person person
	
	static hasMany = [ portions : Portion]	
	static belongsTo = [ feast: Feast]
	
    static constraints = {
		person(unique:'feast')
    }
}
