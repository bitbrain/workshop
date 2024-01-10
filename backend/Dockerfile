# let's ensure we build our app first using JDK 21 + gradle
FROM gradle:8.5.0-jdk21-alpine as build
WORKDIR /app
COPY . /app
RUN gradle build -x test
FROM openjdk:21-jdk
WORKDIR /app

COPY --from=build /app/build/libs/workshop-backend-0.0.1-SNAPSHOT.jar /app

ENTRYPOINT ["java", "-jar", "workshop-backend-0.0.1-SNAPSHOT.jar"]