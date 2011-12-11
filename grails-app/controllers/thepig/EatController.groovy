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
		IngredientGroup.values().each  { iGroup ->
			log.debug("Settings values for "+iGroup.toString())
			params[iGroup.toString()+".ingredient.id"].each { ing ->
				log.debug("Ingredient id is ${ing} ")
				aMeal.addToPortions(new Portion(["ingredient.id":ing,"quantity":1]))
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
