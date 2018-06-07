curl -d '{"firstName":"juan"}' -H "Content-Type: application/json" -X POST http://localhost:8881/employee
curl -d '{"firstName":"pedro"' -H "Content-Type: application/json" -X POST http://localhost:8881/employee

curl -d '{"name":"spring"}' -H "Content-Type: application/json" -X POST http://localhost:8881/project
curl -d '{"name":"attendance"}' -H "Content-Type: application/json" -X POST http://localhost:8881/project
curl -d '{"name":"coffe shop"}' -H "Content-Type: application/json" -X POST http://localhost:8881/project
curl -d '{"name":"c++"}' -H "Content-Type: application/json" -X POST http://localhost:8881/project

#curl -d '{"employee":{"id" : "1"},"project":{"id" : "2"},"duration":"10"}' -H "Content-Type: application/json" -X POST http://localhost:8881/projectEmployee
#curl -d '{"employee":{"id" : "1"},"project":{"id" : "2"},"duration":"10"}' -H "Content-Type: application/json" -X POST http://localhost:8881/projectEmployee
#curl -d '{"employee":{"id" : "1"},"project":{"id" : "2"},"duration":"10"}' -H "Content-Type: application/json" -X POST http://localhost:8881/projectEmployee
