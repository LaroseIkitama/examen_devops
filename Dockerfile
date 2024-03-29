FROM openjdk:17.0.8
EXPOSE 8080
ADD target/examen-larose.jar examen-larose.jar
ENTRYPOINT ["java","-jar","/examen-larose.jar"]