import org.codehaus.groovy.grails.plugins.web.taglib.JavascriptTagLib
import org.joda.time.DateTime

import thepig.Feast
import thepig.FeastStatus
import thepig.Ingredient
import thepig.IngredientGroup

import com.thepig.Person
import com.thepig.PersonRole
import com.thepig.Role

class BootStrap {

    def init = { servletContext ->
		
		JavascriptTagLib.LIBRARY_MAPPINGS.modernizr = ["modernizr-2.0.6.min.js"]
		
		def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
		def userRole = new Role(authority: 'ROLE_USER').save(flush: true)
  
		def testUser = new Person(username: 'gethin', enabled: true, password: 'password')
		testUser.save(flush: true)
  
		PersonRole.create testUser, adminRole, true
		
		new Ingredient(ingredientGroup:IngredientGroup.PIG_TYPE, name: "Bacon").save(flush:true)
		new Ingredient(ingredientGroup:IngredientGroup.PIG_TYPE, name: "Sausage").save(flush:true)
		new Ingredient(ingredientGroup:IngredientGroup.BREAD_TYPE, name: "White").save(flush:true)
		new Ingredient(ingredientGroup:IngredientGroup.BREAD_TYPE, name: "Brown").save(flush:true)
		new Ingredient(ingredientGroup:IngredientGroup.BREAD_SHAPE, name: 'Sandwich').save(flush:true)
		new Ingredient(ingredientGroup:IngredientGroup.BREAD_SHAPE, name: "Roll").save(flush:true)
		new Ingredient(ingredientGroup:IngredientGroup.BREAD_SHAPE, name: "Bap").save(flush:true)
		new Ingredient(ingredientGroup:IngredientGroup.BREAD_SHAPE, name: "Sub").save(flush:true)
		new Ingredient(ingredientGroup:IngredientGroup.BREAD_SHAPE, name: "Baguette").save(flush:true)
		new Ingredient(ingredientGroup:IngredientGroup.VEG, name: "Mushrooms").save(flush:true)
		new Ingredient(ingredientGroup:IngredientGroup.EXTRA, name: "Fried Egg").save(flush:true)
		new Ingredient(ingredientGroup:IngredientGroup.SAUCE, name: "Red").save(flush:true)
		new Ingredient(ingredientGroup:IngredientGroup.SAUCE, name: "Brown").save(flush:true)
		
		new Feast(host:testUser, status:FeastStatus.OPEN, dueAt:new DateTime()).save(flush:true)
    }
    def destroy = {
    }
}
