#!/bin/sh
cd ..
mvn clean install --projects spring-boot-demo
cd spring-boot-demo/target/test-classes/projects/basic/project/spring-boot-jar/
chromium-browser --incognito http://localhost:8080/
mvn spring-boot:run
