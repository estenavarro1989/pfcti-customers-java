FROM openjdk:21
COPY target/customers-0.0.1-SNAPSHOT.jar customers-0.0.1.jar
ENTRYPOINT ["java","-jar","/customers-0.0.1.jar"]