package com.cagnosolutions.app.main.item
import groovy.transform.CompileStatic
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@CompileStatic
@RepositoryRestResource
interface ItemRepository extends PagingAndSortingRepository<Item,Long> {

}