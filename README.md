![](https://github.com/Lylio/image-repo/blob/master/logos/java.png?raw=true)
![](https://github.com/Lylio/image-repo/blob/master/logos/spring-boot.png?raw=true)
# Emergency Contact Services
## Built with Spring Boot

### Description
A Spring Boot emergency contact application. Demo can be found at https://emergency-contact-services.herokuapp.com/

#### Docker Launch
1. `docker build -t emergency-contact-services .`
2. `docker run -p 9005:8080 emergency-contact-services:latest`
3. Open a tab/browser at http://localhost:9005

#### Maven Launch
1. `./mvnw spring-boot:run`
2. Open tab/browser at http://localhost:8080

### Swagger UI
1. `./mvnw spring-boot:run`
2. Open a tab/browser at http://localhost:8080/swagger-ui.html