Design and implement a JSON API using Hibernate/Spring/SpringMVC (or Spring-Boot) **without frontend**.

The task is:

Build a voting system for deciding where to have lunch.

 * 2 types of users: admin and regular users
 * Admin can input a restaurant and it's lunch menu of the day (2-5 items usually, just a dish name and price)
 * Menu changes each day (admins do the updates)
 * Users can vote on which restaurant they want to have lunch at
 * Only one vote counted per user
 * If user votes again the same day:
    - If it is before 11:00 we asume that he changed his mind.
    - If it is after 11:00 then it is too late, vote can't be changed

Each restaurant provides new menu each day.

-----------------------------



Voting system for deciding where to have lunch (REST only).
==================


Implementation Stack:

For admin CRUD:
- <a href="http://projects.spring.io/spring-boot/">Spring Boot</a>
- <a href="http://projects.spring.io/spring-hateoas/">Spring HATEOAS</a>
- <a href="http://projects.spring.io/spring-data-rest/">Spring Data REST</a>

For Voting:
- <a href="http://projects.spring.io/spring-data-jpa/">Spring Data JPA</a>

## Install:

    https://github.com/Matevitsky/voting_system

## Run (from project directory)

### Dev environment

    $ mvn spring-boot:run


- <a href="http://localhost:8082/">H2 console</a>
- User: `sa`, password: `zD5z6Wx`
- JDBC URL: `jdbc:h2:mem:voting` 
- 

## <a href="http://localhost:8080/api/users">The HAL Browser</a>

        User login: user@yandex.ru
          password: password
    "Authorization: Basic dXNlckB5YW5kZXgucnU6cGFzc3dvcmQ="


       Admin login: admin@gmail.com
          password: admin
    "Authorization:Basic YWRtaW5AZ21haWwuY29tOmFkbWlu"

### User handling

    403:Forbidden
    curl 'http://localhost:8080/api/users' -i -H'Authorization: Basic dXNlckB5YW5kZXgucnU6cGFzc3dvcmQ='

- <a href="http://localhost:8080/api/users">Users list</a>
- <a href="http://localhost:8080/api/users/0">Users 0</a>
- <a href="http://localhost:8080/api/users/search/by-email?email=admin@gmail.com">Users by email: admin@gmail.com</a>

CURL:

     curl 'http://localhost:8080/api/users' -i -H'Authorization:Basic YWRtaW5AZ21haWwuY29tOmFkbWlu'
     curl 'http://localhost:8080/api/users/0' -i -H'Authorization:Basic YWRtaW5AZ21haWwuY29tOmFkbWlu'
     curl 'http://localhost:8080/api/users/?email=admin@gmail.com' -i -H'Authorization:Basic YWRtaW5AZ21haWwuY29tOmFkbWlu'
     curl 'http://localhost:8080/api/users' -i -d'{"name" : "NewUser", "email" : "new@mail.ru","password" : "123456","roles" : ["ROLE_USER"]}' -H'Authorization:Basic YWRtaW5AZ21haWwuY29tOmFkbWlu' -H'Content-Type: application/json'

### Restorant handling

- <a href="http://localhost:8080/api/restaurants">Restaurant list</a>
- <a href="http://localhost:8080/api/restaurants/0">Restaurant 0</a>
- <a href="http://localhost:8080/api/restaurants/search/by-name?name=Don">Restaurant by name: name=Don</a>

CURL:

     curl 'http://localhost:8080/api/restaurants' -i -H'Authorization: Basic dXNlckB5YW5kZXgucnU6cGFzc3dvcmQ='
     curl 'http://localhost:8080/api/restaurants/0' -i -H'Authorization: Basic dXNlckB5YW5kZXgucnU6cGFzc3dvcmQ='
     curl 'http://localhost:8080/api/restaurants/search/by-name?name=Don' -i -H'Authorization: Basic dXNlckB5YW5kZXgucnU6cGFzc3dvcmQ='

Modification (Access denied for User):

     curl 'http://localhost:8080/api/restaurants' -i -d'{"name" : "Subway"}' -H'Authorization: Basic dXNlckB5YW5kZXgucnU6cGFzc3dvcmQ=' -H'Content-Type: application/json'

