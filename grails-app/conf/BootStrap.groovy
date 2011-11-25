import org.codehaus.groovy.grails.plugins.web.taglib.JavascriptTagLib

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
    }
    def destroy = {
    }
}
