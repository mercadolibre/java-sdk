test:
	cd mockapi ; npm install
	node mockapi/app.js &
	mvn test
	kill `cat /tmp/mockapi.pid` 

deploy:
	cd mockapi ; npm install
	node mockapi/app.js &
	mvn -DaltDeploymentRepository=snapshot-repo::default::file:../java-sdk-repo/snapshots clean deploy
	kill `cat /tmp/mockapi.pid` 
	
.PHONY: test
