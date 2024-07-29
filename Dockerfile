FROM alpine:3.18.3
RUN apk add --no-cache openjdk17
COPY build/libs/turbo-api-1.0.c4c14c7.jar /app/turbo-api-1.0.c4c14c7.jar
WORKDIR /app
ENTRYPOINT ["java"]
CMD ["-jar", "turbo-api-1.0.c4c14c7.jar"]
