FROM openjdk:11
RUN mkdir /app
COPY target/classes/ /app
WORKDIR /app
CMD java target/classes/application/Application

