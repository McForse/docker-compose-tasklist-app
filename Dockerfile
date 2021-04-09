FROM maven:3-openjdk-15
ADD . /web
WORKDIR /web
RUN mvn clean install -DskipTests

FROM openjdk:15-jdk-alpine
ARG JAR_FILE=/web/backend/target/*.jar
COPY --from=0 $JAR_FILE /app.jar
LABEL org.opencontainers.image.source="https://github.com/McForse/docker-compose-tasklist-app"
ENTRYPOINT exec java -jar /app.jar
