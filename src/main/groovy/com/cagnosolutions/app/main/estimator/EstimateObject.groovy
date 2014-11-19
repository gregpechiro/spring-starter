package com.cagnosolutions.app.main.estimator

import groovy.transform.CompileStatic
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@CompileStatic
@Entity
class EstimateObject {

	@Id
	@GeneratedValue
	Long id

	String name
	Integer size

}
