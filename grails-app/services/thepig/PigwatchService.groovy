package thepig
import com.thepig.Person

class PigwatchService {

    static transactional = false
//    static atmosphere = [mapping: '/atmosphere/pigMessage']
//                                        
//    def onRequest = { event ->
//        log.info "onRequest, $event"

        // Mark this connection as suspended.
//        event.suspend()
//    }
//
//    def onStateChange = { event ->
//        if (event.cancelled){
//            log.info "onStateChange, cancelling $event"
//        }
//        else if (event.message) {
//            log.info "onStateChange, message: ${event.message}"
//            println "Event message is ${event.message}"
//            event.resource.response.writer.with {
//                write event.message
//                flush()
//            }
//        }
//    }
    def orderCreated(Person person, Meal meal) {
    	String ingredients = meal.portions*.ingredient.sort{it.id}.name.join(", ")
    	println "${person.forename} has ordered ${ingredients}."
    	//broadcaster['/atmosphere/pigMessage'].broadcast("${person.forename} has ordered ${ingredients}.")
    }
}
