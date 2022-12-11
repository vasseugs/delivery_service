FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} kitchen.jar
ENTRYPOINT ["java", "-jar", "kitchen.jar"]
EXPOSE 8080