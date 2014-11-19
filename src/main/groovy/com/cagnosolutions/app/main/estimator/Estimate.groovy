package com.cagnosolutions.app.main.estimator

import groovy.transform.CompileStatic
import javax.persistence.*

@CompileStatic
@Entity
class Estimate {

	@Id
	@GeneratedValue
	Long id

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "proposal_id")
	Set<EstimateObject> objects
	Integer roles, users

	Float developmentTime, developmentCost, hostingCost

	String toString() {
		"${id}, ${objects*.name}, ${roles}, ${users}"
	}
}
