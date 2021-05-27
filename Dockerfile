FROM openjdk:8-jre-alpine  

#VOLUME /tmp
#COPY ${DEPENDENCY}/BOOT-INF/classes /app
#EXPOSE 9091
#WORKDIR /rbc-api  
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

#COPY .mvnw .
#COPY .mvn .mvn 
#RUN ./mvnw clean package 

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} rbc-api.jar

#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/rbc-api.jar"] not required with jdk8 & above
ENTRYPOINT ["java", "-jar","/rbc-api.jar"]