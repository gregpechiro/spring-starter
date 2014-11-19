package com.cagnosolutions.app.main.estimator

import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@CompileStatic
@Controller
@RequestMapping(value = "/estimator")
class EstimateController {

	@Autowired
	EstimateService estimateService

	@RequestMapping(method = RequestMethod.GET)
	String viewEstimate(Model model) {
		model.addAttribute "estimate", estimateService.findOne()
		"estimator/estimate"
	}

	@RequestMapping(method = RequestMethod.POST)
	String updateEstimate(Estimate estimate) {
		estimateService.save estimate
		"redirect:/estimator"
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	String addObjectToEstimate(String name, Integer size) {
		def estimateObject = new EstimateObject([name: name, size: size])
		estimateService.addObject estimateObject
		"redirect:/estimator"
	}
}
