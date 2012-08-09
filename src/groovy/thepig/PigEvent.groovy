package thepig

import org.springframework.context.ApplicationEvent

/**
* A Pig Event with Message
*/
class PigEvent extends ApplicationEvent {
   PigEvent(Object source) {
      super(source)
   }
}

class MealCreatedEvent extends PigEvent {
   MealCreatedEvent(Meal meal) {
      super(meal)
   }
}

class FeastCreatedEvent extends PigEvent {
   FeastCreatedEvent(Feast feast) {
      super(feast)
   }
}