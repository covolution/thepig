package com.thepig.users

import grails.plugins.springsecurity.Secured

import com.thepig.Role

@Secured(['ROLE_ADMIN'])
class RoleController {

    static scaffold = Role
}
