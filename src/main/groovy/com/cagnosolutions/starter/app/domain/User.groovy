package com.cagnosolutions.starter.app.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

/**
 * Created by Scott Cagno.
 * Copyright Cagno Solutions. All rights reserved.
 */

@Entity
class User {

    @Id
    @GeneratedValue
    Long id
    String name
    String email
    String username
    String password
    Boolean active = Boolean.TRUE
    Date creationDate
    Date lastSeenDate
}
