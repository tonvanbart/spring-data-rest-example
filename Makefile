.PHONY: add-hobbit
add-hobbit:
	curl -i -H "Content-Type:application/json" -d '{"firstName": "Bilbo", "lastName": "Baggins"}' http://localhost:8080/people

.PHONY: update-hobbit
update-hobbit:
	curl -i -X PUT -H "Content-Type:application/json" -d '{"firstName": "Bilbo-updated", "lastName": "Baggins"}' http://localhost:8080/people/1

.PHONY: update-spock
update-spock:
	curl -i -X PUT -H "Content-Type:application/json" -d '{"firstName": "Spock", "lastName": "Baggins"}' http://localhost:8080/people/2

.PHONY: post-amelia
post-amelia:
	curl -i -X POST -H "Content-Type:application/json" -d '{"firstName": "Amelia", "lastName": "Baggins", "favoriteSnacks":[{"name": "Cookies"}]}' http://localhost:8080/people

#.PHONY: patch-amelia
#patch-amelia:
	#curl -i -X POST -H "Content-Type:application/json" -d '{"firstName": "Amelia", "lastName": "Baggins", "favoriteSnacks":[{"name": "Cookies"}]}' http://localhost:8080/people

.PHONY: add-spock
add-spock:
	curl -i -H "Content-Type:application/json" -d '{"firstName": "Spock", "lastName": "Baggins"}' http://localhost:8080/people

.PHONY: list
list:
	curl localhost:8080/people

.PHONY: list-first
list-first:
	curl localhost:8080/people/1

.PHONY: database
database:
	docker run -p 3306:3306 --name docker-mysql -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=hobbitdb -e MYSQL_USER=sa -e MYSQL_PASSWORD=password mysql/mysql-server:latest

# works:
.PHONY: patch-frodo
patch-frodo:
	curl -i -X PATCH http://localhost:8080/people/1 -H "Content-Type: application/json-patch+json" -d '[{"op":"replace","path":"/firstName","value": "Froodoo"}]'

# gives an error:
.PHONY: add-frodo-snack
add-frodo-snack:
	curl -i -X PATCH http://localhost:8080/people/1 -H "Content-Type: application/json-patch+json" -d '[{"op":"add","path":"/favoriteSnacks/-","value": {"name":"Chips"}}]'

.PHONY: replace-frodo-snack
replace-frodo-snack:
	curl -i -X PATCH http://localhost:8080/people/1 -H "Content-Type: application/json-patch+json" -d '[{"op":"replace","path":"/favoriteSnacks","value": [{"name":"Chips"}]}]'

