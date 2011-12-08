package thepig

import grails.plugins.springsecurity.Secured

import org.springframework.dao.DataIntegrityViolationException

@Secured(['ROLE_ADMIN'])
class IngredientController {

	static scaffold = Ingredient
}
