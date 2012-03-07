package thepig

import grails.plugins.springsecurity.Secured

@Secured(['ROLE_ADMIN'])
class FeastController {

	static scaffold = Feast
}
