package com.cagnosolutions.app.main.email

import groovy.transform.CompileStatic

@CompileStatic
class Email {

	String[] to
	String from, subject, body

	def setAll(String from, String subject, String... to) {
		this.to = to
		this.from = from
		this.subject = subject
	}
}
