#Run Application from CMD 
mvn spring-boot:run

#Build Jar File
mvn clean install

#Created Docker image from docker file
- Create a file name with Dockerfile in project directory
- Then add required info and run below command in the location where Dockerfile is present
docker build -t spring-cloud-kafka-producer .

-t -> tag name
spring-cloud-kafka-producer -> Name of image

docker images
docker rmi imagename/imageid -->To remove image from local


Test Data for PostMan
---------------------
localhost:8081/publishAccount

POST

Body

{
      "account_number": 1011,
      "account_status": "Active",
      "account_type": "Saving",
      "account_subtype": "Salary",
      "line_of_business": "NA"
}