Modification (Access allowed for Admin):

     curl 'http://localhost:8080/api/restaurants' -i -d'{"name" : "Subway"}' -H'Authorization: Basic YWRtaW5AZ21haWwuY29tOmFkbWlu' -H'Content-Type: application/json'
     curl 'http://localhost:8080/api/restaurants/3' -i -X DELETE -H'Authorization: Basic YWRtaW5AZ21haWwuY29tOmFkbWlu' -H'Content-Type: application/json'

### Menu handling

- <a href="http://localhost:8080/api/menus">Menu list</a>
- <a href="http://localhost:8080/api/menus/0">Menu 0</a>
- <a href="http://localhost:8080/api/menus/search/by-date?date=2015-11-19">Menu for date 2015-11-19</a>
- <a href="http://localhost:8080/api/menus/search/by-restaurant?restaurant=http://localhost:8080/api/restaurants/0">Menu for restaurant 0</a>

CURL:

     curl 'http://localhost:8080/api/menus' -i -H'Authorization: Basic YWRtaW5AZ21haWwuY29tOmFkbWlu'
     curl 'http://localhost:8080/api/menus/0' -i -H'Authorization: Basic YWRtaW5AZ21haWwuY29tOmFkbWlu'
     curl 'http://localhost:8080/api/menus' -i -d'{"date" : "2015-11-17", "restaurant":"http://localhost:8080/api/restaurants/0"}' -H'Authorization: Basic YWRtaW5AZ21haWwuY29tOmFkbWlu' -H'Content-Type: application/json'
     curl 'http://localhost:8080/api/menus/1' -i -X PUT -d'{"date" : "2015-11-16"}' -H'Authorization: Basic YWRtaW5AZ21haWwuY29tOmFkbWlu' -H'Content-Type: application/json'
     curl 'http://localhost:8080/api/menus/search/by-date?date=2015-11-19' -i -H'Authorization:Basic YWRtaW5AZ21haWwuY29tOmFkbWlu'
     curl 'http://localhost:8080/api/menus/search/by-restaurant?restaurant=http://localhost:8080/api/restaurants/0' -i -H'Authorization:Basic YWRtaW5AZ21haWwuY29tOmFkbWlu'

### Lunch handling
- <a href="http://localhost:8080/api/lunches">Lunch list</a>
- <a href="http://localhost:8080/api/lunches/1">Lunch 1</a>
- <a href="http://localhost:8080/api/lunches/search/by-date?date=2015-11-19">Lunch for date 2015-11-19</a>
- <a href="http://localhost:8080/api/lunches/search/by-menu?menu=http://localhost:8080/api/menus/1">Lunch for menu 1</a>

CURL:

     curl 'http://localhost:8080/api/lunches' -i -H'Authorization: Basic YWRtaW5AZ21haWwuY29tOmFkbWlu'
     curl 'http://localhost:8080/api/lunches/11' -i -H'Authorization: Basic YWRtaW5AZ21haWwuY29tOmFkbWlu'
     curl 'http://localhost:8080/api/lunches' -i -d'{"name" : "Desert", "menu":"http://localhost:8080/api/menus/5"}' -H'Authorization: Basic YWRtaW5AZ21haWwuY29tOmFkbWlu' -H'Content-Type: application/json'
     curl 'http://localhost:8080/api/lunches/search/by-date?date=2015-11-19' -i -H'Authorization:Basic YWRtaW5AZ21haWwuY29tOmFkbWlu'
     curl 'http://localhost:8080/api/lunches/search/by-menu?menu=http://localhost:8080/api/menus/1' -i -H'Authorization:Basic YWRtaW5AZ21haWwuY29tOmFkbWlu'

## Voting
- <a href="http://localhost:8080/api/vote">Current Vote</a>

Vote for menu 0: 

     curl 'http://localhost:8080/api/vote/0' -i -X POST -H'Authorization: Basic dXNlckB5YW5kZXgucnU6cGFzc3dvcmQ=' -H'Content-Type: application/json'
Vote for menu 2: 

     curl 'http://localhost:8080/api/vote/2' -i -X POST -H'Authorization: Basic dXNlckB5YW5kZXgucnU6cGFzc3dvcmQ=' -H'Content-Type: application/json'
     
Check current vote:

     curl 'http://localhost:8080/api/vote' -i -H'Authorization: Basic dXNlckB5YW5kZXgucnU6cGFzc3dvcmQ='
