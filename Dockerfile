#FROM docker.io/cemmersb/centos-jdk8:latest
#MAINTAINER garyond
#VOLUME /tmp
#ADD eureka-server:1.0-SNAPSHOT.jar app.jar
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

# 添加 Java 11 镜像来源
FROM openjdk:11

# 添加参数
ARG JAR_FILE

# 添加 Spring Boot 包
ADD target/${JAR_FILE} app.jar

# 执行启动命令
ENTRYPOINT ["java","-jar","/app.jar"]