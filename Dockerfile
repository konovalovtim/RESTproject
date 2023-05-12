FROM openjdk:17
ADD target/RESTproject-0.0.1-SNAPSHOT.jar restapp.jar
ENTRYPOINT ["java", "-jar", "restapp.jar"]