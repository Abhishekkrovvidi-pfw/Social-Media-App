# Social-Media-App
A simple REST API for social media using Spring Boot, Maven, JPA, Docker, and MySQL.
Created a Rest Api for social media app using spring boot with all the spring boot properties mentioned below:
1.Users can perform CRUD operations and also Post into H2 database data.sql
2.Internationalization (I18N) for different languages in the hello world application.
3.Versioning:
 URI Versioning-Twitter
 Request Param-Amazon
 headers versioning-Microsoft
 Media Type Versioning-Github
4.HATEOAS - Hypermedia as the engine of Application State
5.Filtering(Static and Dynamic)
6.Monitoring Rest Api using springBoot actuator: provides a number of endPoints beans, health, metrics, mappings.
7.Monitoring Rest Api using springBoot HAL(Json hypertext Application Language) Explorer
8.JPA and Hibernate to connect to H2 database
//Hibernate: create sequence post_seq start with 1 increment by 50
 Hibernate: create sequence user_details_seq start with 1 increment by 50
 Hibernate:create table post (id integer not null, user_id integer, description varchar(255), primary key (id))
 Hibernate: create table user_details (birth_day date, id integer not null, name varchar(255), primary key (id))//
9.Connected REST api to mySQL database as a Docker Container
10.implemented basic spring security and authentication for the Rest Api
