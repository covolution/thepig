import org.codehaus.groovy.grails.plugins.web.taglib.JavascriptTagLib
import org.joda.time.DateTime

import grails.converters.JSON

import thepig.Feast
import thepig.FeastStatus
import thepig.Ingredient
import thepig.IngredientGroup

import com.thepig.Person
import com.thepig.PersonRole
import com.thepig.Role

class BootStrap {

    def init = { servletContext ->
		
		String VCAP_SERVICES = System.getenv('VCAP_SERVICES')
		println "VCAP_SERVICES: ${System.getenv('VCAP_SERVICES')}"
  
		try {
		   def servicesMap = JSON.parse(VCAP_SERVICES)
		   servicesMap.each { key, services ->
			  if (key.startsWith('mysql')) {
				 for (service in services) {
					print "MySQL service $service.name: "
					print "url='jdbc:mysql://$service.credentials.hostname:$service.credentials.port/$service.credentials.name', "
					print "user='$service.credentials.user', "
					println "password='$service.credentials.password'n"
				 }
			  }
		   }
		} catch (e) {
		   println "Error occurred parsing VCAP_SERVICES: $e.message"
		}

		println "SENDGRID_USERNAME: ${System.getenv('SENDGRID_USERNAME')}"
		println "SENDGRID_PASSWORD: ${System.getenv('SENDGRID_PASSWORD')}"

		JavascriptTagLib.LIBRARY_MAPPINGS.modernizr = ["modernizr-2.0.6.min.js"]
		
		try {
			def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
			def userRole = new Role(authority: 'ROLE_USER').save(flush: true)

			def testUser = new Person(username: 'gethin', enabled: true, password: 'password',
				 email:"gethin.james@alfresco.com", forename:'Gethin', surname:'James')
			testUser.save(flush: true)

			PersonRole.create testUser, adminRole, true
		} catch (e) {
		   println "Default user not created: $e.message"
		}
		
		new Ingredient(ingredientGroup:IngredientGroup.BREAD_TYPE, name: "White Bread").save(flush:true)
		new Ingredient(ingredientGroup:IngredientGroup.BREAD_TYPE, name: "Brown Bread").save(flush:true)
		new Ingredient(ingredientGroup:IngredientGroup.BREAD_SHAPE, name: 'Sandwich').save(flush:true)
		new Ingredient(ingredientGroup:IngredientGroup.BREAD_SHAPE, name: "Roll").save(flush:true)
		new Ingredient(ingredientGroup:IngredientGroup.BREAD_SHAPE, name: "Bap").save(flush:true)
		new Ingredient(ingredientGroup:IngredientGroup.BREAD_SHAPE, name: "Sub").save(flush:true)
		new Ingredient(ingredientGroup:IngredientGroup.BREAD_SHAPE, name: "Baguette").save(flush:true)
		new Ingredient(ingredientGroup:IngredientGroup.PIG_TYPE, name: "Bacon").save(flush:true)
		new Ingredient(ingredientGroup:IngredientGroup.PIG_TYPE, name: "Sausage").save(flush:true)
		new Ingredient(ingredientGroup:IngredientGroup.VEG, name: "Mushrooms").save(flush:true)
		new Ingredient(ingredientGroup:IngredientGroup.EXTRA, name: "Fried Egg").save(flush:true)
		new Ingredient(ingredientGroup:IngredientGroup.CHEESE, name: "Cheddar").save(flush:true)
		new Ingredient(ingredientGroup:IngredientGroup.CHEESE, name: "Blue").save(flush:true)
		new Ingredient(ingredientGroup:IngredientGroup.CHEESE, name: "Brie").save(flush:true)
		new Ingredient(ingredientGroup:IngredientGroup.SAUCE, name: "Red Sauce").save(flush:true)
		new Ingredient(ingredientGroup:IngredientGroup.SAUCE, name: "Brown Sauce").save(flush:true)
		
		//new Feast(host:testUser, status:FeastStatus.OPEN, dueAt:new DateTime()).save(flush:true)
    }
    def destroy = {
    }
}
