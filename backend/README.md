# Workshop backend

This is the backend providing a REST API for the workshop system.

## Run locally (full docker)

1. Ensure to install [latest Docker](https://www.docker.com/products/docker-desktop/)
2. Run `docker-compose up`
## Run locally (local java)

1. Ensure to install [latest Docker](https://www.docker.com/products/docker-desktop/)
2. Ensure to install [Java JDK 21](https://www.oracle.com/java/technologies/downloads/)
3. Run `docker-compose -f mysql-only.yml up`
4. Run
```bash
./gradlew bootRun
```

## REST API

To access the REST API, query `http://localhost:8080` and visit [localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html) for API docs.

## Technologies used

- Spring Boot 3
- MySQL 8
- Docker