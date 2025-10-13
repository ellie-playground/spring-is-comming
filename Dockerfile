FROM amazoncorretto:17-alpine-jdk

WORKDIR /application

COPY ./dependencies/ ./
COPY ./spring-boot-loader/ ./
COPY ./snapshot-dependencies/ ./
COPY ./application/ ./

# https://github.com/spring-projects/spring-boot/issues/37667
ENTRYPOINT ["java", "-Dspring.profiles.active=dev", "-Duser.timezone=Asia/Seoul", "org.springframework.boot.loader.launch.JarLauncher"]
