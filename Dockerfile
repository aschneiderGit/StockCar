FROM tomcat:9
ADD "./esieaBack-main/esieaBack.war" "/usr/local/tomcat/webapps/esieaBack.war"
ADD "./esieaFront-main/esieaFront.war" "/usr/local/tomcat/webapps/esieaFront.war"
EXPOSE 8080
CMD catalina.sh run
