# =========================
# Build Stage
# =========================
FROM eclipse-temurin:25-jdk AS build

WORKDIR /app

COPY pom.xml mvnw ./
COPY .mvn .mvn

RUN chmod +x mvnw && \
    ./mvnw dependency:resolve -B

COPY src src

RUN ./mvnw clean package -DskipTests -B

# =========================
# Runtime Stage
# =========================
FROM eclipse-temurin:25-jre

WORKDIR /app

# Install curl for ECS container health checks
RUN apt-get update \
 && apt-get install -y --no-install-recommends curl \
 && rm -rf /var/lib/apt/lists/*

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]