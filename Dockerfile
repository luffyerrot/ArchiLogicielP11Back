FROM openjdk:17-jdk

WORKDIR /app

COPY target/medhead-0.0.1-SNAPSHOT.jar /app/medhead-api-search.jar

EXPOSE 8080

CMD ["java", "-jar", "-Dspring.profiles.active=prod", "medhead-api-search.jar"]