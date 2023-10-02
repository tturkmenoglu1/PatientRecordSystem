FROM maven:3.8.3-openjdk-11 AS build
COPY . .
RUN mvn clean package -DskipTests


FROM openjdk:11-jdk-slim-sid
COPY --from=build /target/patient-control-0.0.1-SNAPSHOT.jar patient-control.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","/patient-control.jar"]


#ARG JAR_FILE=target/*.jar
#COPY ./target/patient-control-0.0.1-SNAPSHOT.jar app.jar