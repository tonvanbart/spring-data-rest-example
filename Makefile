.PHONY: add-hobbit
add-hobbit:
	curl -i -H "Content-Type:application/json" -d '{"firstName": "Bilbo", "lastName": "Baggins"}' http://localhost:8080/people

.PHONY: add-spock
add-spock:
	curl -i -H "Content-Type:application/json" -d '{"firstName": "Spock", "lastName": "Baggins"}' http://localhost:8080/people

.PHONY: list
list:
	curl localhost:8080/people

