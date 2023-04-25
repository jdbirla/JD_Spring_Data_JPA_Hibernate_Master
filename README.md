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
spring.datasource.url=jdbc:mysql://localhost:3306/myblog?useSSL=false
spring.datasource.username=root
spring.datasource.password=myrootsqlpass


spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL8Dialect
spring.jpa.properties.hibernate.dialect.storage_engine=innodb


spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

#Show bind values
# Pre Spring Boot 3.0.2
# logging.level.org.hibernate.type.descriptor.sql=trace
# Spring Boot 3.0.2+
logging.level.org.hibernate.orm.jdbc.bind=TRACE
# Hibernate > 6.0 
logging.level.org.hibernate.sql=debug
logging.level.org.hibernate.orm.jdbc.bind=trace
# Statistics and slow queries
logging.level.logger.org.hibernate.stat=debug
logging.level.logger.org.hibernate.SQL_SLOW=info
# 2nd Level Cache
logging.level.logger.org.hibernate.cache=debug

# Show transaction log of Spring data jpa and hibernate
logging.level.ROOT=INFO 
logging.level.org.springframework.orm.jpa=DEBUG 
logging.level.org.springframework.transaction=DEBUG 
logging.level.org.hibernate.engine.transaction.internal.TransactionImpl=DEBUG


# Using this data.sql will execute after table creation
DATABASE_TO_UPPER=false
spring.jpa.defer-datasource-initialization=true
spring.sql.init.mode=always

#Show SQL
spring.jpa.properties.hibernate.show_sql=true

#Format SQL
spring.jpa.properties.hibernate.format_sql=true

# H2 Config
spring.h2.console.enabled=true
spring.datasource.url=jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE;MODE=MYSQL;DATABASE_TO_LOWER=TRUE;CASE_INSENSITIVE_IDENTIFIERS=TRUE
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database=mysql
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update


```

6. MySql Create databse and user
```sql
DROP DATABASE IF EXISTS bookdb;
DROP USER IF EXISTS `bookadmin`@`%`;
DROP USER IF EXISTS `bookuser`@`%`;
CREATE DATABASE IF NOT EXISTS bookdb CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE USER IF NOT EXISTS `bookadmin`@`%` IDENTIFIED WITH mysql_native_password BY 'password';
GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, DROP, REFERENCES, INDEX, ALTER, EXECUTE, CREATE VIEW, SHOW VIEW,
CREATE ROUTINE, ALTER ROUTINE, EVENT, TRIGGER ON `bookdb`.* TO `bookadmin`@`%`;
CREATE USER IF NOT EXISTS `bookuser`@`%` IDENTIFIED WITH mysql_native_password BY 'password';
GRANT SELECT, INSERT, UPDATE, DELETE, SHOW VIEW ON `bookdb`.* TO `bookuser`@`%`;
FLUSH PRIVILEGES;
```
