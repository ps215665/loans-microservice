FROM openjdk:17-jdk-slim

LABEL version="1.0"
LABEL description="Loans Microservice image"

# Install curl and bash
RUN apt-get update && apt-get install -y curl bash && rm -rf /var/lib/apt/lists/*

COPY build/libs/loans-0.0.1-SNAPSHOT.jar loans-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "loans-0.0.1-SNAPSHOT.jar"]
