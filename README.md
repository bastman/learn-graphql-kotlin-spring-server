# kotlin-graphql-learn
getting started with graphql spring-webflux (expedia libs)

## docs

based on: https://www.reddit.com/r/Kotlin/comments/hzzleu/bootiful_graphql_with_kotlin/

see: 
- https://expediagroup.github.io/graphql-kotlin/docs/getting-started.html
- https://expediagroup.github.io/graphql-kotlin/docs/spring-server/spring-overview

## note

- requires spring webflux. (does not work with webmvc)

## play

- http://localhost:8080/playground


```
query {
  conference {
    name
    location
  }
  people(nameStartsWith:"D") {
    name
    ... on Speaker {
      talks
    }
    ... on Attendee {
      ticketType
    }
  }
}
```

```
query {
  schedule {
    greeting
  }
}
```
```
# simulate slow query to downstream service that provides "talks"
query {
  s1: schedule {
    greeting
    talks
  }
  s2: schedule {
    greeting
    talks
  }
}
```
