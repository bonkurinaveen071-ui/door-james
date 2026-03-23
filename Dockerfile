FROM eclipse-temurin:11-jdk

WORKDIR /app

COPY demo/ /app/

RUN chmod +x mvnw
RUN ./mvnw clean install

EXPOSE 8080

CMD ["java", "-jar", "target/*.jar"]