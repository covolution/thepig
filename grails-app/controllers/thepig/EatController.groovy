package thepig

import grails.plugins.springsecurity.Secured

@Secured(['ROLE_USER'])
class EatController {

	def springSecurityService
	
    def index() { }
	
	def create = {
		def theFeast = Feast.get(params.id)
		def mealInstance = new Meal(feast:theFeast,person:springSecurityService.currentUser)
		[mealInstance:mealInstance]
	}
	
	def save = {
		println params
		def mealInstance = new Meal(params)
		mealInstance.person = springSecurityService.currentUser
		if (mealInstance.save(flush:true)) {
		  flash.message = "Success"
		} else {
		  render(view:"create", model:[mealInstance:mealInstance])
		}
	}
}
