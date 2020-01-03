#Run Application from CMD 
mvn spring-boot:run

#Build Jar File
mvn clean install

#Created Docker image from docker file
- Create a file name with Dockerfile in project directory
- Then add required info and run below command in the location where Dockerfile is present
docker build -t spring-cloud-kafka-stream-consumer .

-t -> tag name
spring-cloud-kafka-stream-consumer -> Name of image

docker images
docker rmi imagename/imageid -->To remove image from local

docker-compose up -d -->run this command from the location where your docker-compose.yml is present

winpty docker exec -it cee17c732390 bash

cqlsh
