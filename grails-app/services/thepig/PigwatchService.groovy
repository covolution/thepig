package thepig
import com.thepig.Person
import org.springframework.context.ApplicationListener
import grails.gsp.PageRenderer

class PigwatchService implements ApplicationListener<MealCreatedEvent> {

    static transactional = false
    def sendGridService
    PageRenderer groovyPageRenderer

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

//    void onApplicationEvent(FeastCreatedEvent event) {
//        Feast feast = event.source
//        log.info "${feast.host.forename} has declared a feast for ${feast.dueAt}."
//    }

    void onApplicationEvent(MealCreatedEvent event) {
        Meal meal = event.source
        String ingredients = meal.portions*.ingredient.sort{it.id}.name.join(", ")
        log.info "${meal.person.forename} has ordered ${ingredients}."
        sendMailCreatedEmail(meal)
    }

    void sendMailCreatedEmail(Meal aMeal){
          String emailContent =  groovyPageRenderer.render view:"/eat/emailContent", model: [theMeal:aMeal, theHost:aMeal.feast.host, theUser:aMeal.person]
          sendGridService.sendMail {
              from 'thepig@covolution.co.uk'
              to aMeal.feast.host.email
              subject "New Pig Order"
              html emailContent
          }
    }

}
