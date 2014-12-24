package com.cagnosolutions.app.main.project.mgmt.task

import groovy.transform.CompileStatic
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@CompileStatic
@Entity
class Task {

	@Id
	@GeneratedValue
	long id
	long assignedTo, assignedBy, assignedTime, finishedTime
	boolean complete, bug = false
	String name, notes

}
