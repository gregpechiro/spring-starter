package com.cagnosolutions.app.main.project.mgmt.task

import groovy.transform.CompileStatic
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@CompileStatic
@RepositoryRestResource
interface TaskRepository extends JpaRepository<Task,Long> {
	// special methods / data base calls go here
}
