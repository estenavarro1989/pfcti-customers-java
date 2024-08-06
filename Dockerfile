FROM maven:3.9.8-eclipse-temurin-21 AS builder
WORKDIR build
COPY . .
RUN mvn clean install -DskipTests

FROM openjdk:21
COPY --from=builder /build/target/customers-0.0.1.jar customers-0.0.1.jar
ENTRYPOINT ["java","-jar","/customers-0.0.1.jar"]