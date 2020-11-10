package com.codersee.graphqlintro.model

class Employee(
    val id: Long,
    val firstName: String,
    val lastName: String,
    val status: EmployeeStatus,
    val company: Company
)

enum class EmployeeStatus {
    ACTIVE, RETIRED
}
