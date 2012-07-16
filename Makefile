test:
	node mockapi/app.js &
	mvn test
	$(pkill -9 node)
	
.PHONY: test
