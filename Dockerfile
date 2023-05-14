FROM openjdk:17
ADD target/RESTproject-3.0.6.jar restapp.jar
ENTRYPOINT ["java", "-jar", "restapp.jar"]