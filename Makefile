test:
	cd mockapi ; npm install
	node mockapi/app.js &
	mvn test
	kill `cat /tmp/mockapi.pid` 
	
.PHONY: test
