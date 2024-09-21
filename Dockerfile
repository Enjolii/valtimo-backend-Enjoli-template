FROM eclipse-temurin:21-jre-alpine

ADD build/libs/valtimo-backend-template.war /app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]