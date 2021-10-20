FROM openjdk:11-jdk-alpine
ARG JAR_FILE=build/libs/foodtruck-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} foodtruck-0.0.1.jar
ENTRYPOINT ["java","-jar","/foodtruck-0.0.1.jar"]



# docker build --build-arg JAR_FILE=build/libs/\*.jar -t springio/gs-spring-boot-docker .

# docker build -t foodtruck/ms-foodtruck-spring-boot-docker .
# docker run -p 8080:8080 foodtruck/ms-foodtruck-spring-boot-docker