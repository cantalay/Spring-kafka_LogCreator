FROM openjdk:8-jdk-alpine
ADD target/log-creator.jar log-creator.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "log-creator.jar"]
