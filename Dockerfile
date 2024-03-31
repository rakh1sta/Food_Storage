FROM openjdk:17-jdk-alpine
EXPOSE 8080
COPY target/OnlineFoodStorage-0.0.1-SNAPSHOT.jar food-store-1.0.0.jar
ENTRYPOINT ["java","-jar","/food-store-1.0.0.jar"]