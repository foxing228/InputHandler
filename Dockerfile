FROM openjdk:11
EXPOSE 8080
COPY inputhandler.jar /
ENTRYPOINT ["java", "-jar", "inputhandler.jar"]
