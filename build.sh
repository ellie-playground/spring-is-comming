#!/bin/bash

set -e
./gradlew clean bootJar -x test
java -Djarmode=layertools -jar build/libs/yogiyo-0.0.1-SNAPSHOT.jar extract
docker-compose up -d --build