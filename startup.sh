#!/usr/bin/env bash

start_spring_boot() {
  echo "**Spring Boot running**"
  ./mvnw spring-boot:run
}

start_spring_boot
