package com.codersee.graphqlintro.query

import com.codersee.graphqlintro.model.Employee
import com.codersee.graphqlintro.repository.EmployeeRepository
import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component

@Component
class EmployeeQuery(
    private val employeeRepository: EmployeeRepository
) : GraphQLQueryResolver {

    fun employees(): Set<Employee> =
        employeeRepository.findAll()

    fun employeeById(id: Long): Employee =
        employeeRepository.findById(id)
}