package com.codersee.graphqlintro.mutation

import com.codersee.graphqlintro.model.Company
import com.codersee.graphqlintro.repository.CompanyRepository
import com.coxautodev.graphql.tools.GraphQLMutationResolver
import org.springframework.stereotype.Component

@Component
class CompanyMutation(
    private val companyRepository: CompanyRepository
) : GraphQLMutationResolver {

    fun newCompany(name: String, address: String, zipCode: String): Company =
        companyRepository.create(name, address, zipCode)

    fun deleteCompany(id: Long): Boolean =
        companyRepository.delete(id)
}