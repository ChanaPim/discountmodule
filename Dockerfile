FROM eclipse-temurin:17

WORKDIR /app

COPY . .

RUN chmod +x ./mvnw && ./mvnw clean package -DskipTests

EXPOSE 8080

CMD ["java", "-jar", "target/discountmodule-0.0.1-SNAPSHOT.jar"]
