FROM adoptopenjdk:11-jre-hotspot
WORKDIR /home/s147197/restServer
COPY /var/lib/jenkins/workspace/server_master_branch/target/quarkus-app /home/s147197/restServer/quarkus-app
CMD java -jar quarkus-app/quarkus-run.jar