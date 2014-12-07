package com.cagnosolutions.app.main.item
import groovy.transform.CompileStatic
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@CompileStatic
@RepositoryRestResource
interface ItemRepository extends JpaRepository<Item,Long> {

}