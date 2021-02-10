FROM openjdk:8-jdk-alpine
#за основу взята 8 версия джавы
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} get-gif.jar
ENTRYPOINT ["java","-jar","/get-gif.jar"]