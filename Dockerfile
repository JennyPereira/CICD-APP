FROM fabric8/java-alpine-openjdk8-jre

# Add Maintainer Info
LABEL maintainer="jennypereira121996@gmail.com"

# Add a volume pointing to /tmp
VOLUME /tmp
ADD target/springboot-servicio-usuarios-0.0.1-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS="-Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8085,suspend=n"
ENV SPRING_PROFILES_ACTIVE "docker"

EXPOSE 8080 8085

# Add the application's jar to the container
#ADD ${JAR_FILE} app.jar

# Run the jar file 
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=$SPRING_PROFILES_ACTIVE -jar /app.jar" ]
