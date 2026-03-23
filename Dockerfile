FROM openjdk:11-jdk-slim

WORKDIR /app

COPY demo/ /app/

RUN chmod +x mvnw
RUN ./mvnw clean install

EXPOSE 8080

CMD ["java", "-jar", "target/*.jar"]