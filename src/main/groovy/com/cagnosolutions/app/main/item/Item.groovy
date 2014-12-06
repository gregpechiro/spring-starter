package com.cagnosolutions.app.main.item

import com.sun.org.apache.xpath.internal.operations.String
import groovy.transform.CompileStatic

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@CompileStatic
@Entity
class Item {

	@Id
	@GeneratedValue
	Long id
	String name, description
}
