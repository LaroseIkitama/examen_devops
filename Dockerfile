FROM openjdk:17
EXPOSE 8085

# Définissez le répertoire de travail dans le conteneur
WORKDIR /app

# Copiez le fichier JAR de votre projet dans le conteneur
COPY target/nom-du-fichier.jar /app/app.jar

ENTRYPOINT ["java","-jar","/examen-larose.jar"]