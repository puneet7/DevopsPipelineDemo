FROM openjdk:8-jre-alpine
COPY target/Calculator-1.0-SNAPSHOT.jar /Calculator.jar  
CMD ["/usr/bin/java", "-jar", "/Calculator.jar"]
