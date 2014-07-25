package com.cagnosolutions.starter.app.user

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Created by Scott Cagno.
 * Copyright Cagno Solutions. All rights reserved.
 */

@Repository
interface UserRepository extends JpaRepository<User, String> {

}
