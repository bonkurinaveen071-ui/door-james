FROM eclipse-temurin:11-jdk

WORKDIR /app

COPY demo/ /app/

RUN chmod +x mvnw
RUN ./mvnw clean install

EXPOSE 8080

CMD ["sh", "-c", "java -jar target/doorjames-0.0.1-SNAPSHOT.jar"]