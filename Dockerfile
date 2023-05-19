FROM openjdk:17
ENV POSTGRES localhost
COPY target/RESTproject-1.jar restapp.jar
ENTRYPOINT ["java", "-jar", "restapp.jar"]