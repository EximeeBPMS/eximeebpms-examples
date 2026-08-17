#!/bin/sh
cd ..
mvn clean install --projects servlet-war-demo
cd servlet-war-demo/target/test-classes/projects/basic/project/basic-servlet-jar/
chromium-browser --incognito http://localhost:8080/eximeebpms
mvn wildfly:deploy
