#!/usr/bin/env bash

start_spring_boot() {
  echo "start_spring_boot() running"
  cd ../ &&
  chmod +x ./mvnw &&
  ./mvnw spring-boot:run
}

start_spring_boot
