## JPA
Src: https://www.youtube.com/watch?v=MaI0_XdpdP8&t=1844s
Github: https://www.youtube.com/redirect?event=video_description&redir_token=QUFFLUhqbFAzMVliR0c0V3R5NkhGVEIyc0dmN3ZzeEs4QXxBQ3Jtc0ttUWJCbzZrOHBaUzdKbGVlTDRIRGJSd1FGNHZHNjdERk1pYVVhRmVzSFVNR3RvQTNpRm1qWVd0S2dFdEN0VWt0cEI3WFl5b3N4aGtOOVFzWVkxTEt5Mi1EMDd4OWZxaFpBSmZTX0s5Z0lLZDRWbVU1OA&q=https%3A%2F%2Fgithub.com%2Fin28minutes%2Fgetting-started-in-5-steps%2Ftree%2Fmaster%2Fjpa-in-10-steps&v=MaI0_XdpdP8

![image](https://user-images.githubusercontent.com/69948118/180342274-8e363e44-c790-4312-a35f-c93c475e3c81.png)
![image](https://user-images.githubusercontent.com/69948118/180342721-0d7b9710-ca66-4630-8376-a87f5ed3e9d6.png)
![image](https://user-images.githubusercontent.com/69948118/180342787-b79f10cb-7e8a-4edd-8145-15177a599be7.png)
![image](https://user-images.githubusercontent.com/69948118/180342936-52d071bd-c9a9-4a24-ba52-55d71035a5ba.png)
![image](https://user-images.githubusercontent.com/69948118/180343029-8007cab1-7b80-44b9-8220-f9075b97c21c.png)
![image](https://user-images.githubusercontent.com/69948118/180343078-3e071429-c821-4312-98ec-6bd8016c9a13.png)
![image](https://user-images.githubusercontent.com/69948118/180343127-39ea6de2-a1fd-444e-b82d-5c6a1b1287bc.png)
![image](https://user-images.githubusercontent.com/69948118/180343228-3747cfe5-1507-4c50-9c0d-0785f58b9b3e.png)
![image](https://user-images.githubusercontent.com/69948118/180343409-1ba03198-72ff-4957-8fc1-bc2e5ca36015.png)
![image](https://user-images.githubusercontent.com/69948118/180343652-75303bc1-c7ff-4b3b-92be-dcd4ba502c0d.png)
![image](https://user-images.githubusercontent.com/69948118/180343669-2648c0f0-6d59-4b25-9a41-bb68d63137fa.png)
![image](https://user-images.githubusercontent.com/69948118/180343800-67419659-a266-4960-8486-2f9ee47a452e.png)
![image](https://user-images.githubusercontent.com/69948118/180343822-be9de674-7bd6-4994-a8a2-156b863c3fde.png)
![image](https://user-images.githubusercontent.com/69948118/180345103-307db45e-0fa6-4a91-b42b-06792d477532.png)




##  First 10 Steps in JPA with H2 in-memory database

- Step 1 : Object Relational Impedence Mismatch - Understanding the problem that JPA solves
- Step 2 : World before JPA - JDBC, Spring JDBC and myBatis
- Step 3 : Introduction to JPA
- Step 4 : Creating a JPA Project using Spring Initializr
- Step 5 : Defining a JPA Entity - User
- Step 6 : Defining a Service to manage the Entity - UserService and EntityManager
- Step 7 : Using a Command Line Runner to save the User to database.
- Step 8 : Magic of Spring Boot and In Memory Database H2
- Step 9 : Introduction to Spring Data JPA
- Step 10 : More JPA Repository : findById and findAll
- Next Steps

Notes
- http://localhost:8080/h2-console
- Use db url jdbc:h2:mem:testdb
## Complete Code Example


### /notes.txt

```
Questions
- Where is the database created?
- What schema is used to create the tables?
- Where are the tables created?
- Can I see the data in the database?
- Where is Hibernate coming in from?
- How is a datasource created?

Magic of Spring Boot and in Memory Database
- Zero project setup or infrastructure
- Zero Configuration
- Zero Maintainance
- Easy to use for Learning and Unit Tests
- Simple Configuration to switch to a real database

# Restrictions of using in-memory database
- Data is not persisted between restarts

Spring Boot chooses a default value for you based on whether it thinks your database is embedded (default create-drop) or not (default none). 

HibernateJpaAutoConfiguration matched:
 - @ConditionalOnClass found required classes 'org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean', 'javax.persistence.EntityManager'; @ConditionalOnMissingClass did not find unwanted class (OnClassCondition)
 - HibernateEntityManager found class 'org.hibernate.ejb.HibernateEntityManager' (HibernateJpaAutoConfiguration.HibernateEntityManagerCondition)

DataSourceAutoConfiguration matched:
 - @ConditionalOnClass found required classes 'javax.sql.DataSource', 'org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType'; @ConditionalOnMissingClass did not find unwanted class (OnClassCondition)

JpaBaseConfiguration#entityManagerFactory matched:
 - @ConditionalOnMissingBean (types: org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean,javax.persistence.EntityManagerFactory; SearchStrategy: all) did not find any beans (OnBeanCondition)

JpaBaseConfiguration#transactionManager matched:
 - @ConditionalOnMissingBean (types: org.springframework.transaction.PlatformTransactionManager; SearchStrategy: all) did not find any beans (OnBeanCondition)
```
---

### /pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>

	<groupId>com.in28minutes.learning.jpa</groupId>
	<artifactId>jpa-in-10-steps</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>jar</packaging>

	<name>jpa-in-10-steps</name>
	<description>Demo project for Spring Boot</description>

	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.0.0.BUILD-SNAPSHOT</version>
		<relativePath /> <!-- lookup parent from repository -->
	</parent>

	<properties>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		<project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
		<java.version>1.8</java.version>
	</properties>

	<dependencies>
		
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<scope>runtime</scope>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>

	<repositories>
		<repository>
			<id>spring-snapshots</id>
			<name>Spring Snapshots</name>
			<url>https://repo.spring.io/snapshot</url>
			<snapshots>
				<enabled>true</enabled>
			</snapshots>
		</repository>
		<repository>
			<id>spring-milestones</id>
			<name>Spring Milestones</name>
			<url>https://repo.spring.io/milestone</url>
			<snapshots>
				<enabled>false</enabled>
			</snapshots>
		</repository>
	</repositories>

	<pluginRepositories>
		<pluginRepository>
			<id>spring-snapshots</id>
			<name>Spring Snapshots</name>
			<url>https://repo.spring.io/snapshot</url>
			<snapshots>
				<enabled>true</enabled>
			</snapshots>
		</pluginRepository>
		<pluginRepository>
			<id>spring-milestones</id>
			<name>Spring Milestones</name>
			<url>https://repo.spring.io/milestone</url>
			<snapshots>
				<enabled>false</enabled>
			</snapshots>
		</pluginRepository>
	</pluginRepositories>


</project>
```
---

### /src/main/java/com/in28minutes/learning/jpa/jpain10steps/entity/User.java

```java
package com.in28minutes.learning.jpa.jpain10steps.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//Table - User
@Entity
public class User {

	@Id
	@GeneratedValue
	private long id;

	private String name;

	private String role;

	protected User() {

	}

	public User(String name, String role) {
		super();
		this.name = name;
		this.role = role;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getRole() {
		return role;
	}

	@Override
	public String toString() {
		return String.format("User [id=%s, name=%s, role=%s]", id, name, role);
	}
}
```
---

### /src/main/java/com/in28minutes/learning/jpa/jpain10steps/JpaIn10StepsApplication.java

```java
package com.in28minutes.learning.jpa.jpain10steps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaIn10StepsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaIn10StepsApplication.class, args);
	}
}
```
---

### /src/main/java/com/in28minutes/learning/jpa/jpain10steps/service/UserDAOService.java

```java
package com.in28minutes.learning.jpa.jpain10steps.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.in28minutes.learning.jpa.jpain10steps.entity.User;

@Repository
@Transactional
public class UserDAOService {
		
	@PersistenceContext
	private EntityManager entityManager;
	
	public long insert(User user){
		entityManager.persist(user);
		return user.getId();
	}
}

/*
 * Spring Data JPA
 * 
 * 
 * 
 */
```
---

### /src/main/java/com/in28minutes/learning/jpa/jpain10steps/service/UserRepository.java

```java
package com.in28minutes.learning.jpa.jpain10steps.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.learning.jpa.jpain10steps.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
```
---

### /src/main/java/com/in28minutes/learning/jpa/jpain10steps/UserDaoServiceCommandLineRunner.java

```java
package com.in28minutes.learning.jpa.jpain10steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minutes.learning.jpa.jpain10steps.entity.User;
import com.in28minutes.learning.jpa.jpain10steps.service.UserDAOService;

@Component
public class UserDaoServiceCommandLineRunner implements CommandLineRunner{

	private static final Logger log = 
			LoggerFactory.getLogger(UserDaoServiceCommandLineRunner.class);
	
	@Autowired
	private UserDAOService userDaoService;
	
	@Override
	public void run(String... arg0) throws Exception {
		User user = new User("Jack", "Admin");
		//New User is created : User [id=1, name=Jack, role=Admin]
		long insert = userDaoService.insert(user);
		log.info("New User is created : " + user);
	}
}
```
---

### /src/main/java/com/in28minutes/learning/jpa/jpain10steps/UserRepositoryCommandLineRunner.java

```java
package com.in28minutes.learning.jpa.jpain10steps;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minutes.learning.jpa.jpain10steps.entity.User;
import com.in28minutes.learning.jpa.jpain10steps.service.UserRepository;

@Component
public class UserRepositoryCommandLineRunner implements CommandLineRunner{

	private static final Logger log = 
			LoggerFactory.getLogger(UserRepositoryCommandLineRunner.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... arg0) throws Exception {
		User user = new User("Jill", "Admin");
		userRepository.save(user);
		log.info("New User is created : " + user);
		
		Optional<User> userWithIdOne = userRepository.findById(1L);
		log.info("User is retrived : " + userWithIdOne);

		List<User> users = userRepository.findAll();
		log.info("All Users : " + users);			
	}
	
}
```
---

### /src/main/resources/application.properties

```properties
spring.jpa.show-sql=true
spring.h2.console.enabled=true
logging.level.org.springframework=debug
```
---

### /src/test/java/com/in28minutes/learning/jpa/jpain10steps/JpaIn10StepsApplicationTests.java

```java
package com.in28minutes.learning.jpa.jpain10steps;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaIn10StepsApplicationTests {

	@Test
	public void contextLoads() {
	}

}
```
---

### /step-completed.sh

```
java -cp /ProgrammingExcellence/Workspaces/Rithus.com/ListDirectoryContentInGitFormat/bin test.ListDirectoryContentInGitFormat $PWD >> $1.md
zip -r $1.zip . -x "target/*" -x ".*/*" -x ".*" -x "*.md" -x "mvn*" -x "*.zip"
git add *; git commit -m "$1"; git push;
```
---

### /take-step-backup.sh

```
java -cp /ProgrammingExcellence/Workspaces/Rithus.com/ListDirectoryContentInGitFormat/bin test.ListDirectoryContentInGitFormat $PWD >> $1.md
zip -r $1.zip . -x "target/*" -x ".*/*" -x ".*" -x "*.md" -x "mvn*" -x "*.zip"
```
---

---
### JPA in Details

SRC : https://www.youtube.com/watch?v=ndHywjc3-kY&list=PL6oD2syjfW7COL__RNrWl4S97vNcqh3mO
github: https://github.com/GiuseppeScaramuzzino/jpatutorial

![image](https://user-images.githubusercontent.com/69948118/180624602-39c327d8-cf88-4743-928f-190c514b0ccb.png)
![image](https://user-images.githubusercontent.com/69948118/180624632-bc0380dd-78ab-49e9-9070-8e2e5741f54f.png)
![image](https://user-images.githubusercontent.com/69948118/180624721-3efc471c-0b91-4e3e-b109-b4d784348769.png)
![image](https://user-images.githubusercontent.com/69948118/180624980-99ab669d-670f-4b05-8999-3d1a89251c64.png)
![image](https://user-images.githubusercontent.com/69948118/180625037-58b6e1c5-7932-483c-b3c3-39fb230ddb75.png)
![image](https://user-images.githubusercontent.com/69948118/180625079-fda29e8b-dfdb-463d-87bb-424e52739df0.png)
![image](https://user-images.githubusercontent.com/69948118/180625164-d6af4c96-ca4d-49b6-8b10-b17298e90d1b.png)
![image](https://user-images.githubusercontent.com/69948118/180625191-13005650-4969-468d-899e-ed7336ae4402.png)
![image](https://user-images.githubusercontent.com/69948118/180625410-927e0fa7-b563-45bd-ac3f-8ac8aa0abb6b.png)
![image](https://user-images.githubusercontent.com/69948118/180625881-0009eb7a-d912-4b2f-bf7f-a48ef6560658.png)
![image](https://user-images.githubusercontent.com/69948118/180626486-c4088731-e78c-41be-b92b-db0982c67a33.png)

### https://github.com/GiuseppeScaramuzzino/jpatutorial/blob/master/pom.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>org.tutorial</groupId>
  <artifactId>jpa</artifactId>
  <version>1.0-SNAPSHOT</version>

  <name>jpa</name>

  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <maven.compiler.source>1.8</maven.compiler.source>
    <maven.compiler.target>1.8</maven.compiler.target>
  </properties>

  <dependencies>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.11</version>
      <scope>test</scope>
    </dependency>
    <dependency>
      <groupId>org.hibernate</groupId>
      <artifactId>hibernate-core</artifactId>
      <version>5.4.18.Final</version>
    </dependency>
    <dependency>
      <groupId>com.h2database</groupId>
      <artifactId>h2</artifactId>
      <version>1.4.200</version>
    </dependency>
    <dependency>
      <groupId>org.postgresql</groupId>
      <artifactId>postgresql</artifactId>
      <version>42.2.14</version>
    </dependency>

  </dependencies>

  <build>
    <pluginManagement><!-- lock down plugins versions to avoid using Maven defaults (may be moved to parent pom) -->
      <plugins>
        <!-- clean lifecycle, see https://maven.apache.org/ref/current/maven-core/lifecycles.html#clean_Lifecycle -->
        <plugin>
          <artifactId>maven-clean-plugin</artifactId>
          <version>3.1.0</version>
        </plugin>
        <!-- default lifecycle, jar packaging: see https://maven.apache.org/ref/current/maven-core/default-bindings.html#Plugin_bindings_for_jar_packaging -->
        <plugin>
          <artifactId>maven-resources-plugin</artifactId>
          <version>3.0.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-compiler-plugin</artifactId>
          <version>3.8.0</version>
        </plugin>
        <plugin>
          <artifactId>maven-surefire-plugin</artifactId>
          <version>2.22.1</version>
        </plugin>
        <plugin>
          <artifactId>maven-jar-plugin</artifactId>
          <version>3.0.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-install-plugin</artifactId>
          <version>2.5.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-deploy-plugin</artifactId>
          <version>2.8.2</version>
        </plugin>
        <!-- site lifecycle, see https://maven.apache.org/ref/current/maven-core/lifecycles.html#site_Lifecycle -->
        <plugin>
          <artifactId>maven-site-plugin</artifactId>
          <version>3.7.1</version>
        </plugin>
        <plugin>
          <artifactId>maven-project-info-reports-plugin</artifactId>
          <version>3.0.0</version>
        </plugin>
      </plugins>
    </pluginManagement>
  </build>
</project>
```
### jpatutorial/src/main/resources/META-INF/persistence.xml
```xml
<persistence xmlns="http://java.sun.com/xml/ns/persistence" version="2.0">
    <persistence-unit name="student_pu" transaction-type="RESOURCE_LOCAL">
        <provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>

        <class>org.tutorial.model.Person</class>
        <class>org.tutorial.model.Student</class>
        <class>org.tutorial.model.School</class>
        <class>org.tutorial.model.Tutor</class>
        <class>org.tutorial.model.Teacher</class>

        <properties>
            <property name="javax.persistence.jdbc.url" value="jdbc:h2:~/test"/>
            <property name="javax.persistence.jdbc.driver" value="org.h2.Driver"/>
            <property name="javax.persistence.jdbc.user" value="sa"/>
            <property name="javax.persistence.jdbc.password" value=""/>

            <property name="hibernate.dialect" value="org.hibernate.dialect.H2Dialect"/>
            <property name="hibernate.show_sql" value="true"/>
            <property name="hibernate.format_sql" value="true"/>
            <property name="hibernate.hbm2ddl.auto" value="drop-and-create"/>
        </properties>
    </persistence-unit>
</persistence>
```
### /src/main/java/org/tutorial/App.java 
```java
package org.tutorial;

import org.tutorial.model.School;
import org.tutorial.model.Student;
import org.tutorial.model.Teacher;
import org.tutorial.model.Tutor;
import org.tutorial.repository.SchoolRepository;
import org.tutorial.repository.StudentRepository;
import org.tutorial.repository.TeacherRepository;
import org.tutorial.repository.TutorRepository;

import java.util.List;


public class App {
  public static void main(String[] args) {

    Student student = new Student("Alan", "Red");

    //REPOSITORIES

    StudentRepository studentRepository = new StudentRepository();

    SchoolRepository schoolRepository = new SchoolRepository();

    TutorRepository tutorRepository = new TutorRepository();

    TeacherRepository teacherRepository = new TeacherRepository();

    //ADD STUDENT

    studentRepository.add(student);

    System.out.println("Added student " + student.toString());

    //ADD TUTOR

    Tutor tutor = new Tutor("FirstName_tutor_1", "LastName_tutor_2");

    tutorRepository.add(tutor);

    System.out.println("Added tutor " + tutor.toString());

    studentRepository.addTutor(student.getId(), tutor);

    System.out.println("Student with tutor " + student.toString());

    System.out.println("Found student with school " + student.toString());

    //ADD SCHOOL

    School school = new School("School_1","City_1");

    schoolRepository.add(school);

    System.out.println("Added school " + school.toString());

    school = schoolRepository.find(school.getId());

    school.getStudents().forEach(System.out::println);

    school = schoolRepository.find(school.getId());

    school.getStudents().forEach(System.out::println);

    //ADD TEACHER

    Teacher teacher = new Teacher("firstname_1","lastname_1");

    teacher.addStudent(new Student("SFirstName_1", "SLastname_1"));
    teacher.addStudent(new Student("SFirstName_2", "SLastname_2"));

    teacherRepository.add(teacher);

    //Persistence Operations and JPQL

    studentRepository.findFirstNames().forEach(System.out::println);

    studentRepository.findLastNames().forEach(System.out::println);

    student = studentRepository.find(student.getId());

    System.out.println("Found student " + student.toString());

    student = studentRepository.findById(student.getId());

    System.out.println("Found student (JPQL) " + student.toString());

    student.setLastName("Green");

    studentRepository.update(student);

    System.out.println("Updated student " + student.toString());

    student = studentRepository.updateFirstNameById("Fred", student.getId());

    System.out.println("Updated first name (JPQL)" + student.toString());

    student = studentRepository.updateLastNameById("Yellow", student.getId());

    System.out.println("Updated last name (JPQL)" + student.toString());

    List<Student> students = studentRepository.findByFirstNameStartWith("Fr");

    students.forEach(System.out::println);

    students = studentRepository.findByLastNameEndWith("ow");

    students.forEach(System.out::println);

    System.out.println("Number of student(s): "+  studentRepository.count());

    students = studentRepository.findSortingByFirstName();

    students.forEach(System.out::println);

    students = studentRepository.findSortingById();

    students.forEach(System.out::println);

    //repository.delete(student);

    //System.out.println("Deleted student " + student.toString());


    //CRITERIA BUILDER

    List<Student> studentList = studentRepository.getStudentWithCriteriaBuilder();

    System.out.println("Print Students (Criteria Builder): ");
    studentList.forEach(System.out::println);

    List<Student> studentListWhere = studentRepository.getStudentsWithWHEREFirstName();

    System.out.println("Print Students (Criteria Builder with WHERE and GROUP BY): ");
    studentListWhere.forEach(System.out::println);

    studentRepository.close();

  }
}
```

### /src/main/java/org/tutorial/model/
```java
package org.tutorial.model;

import javax.persistence.*;

@Entity
@Table
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 150)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 250)
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
```

### /src/main/java/org/tutorial/model/School.java
```java
package org.tutorial.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String city;

    @OneToMany(targetEntity = Student.class)
    private Set<Student> students = new HashSet<>();

    public School(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public School() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
```

### /src/main/java/org/tutorial/model/Student.java
```java
package org.tutorial.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NamedQuery(name = "find student by id" ,query = "Select s from Student s where s.id = :id")
public class Student extends Person{

    @OneToOne
    private Tutor tutor;

    @ManyToMany(mappedBy = "students")
    private Set<Teacher> teachers = new HashSet<>();

    public Student(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Student() {
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void addTeacher(Teacher teacher) {
        boolean added = teachers.add(teacher);
        if (added) {
            teacher.getStudents().add(this);
        }
    }

    public void removeTeacher(Teacher teacher) {
        boolean remove = teachers.remove(teacher);
        if (remove) {
            teacher.getStudents().remove(this);
        }
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }
}
```

### /src/main/java/org/tutorial/model/Teacher.java
```java
package org.tutorial.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Teacher extends Person{

    @ManyToOne
    private School school;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "teachers_students",
            joinColumns =  { @JoinColumn(name = "teacher_id") },
            inverseJoinColumns = { @JoinColumn(name = "student_id") },
            uniqueConstraints = {
                    @UniqueConstraint(
                            columnNames = { "teacher_id", "student_id" }
                    )
            }

    )
    private Set<Student> students = new HashSet<>();

    public Teacher(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Teacher() {
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public void addStudent(Student student) {
        boolean added = students.add(student);
        if(added) {
            student.getTeachers().add(this);
        }
    }

    public void removeStudent(Student student) {
        boolean removed = students.remove(student);
        if(removed) {
            student.getTeachers().remove(this);
        }
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
```

### /src/main/java/org/tutorial/model/Tutor.java
```java
package org.tutorial.model;

import javax.persistence.*;

@Entity
public class Tutor extends Person {
    public Tutor(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Tutor() {
    }
}
```

### /src/main/java/org/tutorial/App.java 
```java

```

### /src/main/java/org/tutorial/repository/SchoolRepository.java
```java
package org.tutorial.repository;

import org.tutorial.model.School;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SchoolRepository {

    private EntityManager entityManager;
    private EntityManagerFactory emf;

    public SchoolRepository() {
        this.emf = Persistence.createEntityManagerFactory("student_pu");
        this.entityManager = this.emf.createEntityManager();
    }

    public SchoolRepository(String pu) {
        this.emf = Persistence.createEntityManagerFactory(pu);
        this.entityManager = this.emf.createEntityManager();
    }

    public School add(School school) {
        entityManager.getTransaction().begin();
        entityManager.persist(school);
        entityManager.getTransaction().commit();
        return school;
    }

    public School find(Long id) {
        return entityManager.find(School.class, id);
    }

    public School update(School school) {
        School schoolToUpdate = find(school.getId());
        entityManager.getTransaction().begin();
        schoolToUpdate.setCity(school.getCity());
        schoolToUpdate.setName(school.getName());
        entityManager.getTransaction().commit();
        return schoolToUpdate;
    }

    public void delete(School school) {
        entityManager.getTransaction().begin();
        entityManager.remove(school);
        entityManager.getTransaction().commit();
    }

    public void close() {
        this.entityManager.close();
        this.emf.close();
    }
}
```

### /src/main/java/org/tutorial/repository/StudentRepository.java 
```java
package org.tutorial.repository;

import org.tutorial.model.School;
import org.tutorial.model.Student;
import org.tutorial.model.Teacher;
import org.tutorial.model.Tutor;

import javax.persistence.*;
import javax.persistence.criteria.*;
import java.util.Arrays;
import java.util.List;

public class StudentRepository {

  private EntityManager entityManager;
  private EntityManagerFactory emf;

  public StudentRepository() {
    this.emf = Persistence.createEntityManagerFactory("student_pu");
    this.entityManager = this.emf.createEntityManager();
  }

  public StudentRepository(String pu) {
    this.emf = Persistence.createEntityManagerFactory(pu);
    this.entityManager = this.emf.createEntityManager();
  }

  public Student add(Student student) {
    entityManager.getTransaction().begin();
    entityManager.persist(student);
    entityManager.getTransaction().commit();
    return student;
  }

  public Tutor addTutor(Long id, Tutor tutor) {
    entityManager.getTransaction().begin();
    Student student = find(id);
    student.setTutor(tutor);
    entityManager.getTransaction().commit();
    return tutor;
  }

  public Student find(Long id) {
    return entityManager.find(Student.class, id);
  }

  public Student findById(Long id) {
    Query query = entityManager.createNamedQuery("find student by id");
    query.setParameter("id", id);
    return (Student) query.getSingleResult();
  }

  public Student updateFirstNameById(String firstName, Long id) {
    entityManager.getTransaction().begin();
    Query query = entityManager.createQuery("Update Student set firstName = '"+ firstName + "' where id = " + id );
    query.executeUpdate();
    entityManager.getTransaction().commit();
    entityManager.clear();
    return findById(id);
  }

  public Student updateLastNameById(String lastName, Long id) {
    entityManager.getTransaction().begin();
    Query query = entityManager.createQuery("Update Student set lastName = '"+ lastName + "' where id = " + id );
    query.executeUpdate();
    entityManager.getTransaction().commit();
    entityManager.clear();
    return findById(id);
  }

  public void deleteById(Long id) {
    entityManager.getTransaction().begin();
    Query query = entityManager.createQuery("Delete from Student where id =" + id);
    query.executeUpdate();
    entityManager.getTransaction().commit();
  }

  public List<Student> findByFirstNameStartWith(String keyword) {
    Query query = entityManager.createQuery("Select s from Student s where s.firstName like '" + keyword + "%'");
    return query.getResultList();
  }

  public List<Student> findByLastNameEndWith(String keyword) {
    Query query = entityManager.createQuery("Select s from Student s where s.lastName like '%" + keyword + "'");
    return query.getResultList();
  }

  public List<Student> findSortingByFirstName() {
    Query query = entityManager.createQuery("Select s from Student s order by s.firstName desc");
    return query.getResultList();
  }

  public List<Student> findSortingById() {
    Query query = entityManager.createQuery("Select s from Student s order by s.id desc");
    return query.getResultList();
  }

  public Long count() {
    Query query = entityManager.createQuery("Select count(s) from Student s");
    return (Long) query.getSingleResult();
  }

  public Student update(Student student) {
    Student studentToUpdate = find(student.getId());
    entityManager.getTransaction().begin();
    studentToUpdate.setFirstName(student.getFirstName());
    studentToUpdate.setLastName(student.getLastName());
    entityManager.getTransaction().commit();
    return studentToUpdate;
  }

  public void delete(Student student) {
    entityManager.getTransaction().begin();
    entityManager.remove(student);
    entityManager.getTransaction().commit();
  }

  public List<String> findFirstNames() {
    Query query = entityManager.createQuery("Select s.firstName from Student s");
    return query.getResultList();
  }

  public List<String> findLastNames() {
    Query query = entityManager.createQuery("Select s.lastName from Student s");
    return query.getResultList();
  }

  public void addTeacher(Long id, Teacher teacher) {
    entityManager.getTransaction().begin();
    Student student = find(id);
    if(student != null) {
     student.getTeachers().add(teacher);
    }
    entityManager.getTransaction().commit();
  }

  public void removeTeacher(Long id, Teacher teacher) {
    Student student = find(id);
    if(student != null) {
      student.getTeachers().remove(teacher);
    }
  }

  public List<Student> getStudentWithCriteriaBuilder() {
    CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);

    Root<Student> studentRoot = criteriaQuery.from(Student.class);

    criteriaQuery.select(studentRoot.get("firstName"));
    criteriaQuery.distinct(true);
    criteriaQuery.orderBy(criteriaBuilder.desc(studentRoot.get("firstName")));

    CriteriaQuery<Student> select = criteriaQuery.select(studentRoot);
    TypedQuery<Student> query = entityManager.createQuery(select);

    return query.getResultList();
  }

  public List<Student> getStudentsWithWHEREFirstName() {

    CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    CriteriaQuery<Student> query = criteriaBuilder.createQuery(Student.class);

    Root<Student> from = query.from(Student.class);

    List firstNameList = Arrays.asList(new String[]{"SFirstName_1","SFirstName_2"});

    Expression<String> exp = from.get("firstName");
    Predicate in = exp.in(firstNameList);
    query.where(in);
    query.groupBy(from.get("lastName"));

    CriteriaQuery<Student> select = query.select(from);
    TypedQuery<Student> query1 = entityManager.createQuery(select);

    return query1.getResultList();
  }


  public void close() {
    this.entityManager.close();
    this.emf.close();
  }
}
```

### /src/main/java/org/tutorial/repository/TeacherRepository.java
```java
package org.tutorial.repository;

import org.tutorial.model.Student;
import org.tutorial.model.Teacher;
import org.tutorial.model.Tutor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TeacherRepository {

    private EntityManager entityManager;
    private EntityManagerFactory emf;

    public TeacherRepository() {
        this.emf = Persistence.createEntityManagerFactory("student_pu");
        this.entityManager = this.emf.createEntityManager();
    }

    public TeacherRepository(String pu) {
        this.emf = Persistence.createEntityManagerFactory(pu);
        this.entityManager = this.emf.createEntityManager();
    }

    public Teacher add(Teacher teacher) {
        entityManager.getTransaction().begin();
        entityManager.persist(teacher);
        entityManager.getTransaction().commit();
        return teacher;
    }

    public Teacher find(Long id) {
        return entityManager.find(Teacher.class, id);
    }

    public Teacher update(Tutor teacher) {
        Teacher teacherToUpdate = find(teacher.getId());
        entityManager.getTransaction().begin();
        teacherToUpdate.setLastName(teacher.getLastName());
        teacherToUpdate.setFirstName(teacher.getFirstName());
        entityManager.getTransaction().commit();
        return teacherToUpdate;
    }

    public void delete(Teacher teacher) {
        entityManager.getTransaction().begin();
        entityManager.remove(teacher);
        entityManager.getTransaction().commit();
    }

    public void close() {
        this.entityManager.close();
        this.emf.close();
    }
}
```
### /src/main/java/org/tutorial/repository/TutorRepository.java 
```java
package org.tutorial.repository;

import org.tutorial.model.Tutor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TutorRepository {

    private EntityManager entityManager;
    private EntityManagerFactory emf;

    public TutorRepository() {
        this.emf = Persistence.createEntityManagerFactory("student_pu");
        this.entityManager = this.emf.createEntityManager();
    }

    public TutorRepository(String pu) {
        this.emf = Persistence.createEntityManagerFactory(pu);
        this.entityManager = this.emf.createEntityManager();
    }

    public Tutor add(Tutor tutor) {
        entityManager.getTransaction().begin();
        entityManager.persist(tutor);
        entityManager.getTransaction().commit();
        return tutor;
    }

    public Tutor find(Long id) {
        return entityManager.find(Tutor.class, id);
    }

    public Tutor update(Tutor tutor) {
        Tutor tutorToUpdate = find(tutor.getId());
        entityManager.getTransaction().begin();
        tutorToUpdate.setLastName(tutor.getLastName());
        tutorToUpdate.setFirstName(tutor.getFirstName());
        entityManager.getTransaction().commit();
        return tutorToUpdate;
    }

    public void delete(Tutor tutor) {
        entityManager.getTransaction().begin();
        entityManager.remove(tutor);
        entityManager.getTransaction().commit();
    }

    public void close() {
        this.entityManager.close();
        this.emf.close();
    }
}
```
