package thepig

import grails.plugins.springsecurity.Secured

@Secured(['ROLE_USER'])
class EatController {

	def springSecurityService
	
	def create = {
		def theFeast = Feast.find("from Feast as f order by f.dueAt desc") //last feast
		def mealInstance = new Meal(feast:theFeast,person:springSecurityService.currentUser)
		[mealInstance:mealInstance]
	}
	
	def save = {
		def aMeal = new Meal(params)
		aMeal.person = springSecurityService.currentUser
		List<String> igs = new ArrayList<String>()
		IngredientGroup.values().each  { iGroup ->
			println ("Settings values for "+iGroup.toString())
			igs << params[iGroup.toString()+".ingredient.id"]
		}
		println igs
		igs.flatten()?.each() {
			if (it) { //ignores null
			  aMeal.addToPortions(new Portion(["ingredient.id":it,"quantity":1]))
			}
		}
		aMeal.person = springSecurityService.currentUser
		if (aMeal.save(flush:true)) {
		  flash.message = "Enjoy the feast"
		} else {
		  render(view:"create", model:[mealInstance:aMeal])
		}
	}
}
