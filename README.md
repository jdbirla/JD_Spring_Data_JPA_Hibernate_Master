# JD_Hibernate_Master
This repository will contains all learnings about hibernate , JPA and Spring Data JPA

1. Run docker container with same volume to creating multiple database for persitent even container has been deleted all data will be remained same

```sh
docker run --detach --env MYSQL_ROOT_PASSWORD=myrootsqlpass --env MYSQL_USER=jd-user --env MYSQL_PASSWORD=jdsqlpass --env MYSQL_DATABASE=jddb --name jdmysqlcontainer --publish 3306:3306 --network=web-application-mysql-network --volume mysql-database-volume:/var/lib/mysql  mysql:latest
```
2. currently one user jd-user and two schemas are running jddb and myblog are running 
![image](https://user-images.githubusercontent.com/69948118/206951250-f0363092-ece0-4fa0-9877-ae6a2d936ea0.png)

3. When we required to create new database then create new database from root user using sql query or mysqlwork bench

4. In order to get same databses and data use the same command to run the container which is step1

5. Spring data JPA properties
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce?useSSL=false
spring.datasource.username=root
spring.datasource.password=mysqlpassword


spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL8Dialect
spring.jpa.properties.hibernate.dialect.storage_engine=innodb


spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```
