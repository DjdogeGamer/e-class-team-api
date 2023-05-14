FROM maven:3.8.3-openjdk-11-slim AS builder

WORKDIR /app

COPY pom.xml .
#RUN mvn dependency:go-offline -B

COPY src ./src
#RUN mvn package -DskipTests


#FROM adoptopenjdk:20-jre-hotspot
FROM openjdk:11-jre-slim

WORKDIR /app

COPY --from=builder /app/target/e-class-team-0.0.1-SNAPSHOT.jar .
#COPY --from=builder /app/*.jar .

EXPOSE 80

CMD ["java", "-jar", "EClassTeamApplication.jar"]
