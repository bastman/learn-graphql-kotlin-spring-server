package com.example.demo

import com.expediagroup.graphql.annotations.GraphQLDescription
import com.expediagroup.graphql.spring.operations.Query
import org.springframework.stereotype.Component

@Component
class ConferenceQuery : Query {

    fun conference() = Conference(name = "GOTO Chicago", location = "virtual")
    fun people():List<People> = listOf(
            Speaker(name="Dariusz", talks = listOf("Bootiful GraphQL")),
            Attendee(name="Jane", ticketType = TicketType.CONFERENCE)
    )

}

interface People {
    val name:String
}

data class Speaker(override val name: String, val talks:List<String>):People
data class Attendee(override val name: String, val ticketType:TicketType):People

enum class TicketType {
    CONFERENCE, WORKSHOP, FULL
}
data class Conference(
        @GraphQLDescription("my super **awesome** conference 'name'")
        val name: String,
        @Deprecated("not needed anymore")
        val location: String?
)
