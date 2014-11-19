package com.cagnosolutions.app.main.estimator

import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service

@CompileStatic
@Service(value = "estimateService")
class EstimateService {

	@Autowired
	EstimateRepository repo

	Estimate findOne() {
		def estimate = repo.findOne 1L
		if (estimate == null) {
			estimate = new Estimate()
			estimate.objects = new HashSet<EstimateObject>()
			estimate = repo.save estimate
		}
		estimate
	}

	def save(Estimate updatedEstimate) {
		def estimate = repo.findOne 1L
		mergeProperties updatedEstimate, estimate
		repo.save estimate
	}

	def addObject(EstimateObject estimateObject) {
		def estimate = repo.findOne 1L
		estimate.objects << estimateObject
		repo.save estimate
	}

	def mergeProperties(source, target) {
		source.properties.each { key, value ->
			if (target.hasProperty(key as String) && !(key in ['class', 'metaClass']) && value != null)
				target[key as String] = value
		}
	}
}

@CompileStatic
@Repository
interface EstimateRepository extends JpaRepository<Estimate, Long>{

}
