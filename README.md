# hello-quarkus

Based on this article:
https://blog.doubleslash.de/how-to-deploy-a-native-quarkus-application-on-heroku/

# Steps:

## build native image

* mvn package -Pnative -Dquarkus.native.container-build=true

## build docker image
* docker build -f src/main/docker/Dockerfile.native -t quarkus/hello-quarkus .

## heroku part:

* heroku login
* heroku container:login
* docker tag quarkus/hello-quarkus registry.heroku.com/hello-quarkus/web
* docker push registry.heroku.com/hello-quarkus/web
* heroku container:release web -a hello-quarkus
