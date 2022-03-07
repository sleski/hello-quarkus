# hello-quarkus

Based on this article:
https://blog.doubleslash.de/how-to-deploy-a-native-quarkus-application-on-heroku/

# Steps:

## build native image

* mvn package -Pnative -Dquarkus.native.container-build=true

## build docker image
* docker build -f src/main/docker/Dockerfile.native -t quarkus/hello-quarkus .
* docker run -i --rm --name hello_quarkus --env PORT=8081 -p 8081:8081 quarkus/hello-quarkus

## heroku part:

* heroku login
* heroku container:login
* docker tag quarkus/hello-quarkus registry.heroku.com/hello-quarkus/web
* heroku create hello-quarkus --region eu (this only once, to create the app)
* docker push registry.heroku.com/hello-quarkus/web
* heroku container:release web -a hello-quarkus
