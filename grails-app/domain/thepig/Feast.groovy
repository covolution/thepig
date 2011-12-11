package thepig

import groovy.transform.ToString

import org.joda.time.DateTime

import com.thepig.Person

/**
 * Represents an feast aka Meal
 * @author gjames
 *
 */
@ToString
class Feast {

	Person host
	FeastStatus status
	DateTime dueAt
	
	static hasMany = [ meals : Meal]
	
    static constraints = {
    }
}
