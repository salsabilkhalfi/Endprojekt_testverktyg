FROM maven:3.9.2 AS build
WORKDIR ./
COPY ./ ./
RUN mvn package -DskipTests

FROM amazoncorretto:20.0.1-alpine3.17
RUN mkdir /app
COPY --from=build target/Spring_Thymeleaf-0.0.1-SNAPSHOT.jar /opt/app/java-application.jar
COPY --from=build target opt/app/
CMD "java" "-jar" "/opt/app/java-application.jar"
