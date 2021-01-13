FROM maven AS build
COPY pom.xml /tmp/
COPY src /tmp/src/
COPY web /tmp/web/
WORKDIR /tmp/
RUN mvn package

FROM tomcat
COPY --from=build /tmp/target/evening-courses-applications-service.war /usr/local/tomcat/webapps/
