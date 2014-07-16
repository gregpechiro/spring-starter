package com.cagnosolutions.starter.app.repository
import com.cagnosolutions.starter.app.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
/**
 * Created by Scott Cagno.
 * Copyright Cagno Solutions. All rights reserved.
 */

@Repository
interface UserRepository extends JpaRepository<User, Long> {

}
