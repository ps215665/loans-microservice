FROM openjdk:17-jdk-slim

LABEL version="1.0"
LABEL description="Loans Microservice image"

COPY build/libs/loans-0.0.1-SNAPSHOT.jar loans-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "loans-0.0.1-SNAPSHOT.jar"]
