package com.example.demo

import com.expediagroup.graphql.annotations.GraphQLDescription
import com.expediagroup.graphql.spring.operations.Query
import org.springframework.stereotype.Component

@Component
class ConferenceQuery : Query {
    fun conference() = Conference(name = "GOTO Chicago", location = "virtual")
}

data class Conference(
        @GraphQLDescription("my super **awesome** conference 'name'")
        val name: String,
        @Deprecated("not needed anymore")
        val location: String?
)
