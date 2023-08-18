FROM openjdk:17-jdk-alpine
EXPOSE 8080
ARG JAR_FILE=target/Broker-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} application.jar
ENTRYPOINT ["java","-jar","application.jar"]


