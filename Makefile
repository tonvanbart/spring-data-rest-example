.PHONY: add-hobbit
add-hobbit:
	curl -i -H "Content-Type:application/json" -d '{"firstName": "Bilbo", "lastName": "Baggins"}' http://localhost:8080/people

.PHONY: add-spock
add-spock:
	curl -i -H "Content-Type:application/json" -d '{"firstName": "Spock", "lastName": "Baggins"}' http://localhost:8080/people

.PHONY: list
list:
	curl localhost:8080/people

.PHONY: database
database:
	docker run -p 3306:3306 --name docker-mysql -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=hobbitdb -e MYSQL_USER=sa -e MYSQL_PASSWORD=password mysql/mysql-server:latest

