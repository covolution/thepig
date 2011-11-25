package thepig

import org.joda.time.DateTime

/**
 * Represents an order in the system
 * @author gjames
 *
 */
class Order {

	OrderStatus status
	DateTime dueAt
	
	static mapping = {
		table 'orderHeader'
	}
	
    static constraints = {
    }
}
