# inquiry-server

alias inquiry-tomcat='cd ~/inquiry-server/inquiry-core/ ; pwd ; mvn install -Dmaven.test.skip=true ; cd ~/inquiry-server/inquiry-web/ ; pwd ; mvn tomcat7:run -Dmaven.test.skip=true -Pdevelopment'
