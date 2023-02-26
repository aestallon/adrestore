# AdreStore

An example Angular - Spring Boot project managing simple addresses.

## How to Run

The following are necessary to run the application:

- JDK 17+
- any LTS version of NodeJS
- Angular 13

## Exercise Requirements

The structure of the database used was based on the requirements outlined in the following exercise
definition:

> Create an address management Spring Boot application. The database must contain 3 tables: persons,
> addresses and address items. A person may be associated with two addresses at most (a temporary
> and
> a permanent one); one address may be associated with multiple items (e-mail, phone, etc.).
>
> The responsibilities of the application:
>
> - querying the above data
> - saving, updating and deleting the above data (error handling included)
> - tests

To comply with the above requirements, a relational database was used.

## Principles and Technologies Used

### Contract First

The interface between FE and BE are defined by an [OpenApi contract](./adrestore.yaml). To ensure
both halves of the application comply with it, the mandated model types and services are generated
using the OpenApi generator. The generation may be performed by running the `openApiGenerate` task
of the backend's [build script](./be-spring/build.gradle) and the `generate:adrestore` script found
in the frontend's [package.json](./ui-angular/package.json).

### Backend Structure

- Spring Boot 2.7.8
- FS based H2 relational database for persistence
- Spring Data JPA for an ORM
- JUnit for testing with Assert4J for assertions (upcoming)
- 