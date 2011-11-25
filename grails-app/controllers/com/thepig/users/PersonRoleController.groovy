package com.thepig.users

import grails.plugins.springsecurity.Secured

import com.thepig.PersonRole

@Secured(['ROLE_ADMIN'])
class PersonRoleController {

    static scaffold = PersonRole
}
