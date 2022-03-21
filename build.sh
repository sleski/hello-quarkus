#!/bin/bash
set -e

mvn clean
mvn package -Pnative -Dquarkus.native.container-build=true

docker build -f src/main/docker/Dockerfile.native -t quarkus/hello-quarkus .

ls target
