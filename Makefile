run:
	./mvnw clean spring-boot:run

debug:
	./mvnw clean spring-boot:run -Dspring-boot.run.jvmArguments="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=8000"
