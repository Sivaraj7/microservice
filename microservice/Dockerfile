# ---------- Build Stage ----------
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn -q -e -DskipTests dependency:go-offline
COPY src ./src
RUN mvn -q -DskipTests package

# ---------- Runtime Stage ----------
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
# Add non-root user
RUN addgroup -S app && adduser -S app -G app
USER app
# Copy JAR with explicit name
COPY --from=build /app/target/microservice-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
