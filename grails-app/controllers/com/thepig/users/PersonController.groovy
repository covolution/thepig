package com.thepig.users

import grails.plugins.springsecurity.Secured

import com.thepig.Person


@Secured(['ROLE_ADMIN'])
class PersonController {

    static scaffold = Person
}
