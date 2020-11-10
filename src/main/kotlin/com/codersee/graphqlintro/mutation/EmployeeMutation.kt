package com.codersee.graphqlintro.mutation

import com.codersee.graphqlintro.model.Employee
import com.codersee.graphqlintro.model.EmployeeStatus
import com.codersee.graphqlintro.repository.EmployeeRepository
import com.coxautodev.graphql.tools.GraphQLMutationResolver
import org.springframework.stereotype.Component

@Component
class EmployeeMutation(
    private val employeeRepository: EmployeeRepository
) : GraphQLMutationResolver {

    fun newEmployee(
        firstName: String,
        lastName: String,
        status: EmployeeStatus,
        companyId: Long
    ): Employee =
        employeeRepository.create(firstName, lastName, status, companyId)

    fun deleteEmployee(id: Long): Boolean =
        employeeRepository.delete(id)

}