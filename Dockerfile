FROM openjdk:18-alpine
COPY target/words-0.0.1-SNAPSHOT.jar words.jar
ENTRYPOINT ["java","-jar","words.jar"]