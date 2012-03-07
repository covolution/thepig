package thepig

import grails.plugins.springsecurity.Secured

@Secured(['ROLE_USER'])
class MealController {

  static scaffold = Meal
}
