#!/bin/bash
set -e

mvn clean
mvn package -Pnative -Dquarkus.native.container-build=true

docker build -f src/main/docker/Dockerfile.native -t quarkus/hello-quarkus .

docker run -i --rm --name hello_quarkus --env PORT=8080 -p 8080:8080 quarkus/hello-quarkus
