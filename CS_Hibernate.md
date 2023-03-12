# Hibernate CS
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

