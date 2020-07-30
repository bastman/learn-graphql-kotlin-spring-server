package com.example.demo

import com.expediagroup.graphql.annotations.GraphQLDescription
import com.expediagroup.graphql.spring.operations.Query
import kotlinx.coroutines.delay
import org.springframework.stereotype.Component

@Component
class ConferenceQuery : Query {

    fun conference() = Conference(name = "GOTO Chicago", location = "virtual")
    fun people(nameStartsWith: String?): List<People> = listOf(
            Speaker(name = "Dariusz", talks = listOf("Bootiful GraphQL")),
            Attendee(name = "Jane", ticketType = TicketType.CONFERENCE)
    ).filter { it.name.startsWith(nameStartsWith ?: "") }

    fun schedule() = ScheduleDetails(
            greeting = "Welcome to GOTO Chicago!"
    )

}

class ScheduleDetails(
        val greeting: String
) {
    // simulate expensive query to some downstream service
    suspend fun talks(): List<String> {
        delay(2_000)
        return listOf(
                "Bootiful GraphQL",
                "GraphQL is awesome",
                "Intro to GraphQL"
        )
    }
    /*
    fun talks():List<String> {
        Thread.sleep(2_000)
        return listOf(
                "Bootiful GraphQL",
                "GraphQL is awesome",
                "Intro to GraphQL"
        )
    }
     */
}

interface People {
    val name: String
}

data class Speaker(override val name: String, val talks: List<String>) : People
data class Attendee(override val name: String, val ticketType: TicketType) : People

enum class TicketType {
    CONFERENCE, WORKSHOP, FULL
}

data class Conference(
        @GraphQLDescription("my super **awesome** conference 'name'")
        val name: String,
        @Deprecated("not needed anymore")
        val location: String?
)
