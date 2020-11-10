package com.codersee.graphqlintro.repository

import com.codersee.graphqlintro.model.Company
import org.springframework.stereotype.Component
import java.util.concurrent.atomic.AtomicLong

@Component
class CompanyRepository {

    private val companyId = AtomicLong(4)

    private val companies = mutableSetOf(
        Company(1, "Company One", "Address 1", "10001"),
        Company(2, "Company Two", "Address 2", "10002"),
        Company(3, "Company Three", "Address 3", "10003"),
        Company(4, "Company Four", "Address 4", "10004")
    )

    fun findAll(): Set<Company> = companies

    fun findById(companyId: Long): Company =
        companies.find { it.id == companyId }
            ?: throw RuntimeException("Company with id [$companyId] could not be found.")

    fun create(name: String, address: String, zipCode: String): Company {
        val company = Company(
            id = companyId.incrementAndGet(),
            name = name,
            address = address,
            zipCode = zipCode
        )

        companies.add(company)
        return company
    }

    fun delete(id: Long): Boolean =
        companies.removeIf { it.id == id }
}