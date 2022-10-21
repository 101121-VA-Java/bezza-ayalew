FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/horizon2.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

