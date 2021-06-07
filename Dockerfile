FROM openjdk:12-oracle
COPY demo-0.0.1-SNAPSHOT.jar /usr/share
WORKDIR /usr/share
EXPOSE 8080
ENTRYPOINT ["java","-jar", "demo-0.0.1-SNAPSHOT.jar"]
