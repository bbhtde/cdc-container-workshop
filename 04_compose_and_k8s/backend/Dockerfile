FROM maven:latest
ADD . .
RUN mvn clean package

FROM openjdk:17-jdk-slim
COPY --from=0 target/backend-0.0.1-SNAPSHOT.jar backend-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "backend-0.0.1-SNAPSHOT.jar"]