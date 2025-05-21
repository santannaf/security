FROM ghcr.io/graalvm/graalvm-community:21 AS builder

WORKDIR /app

COPY . .

RUN chmod +x ./gradlew && ./gradlew clean build
