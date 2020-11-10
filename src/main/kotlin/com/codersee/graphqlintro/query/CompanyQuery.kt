package com.codersee.graphqlintro.query

import com.codersee.graphqlintro.model.Company
import com.codersee.graphqlintro.repository.CompanyRepository
import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component

@Component
class CompanyQuery(
    private val companyRepository: CompanyRepository
) : GraphQLQueryResolver {

    fun companies(): Set<Company> =
        companyRepository.findAll()

    fun companyById(id: Long): Company =
        companyRepository.findById(id)
}