FROM maven:3.8.3-openjdk-17 AS builder
WORKDIR /app
COPY . /app
RUN mvn clean package -DskipTests

FROM openjdk:17-alpine AS prod
COPY --from=builder /app/target/*.jar /book_shop.jar
CMD java -jar  /book_shop.jar
EXPOSE 8081
