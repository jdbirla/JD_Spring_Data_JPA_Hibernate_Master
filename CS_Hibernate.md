# Spring Data JPA, Hibernate CS

## Relation db,sql,jdbc,hibernate,springdatajpa
![image](https://github.com/jdbirla/JD_Spring_Data_JPA_Hibernate_Master/assets/69948118/206d4059-4357-42e3-98e4-1bf74f3d24da)

---
![image](https://user-images.githubusercontent.com/69948118/223032546-533e3aaa-b349-47a7-89f1-e783edebdd19.png)
![image](https://user-images.githubusercontent.com/69948118/223032562-236c9ac0-5559-4c44-93fe-0cb2d7329e41.png)

## What is Session Factory?
The package org.hibernate package provides the SessionFactory interface. It extends the Referenceable and Serializable interface and provides factory methods to get session objects. The Session Factory has the following properties

- We should have one SessionFactory for one datasource / database configuration
- It is thread-safe hence so multiple threads can access the SessionFactory at the same time.
- The Session Factorynis quite heavy since it maintains the database mappings, configuration information, etc.
- The sessions inside Hibernate are created and managed by Session Factory
- Session Factory is a Singleton object which is immutable and created at the server startup
- Session Factory serves as the second-level cache for Hibernate

## What is a Session?
The Session interface provides APIs to create, read, update, and delete persistent objects. The Session object is created on demand when the application needs to interact with the database. The Session Factory provides the Session object and the important functionality of the Session is to create, read and delete operations for instances of mapped entity classes.

The Sessions has one instance per client/thread/one transaction.

- The Session object is not threaded safe like Session Factory
- It is a lightweight object
- It provides a first-level cache for Hibernate objects
- We can have multiple sessions for a SessionFactory.

### Transient
- A newly created object that has not been attached to any Session is called a Transient Object
### Persistent
- An Object that is associated with a session is called a Persistent Object. It represents a row in a database table.
### Detached
- After a session is closed, the object becomes a detached one. It still represents a row in the database but it is outside the scope of the session now

### 5 important and similar methods of Session Interface
### Persist
- As seen above, the persist method is used to add a new entity instance to the persistence context, i.e. transitioning an instance from a transient to a persistent state.
```java

User test = new User(); 
test.setName("ABC"); 
session.persist(test);

```

```java
session.evict(person);
session.persist(test);
```
- If we detach this object from the session and attach it again, then it will throw a Persistence Exception.

### Save
- The save method always persists the instance to the database by generating a unique identifier
```java
User test = new User(); 
test.setName("ABC"); 
Long id = (Long) session.save(test);
```
- When we detach an object from the session and re-attach it, then a new persistent instance is created with a new identifier
```java
User test = new User(); 
test.setName("ABC"); 
Long id = (Long) session.save(test);
session.evict(test);
Long id2 = (Long) session.save(test);
```
### Merge
- The Merge method is used to update the Persistent object with new values from a Detached object.
```java
User user = new User(); 
user.setName("ABC");  
session.save(user);  
session.evict(user); 
user.setName("XXX");  
User mergedUser = (User) session.merge(user);
```
### Update
- The Update method is used to transition a detached object back to the persistent state. We cannot use a transient entity in the update method as it throws exceptions because the object doesn't exist in the database.
```java
User test = new User(); 
test.setName("ABC"); 
session.save(test);
session.evict(test);
test.setName("XXX")
session.update(test)
```

### SaveOrUpdate
- The SaveorUpdate method is similar to the Update method in reattaching the instances. The major difference is this method does not throw exceptions upon saving a transient instance instead it transitions the transient object to the persistent state

```java
User user = new User(); 
user.setName("ABC"); 
session.saveOrUpdate(user);
```

---
## JDBC/Spring JDBC/JPA/Hibernate

### JDBC
```java
Connection connection = datasource.getConnection();
PreparedStatement st = connection.prepareStatement(
"Update todo set user=?, desc=?, target_date=?, is_done=? where id=?"
st.setString(1, todo.getUser());
st.setString(2, todo.getDesc());
st.setTimestamp(3, new Timestamp(todo.getTargetDate().getTime()));
st.setBoolean(4, todo.isDone());
st.setInt(5, todo.getId());
st.execute();
st.close();
connection.close();
```
```java
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/sonoo","root","root");  //here sonoo is database name, root is username and password  
Statement stmt=con.createStatement();  
ResultSet rs=stmt.executeQuery("select * from emp");  
while(rs.next())  
System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
con.close();  
```
### Spring JDBC
```java
jdbcTemplate
.update
("Update todo set user=?, desc=?, target_date=?, is_done=? where id=?"
todo.getUser(), todo.getDesc(),
new Timestamp(todo.getTargetDate().getTime()),
todo.isDone(), todo.getId());
jdbcTemplate.update("delete from todo where id=?",
id);
--------------------
new BeanPropertyRowMapper(Todo.class)
class TodoMapper implements RowMapper<Todo> {
@Override
public Todo mapRow(ResultSet rs, int rowNum)
throws SQLException {
Todo todo = new Todo();
todo.setId(rs.getInt("id"));
todo.setUser(rs.getString("user"));
todo.setDesc(rs.getString("desc"));
todo.setTargetDate(
rs.getTimestamp("target_date"));
todo.setDone(rs.getBoolean("is_done"));
return todo;
}
}
```
```java
int result = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM EMPLOYEE", Integer.class);

```

### JPA
```java
EntityManagerFactory factory = Persistence.createEntityManagerFactory("UsersDB");     
EntityManager entityManager = factory.createEntityManager();           
entityManager.getTransaction().begin();                  
User newUser = new User();    
newUser.setEmail("billjoy@gmail.com");    
newUser.setFullname("bill Joy");      
newUser.setPassword("billi");            
entityManager.persist(newUser);             
entityManager.getTransaction().commit();             
entityManager.close();       
factory.close();

```
```java
@Entity
@Table(name = "Todo")
public class Todo {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String user;
private String desc;
private Date targetDate;
private boolean isDone;
-----------------------
public class TodoJPAService implements TodoDataService {
@PersistenceContext
private EntityManager entityManager;
@Override
public void updateTodo(Todo todo) {
entityManager.merge(todo);
}
```

## Hibernate
```java
StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();    
Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
SessionFactory factory = meta.getSessionFactoryBuilder().build(); 
Session session = factory.openSession();  
Transaction t = session.beginTransaction();            
Employee e1=new Employee();    
e1.setId(101);       
e1.setFirstName("Gaurav");       
e1.setLastName("Chawla");             
session.save(e1);     
t.commit();     
System.out.println("successfully saved");   
factory.close();    
session.close();   

```


### Spring data JPA
```java
public interface CustomerRepository extends CrudRepository<Customer, Long> {
	List<Customer> findByLastName(String lastName);
}

private CustomerRepository repository;

public void test() { // Save a new customer
	 Customer newCustomer = new Customer(); 
	newCustomer.setFirstName("John"); 
	newCustomer.setLastName("Smith"); 
	repository.save(newCustomer); 
	// Find a customer by ID 
	Optional<Customer> result = repository.findById(1L);
	result.ifPresent(customer -> System.out.println(customer)); 
	// Find customers by last name 
	List<Customer> customers = repository.findByLastName("Smith"); 
	customers.forEach(customer -> System.out.println(customer)); 
	// List all customers 
	Iterable<Customer> iterator = repository.findAll(); 
	iterator.forEach(customer -> System.out.println(customer)); 
	// Count number of customer 
	long count = repository.count();
	System.out.println("Number of customers: " + count);
}
```
## Mappings 
### One-to_one
```java
@Entity
public class Passport {
....
// Inverse Relationship
// bi-directional OneToOne relationship
// Column will not be created in the table
// Try removing mappedBy = "passport" => You will see that student_// will be created in passport
@OneToOne(fetch = FetchType.LAZY, mappedBy = "passport")
private Student student;
@Entity
@Table(name = "Student")
public class Student {
@OneToOne
private Passport passport;

```

### One to Many Relationship
```java
@Entity
public class Project {
@OneToMany(mappedBy = "project")
private List<Task> tasks;
@Entity
public class Task {
@ManyToOne
@JoinColumn(name="PROJECT_ID")
private Project project;
```
### Many to Many Relationship
```java
@Entity
public class Project {
@ManyToMany
// @JoinTable(name="STUDENT_PROJ",
// joinColumns=@JoinColumn(name="STUDENT_ID"),
// inverseJoinColumns=@JoinColumn(name="PROJECT_ID"))
private List<Student> students;
public class Student {
@ManyToMany(mappedBy = "students")
private List<Project> projects;
```
### Defining a Data Source
```java
#HQL in-memory db
db.driver=org.hsqldb.jdbcDriver
db.url=jdbc:hsqldb:mem:firstdb
db.username=sa
db.password=
---
<bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource"
destroy-method="close">
<property name="driverClass" value="${db.driver}" />
<property name="jdbcUrl" value="${db.url}" />
<property name="user" value="${db.username}" />
<property name="password" value="${db.password}" />
</bean>
```

### Configuring Hibernate
src\main\resources\config\hibernate.properties
```java
hibernate.dialect=org.hibernate.dialect.HSQLDialect
hibernate.show_sql=false
hibernate.format_sql=false
hibernate.use_sql_comments=true
```

### persistence.xml
```java
src\main\resources\META-INF\persistence.xml
<?xml version="1.0" encoding="UTF-8"?>
<persistence xmlns="http://java.sun.com/xml/ns/persistence"
version="2.0">
<persistence-unit name="hsql_pu" transaction-type="RESOURCE_LOCAL"
<provider>org.hibernate.jpa.HibernatePersistenceProvider</provider
<properties>
<property name="hibernate.dialect" value="org.hibernate.dialect.<property name="hibernate.connection.url" value="jdbc:hsqldb:<property name="hibernate.connection.driver_class" value="org.<property name="hibernate.connection.username" value="sa" />
<property name="hibernate.connection.password" value="" />
</properties>
</persistence-unit>
</persistence>
```

### Configure Entity Manager Factory and Transaction Manager
```java
<bean
class="org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean"
id="entityManagerFactory">
<property name="persistenceUnitName" value="hsql_pu" />
<property name="dataSource" ref="dataSource" />
</bean>
<bean id="transactionManager" class="org.springframework.orm.jpa.<property name="entityManagerFactory" ref="entityManagerFactory"
<property name="dataSource" ref="dataSource" />
</bean>
<tx:annotation-driven transaction-manager="transactionManager"
```

---
###  JPA VS Hibernate
![image](https://user-images.githubusercontent.com/69948118/173209797-a8a5237d-4885-4aa8-b9a6-7651a9309449.png)
![image](https://user-images.githubusercontent.com/69948118/173209984-26b1dd2a-3929-4989-baf9-725c3b5eb5c9.png)
![image](https://user-images.githubusercontent.com/69948118/175798578-53560c85-0adc-4777-820e-5f654f25114a.png)
![image](https://user-images.githubusercontent.com/69948118/175798641-1ef19dee-9e6b-48a5-b378-fc2e42b5e218.png)
![image](https://user-images.githubusercontent.com/69948118/175798758-6b117595-b66d-4edd-a959-6d9944ab6078.png)
![image](https://user-images.githubusercontent.com/69948118/175798832-18ed5761-31e8-49e3-ac3e-0c719045b4d6.png)
![image](https://user-images.githubusercontent.com/69948118/175798846-67b5b6db-2d59-4b78-92c0-284555bfe4b0.png)
![image](https://user-images.githubusercontent.com/69948118/218351568-b014dd37-e601-4f34-9285-8f662363cc8f.png)

---
## Hibernate N+1 Select Problem
- https://medium.com/geekculture/resolve-hibernate-n-1-problem-f0e049e689ab
![image](https://user-images.githubusercontent.com/69948118/224542712-52446229-45fe-434e-a99c-c77f6c2861b6.png)
![image](https://user-images.githubusercontent.com/69948118/224543098-5d025139-a5f6-4155-a196-1f3a4548bcc6.png)
![image](https://user-images.githubusercontent.com/69948118/224543121-5ebc6b46-92a6-4ea9-83a8-2b30dd8a3842.png)
![image](https://user-images.githubusercontent.com/69948118/224543285-cf477ea4-8b52-4772-962e-08bdf61b25e0.png)
![image](https://user-images.githubusercontent.com/69948118/224543135-0b7e5b7c-3728-466e-8812-7209676433e0.png)
![image](https://user-images.githubusercontent.com/69948118/224543295-e0ad1b17-ffe0-414b-8c3c-c9de7c152e1c.png)
![image](https://user-images.githubusercontent.com/69948118/224543415-b38652a1-05c9-4bff-8e00-087e5a80222f.png)

---
## Interview Q&A

![image](https://user-images.githubusercontent.com/69948118/224586407-00ecc345-3ba1-4280-8b00-db32a581b422.png)
![image](https://user-images.githubusercontent.com/69948118/224586436-537b617d-a7de-4f5a-8620-f2e700febea3.png)
![image](https://user-images.githubusercontent.com/69948118/224586573-84accf6d-4c15-436b-aaca-b4e39f593669.png)
![image](https://user-images.githubusercontent.com/69948118/224586720-bc01eb2b-d495-45a7-bf26-3cf25d56cd9c.png)
![image](https://user-images.githubusercontent.com/69948118/224586754-108d02ed-8530-464d-848a-04f6ec9fb0f9.png)
![image](https://user-images.githubusercontent.com/69948118/224586832-1351895c-cfe8-4f71-9d8c-cca9d4108f41.png)
![image](https://user-images.githubusercontent.com/69948118/224586990-78c6c4e2-2460-4a4b-8524-5d256d0bff64.png)
![image](https://user-images.githubusercontent.com/69948118/224587101-59507ce8-dc77-4a8f-bc32-8a7a4d755907.png)
![image](https://user-images.githubusercontent.com/69948118/224587299-d095db0f-9701-40d0-b44b-7fd06c0abe55.png)
![image](https://user-images.githubusercontent.com/69948118/224587472-f7b843f4-28a9-4740-b3fe-bd944310db3e.png)
![image](https://user-images.githubusercontent.com/69948118/224587606-10ba80d4-5c8a-441e-b7f1-6037822d8390.png)
![image](https://user-images.githubusercontent.com/69948118/224587862-844589d2-d90e-42b0-ad1a-4c0eda439f89.png)
![image](https://user-images.githubusercontent.com/69948118/224588000-6e17f1f1-5fbe-44a4-8f04-d736c8dff42f.png)
![image](https://user-images.githubusercontent.com/69948118/224588092-4d9c9032-cd51-46f9-a11d-a3ceffad5be7.png)
![image](https://user-images.githubusercontent.com/69948118/224588228-07ceeadf-4792-4d74-8d78-9939dbf0cbe4.png)
![image](https://user-images.githubusercontent.com/69948118/224588276-c3574d9d-e760-4322-8164-dabaabbb20da.png)
![image](https://user-images.githubusercontent.com/69948118/224588473-4da2d307-9c72-483d-a856-7f7a2c189203.png)
![image](https://user-images.githubusercontent.com/69948118/224588524-7392f328-2741-40a4-a023-879e4eb9cc5a.png)
![image](https://user-images.githubusercontent.com/69948118/224588581-81189c36-e07e-4024-9baa-3926575f588b.png)
![image](https://user-images.githubusercontent.com/69948118/224588729-4ec4dd0b-5c7a-479d-a16e-27db168773a4.png)
![image](https://user-images.githubusercontent.com/69948118/224588921-d7644bc8-f8e0-4c24-9ff0-d9527fe9e052.png)
- 6. Cache Concurrency Strategy
- Based on use cases, we're free to pick one of the following cache concurrency strategies:

- READ_ONLY: Used only for entities that never change (exception is thrown if an attempt to update such an entity is made). It's very simple and performative. It's suitable for static reference data that doesn't change.
- NONSTRICT_READ_WRITE: Cache is updated after the transaction that changed the affected data has been committed. Thus, strong consistency isn't guaranteed, and there's a small time window in which stale data may be obtained from the cache. This kind of strategy is suitable for use cases that can tolerate eventual consistency.
- READ_WRITE: This strategy guarantees strong consistency, which it achieves by using ‘soft' locks. When a cached entity is updated, a soft lock is stored in the cache for that entity as well, which is released after the transaction is committed. All concurrent transactions that access soft-locked entries will fetch the corresponding data directly from the database.
- TRANSACTIONAL: Cache changes are done in distributed XA transactions. A change in a cached entity is either committed or rolled back in both the database and cache in the same XA transaction.


### Spring Boot connection with Hibernate using MySQL
![image](https://user-images.githubusercontent.com/69948118/179099944-0946e393-6a65-4575-9e25-8f667dad010a.png)
![image](https://user-images.githubusercontent.com/69948118/179100004-a6b19814-e824-4596-99e5-93850f47dc71.png)
![image](https://user-images.githubusercontent.com/69948118/179115952-29008fb7-1677-49ca-8864-af94a2f5f375.png)
![image](https://user-images.githubusercontent.com/69948118/179116154-03c7ae17-9106-4185-9bc9-39b33a551d6c.png)

## MySQL Stored Procedures with Spring Boot
- Approach 1 – @NamedStoredProcedureQuery Annotation
- Approach-2 @Procedure Annotation
```plsql
CREATE PROCEDURE 'GET_TOTAL_BLOGS_BY_TITLE' (IN title_in VARCHAR(50), OUT count_out INT)
BEGIN
 SELECT COUNT(*) into count_out from blog WHERE title = title_in;
END
```
```java
@Repository
public interface BlogRepository extends JpaRepository<Blog,Integer> {

    @Procedure
    int GET_TOTAL_BLOGS_BY_TITLE(String title);

    @Procedure("GET_TOTAL_BLOGS_BY_TITLE")
    int getTotalBlogsByTitle(String title);

    @Procedure(procedureName = "GET_TOTAL_BLOGS_BY_TITLE")
    int getTotalBlogsByTitleProcedureName(String model);

    @Procedure(value = "GET_TOTAL_BLOGS_BY_TITLE")
    int getTotalBlogsByTitleValue(String model);

    @Procedure(name = "Blog.getTotalBlogsByTitleEntiy")
    int getTotalBlogsByTitleEntiy(@Param("model_in") String model);



}
```

## Hibernate Annotatoin
- https://github.com/jdbirla/JD_Spring_Data_JPA_Hibernate_Master/blob/master/Hibernare_annotation.pdf




