# hello-quarkus

Based on this article:
https://blog.doubleslash.de/how-to-deploy-a-native-quarkus-application-on-heroku/

# Steps:

## build native image

* mvn package -Pnative -Dquarkus.native.container-build=true

## build and run docker image
* docker build -f src/main/docker/Dockerfile.native -t quarkus/hello-quarkus .
* docker run -i --rm --name hello_quarkus --env PORT=8081 -p 8081:8081 quarkus/hello-quarkus

