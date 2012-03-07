package thepig

import grails.plugins.springsecurity.Secured

@Secured(['ROLE_USER'])
class PortionController {

    static scaffold = Portion
}
