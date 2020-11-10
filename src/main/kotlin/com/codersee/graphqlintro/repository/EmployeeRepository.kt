package com.codersee.graphqlintro.repository

import com.codersee.graphqlintro.model.Employee
import com.codersee.graphqlintro.model.EmployeeStatus
import org.springframework.stereotype.Component
import java.util.concurrent.atomic.AtomicLong

@Component
class EmployeeRepository(
    private val companyRepository: CompanyRepository
) {

    val employerId = AtomicLong(3)

    val employees = mutableSetOf(
        Employee(1, "John", "Doe", EmployeeStatus.ACTIVE, companyRepository.findById(1)),
        Employee(2, "Adam", "Nowak", EmployeeStatus.ACTIVE, companyRepository.findById(2)),
        Employee(3, "Stan", "Bar", EmployeeStatus.RETIRED, companyRepository.findById(3))
    )

    fun findAll(): Set<Employee> = employees

    fun findById(employeeId: Long) =
        employees.find { it.id == employeeId }
            ?: throw RuntimeException("Employee with id [$employeeId] could not be found.")

    fun create(
        firstName: String,
        lastName: String,
        status: EmployeeStatus,
        companyId: Long
    ): Employee {
        val company = companyRepository.findById(companyId)

        val employee = Employee(
            id = employerId.incrementAndGet(),
            firstName = firstName,
            lastName = lastName,
            status = status,
            company = company
        )

        employees.add(employee)
        return employee
    }

    fun delete(id: Long): Boolean =
        employees.removeIf { it.id == id }
}