FROM openjdk:17-jdk-alpine
COPY --from=builder /usr/src/build/libs/cgv-server-0.0.1-SNAPSHOT.jar /usr/app/app.jar
ENTRYPOINT ["java", "-jar", "/usr/app/app.jar"]