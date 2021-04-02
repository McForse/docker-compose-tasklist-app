FROM maven:3-openjdk-15
ADD . /web
WORKDIR /web
RUN mvn clean install -DskipTests

FROM openjdk:15-jdk-alpine
ARG JAR_FILE=/web/backend/target/*.jar
COPY --from=0 $JAR_FILE /app.jar
EXPOSE 8080
ENTRYPOINT exec java -jar /app.jar
