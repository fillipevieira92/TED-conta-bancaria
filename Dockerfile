FROM openjdk:18

RUN mkdir app

ARG JAR_FILE

ADD /target/${JAR_FILE} /app/FV-bank-docker.jar

WORKDIR /app


ENTRYPOINT java -jar FV-bank-docker.jar
