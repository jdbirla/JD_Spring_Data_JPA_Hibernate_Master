# Spring Data JPA, Hibernate CS

# Table of contents

- [Spring Data JPA, Hibernate CS](#spring-data-jpa-hibernate-cs)
  - [Relation db,sql,jdbc,hibernate,springdatajpa](#relation-dbsqljdbchibernatespringdatajpa)
  - [When to use spring data JPA and when not](#when-to-use-spring-data-jpa-and-when-not)
  - [RDBMS](#rdbms)
    - [Keys](#keys)
      - [Primary key](#primary-key)
      - [Surrogate key](#surrogate-key)
      - [Natural Key or Commposite key](#natural-key-or-commposite-key)
      - [Foreign Key:](#foreign-key)
    - [Relationship](#relationship)
    - [ACID](#acid)
    - [Locks](#locks)
    - [DB Migration Tools](#db-migration-tools)
      - [Flyway](#flyway)
  - [Hibernate](#hibernate)
    - [What is Session Factory?](#what-is-session-factory)
    - [What is a Session?](#what-is-a-session)
    - [Methods](#methods)
    - [1. **save:**](#1-save)
    - [2. **persist:**](#2-persist)
    - [3. **saveOrUpdate:**](#3-saveorupdate)
    - [4. **delete:**](#4-delete)
    - [5. **get:**](#5-get)
    - [6. **load:**](#6-load)
    - [7. **evict:**](#7-evict)
    - [8. **update:**](#8-update)
    - [9. **merge:**](#9-merge)
    - [10. **detach:**](#10-detach)
    - [11. **clear:**](#11-clear)
    - [12. **close:**](#12-close)
    - [13. **remove:**](#13-remove)
    - [13. **persist, save, and saveOrUpdate**](#13-persist-save-and-saveorupdate)
    - [Keys](#keys)
    - [Primary key](#primary-key)
    - [Annotations](#annotations)
    - [5 important and similar methods of Session Interface](#5-important-and-similar-methods-of-session-interface)
      - [Persist](#persist)
      - [Save](#save)
      - [Merge](#merge)
      - [Update](#update)
      - [SaveOrUpdate](#saveorupdate)
    - [Caching](#caching)
    - [JPA Inheritance](#jpa-inheritance)
  - [Transactions](#transactions)
  - [MySQL Stored Procedures with Spring Boot](#mysql-stored-procedures-with-spring-boot)
  - [```](#)
  - [Configuration](#configuration)
    - [JDBC](#jdbc)
    - [Spring JDBC](#spring-jdbc)
    - [JPA](#jpa)
  - [Hibernate](#hibernate)
    - [Spring data JPA](#spring-data-jpa)
  - [```](#)
    - [JPA VS Hibernate](#jpa-vs-hibernate)
    - [Dirty Checking](#dirty-checking)
  - [Hibernate N+1 Select Problem](#hibernate-n1-select-problem)
  - [Interview Q&A](#interview-qa)
    - [Spring Boot connection with Hibernate using MySQL](#spring-boot-connection-with-hibernate-using-mysql)
## Relation db,sql,jdbc,hibernate,springdatajpa
![image](https://github.com/jdbirla/JD_Spring_Data_JPA_Hibernate_Master/assets/69948118/206d4059-4357-42e3-98e4-1bf74f3d24da)

## When to use spring data JPA and when not
![image](https://github.com/jdbirla/JD_Spring_Data_JPA_Hibernate_Master/assets/69948118/4f3e5f30-52b8-47e7-a956-8ce27ad455de)
![image](https://github.com/jdbirla/JD_Spring_Data_JPA_Hibernate_Master/assets/69948118/4910ca82-edf4-442c-83d9-ef3b6bc31f0a)

## RDBMS
### Keys
#### Primary key
- A Primary key is an optional special database column or columns used o identify a database record
- it should be only one
- It can ONLY accept;
    - nonduplicate values
    - cannot be NULL
-  primary keys are system-generated and have no inherent meaning to users. They exist purely for the purpose of database management.
#### Surrogate key
![image](https://github.com/jdbirla/JD_Spring_Data_JPA_Hibernate_Master/assets/69948118/92689c0b-49fe-4840-8093-264c85d78666)
#### Natural Key or Commposite key
![image](https://github.com/jdbirla/JD_Spring_Data_JPA_Hibernate_Master/assets/69948118/ec9e09c8-7562-47d0-9ae3-d6e4c6d82c2f)

#### Foreign Key: 
- It is a column that comes from a different table and
- using Foreign key tables are related each other
- It is the primary key of another table
- It can be duplicate or null for another table
### Relationship
![image](https://github.com/jdbirla/JD_Spring_Data_JPA_Hibernate_Master/assets/69948118/d92c15ce-8334-4727-aa1b-1805c3fc67be)

### ACID
![image](https://github.com/jdbirla/JD_Spring_Data_JPA_Hibernate_Master/assets/69948118/def68086-4626-406f-8cf3-4159efd75ec3)

### Locks
![image](https://github.com/jdbirla/JD_Spring_Data_JPA_Hibernate_Master/assets/69948118/d1c55c4e-d17a-4e1d-a0d3-fc145641f94e)

### DB Migration Tools
#### Flyway

## Hibernate
![image](https://github.com/jdbirla/JD_Spring_Data_JPA_Hibernate_Master/assets/69948118/da281666-6a0b-4090-9036-ff973e895b7a)
![image](https://github.com/jdbirla/JD_Spring_Data_JPA_Hibernate_Master/assets/69948118/95926753-e23e-4d9e-ae13-c8d3fe847ee8)
![image](https://github.com/jdbirla/JD_Spring_Data_JPA_Hibernate_Master/assets/69948118/cad44eff-1e6a-4c7c-9a84-e7f9fe48e893)
![image](https://user-images.githubusercontent.com/69948118/223032546-533e3aaa-b349-47a7-89f1-e783edebdd19.png)
![image](https://user-images.githubusercontent.com/69948118/223032562-236c9ac0-5559-4c44-93fe-0cb2d7329e41.png)

### What is Session Factory?
The package org.hibernate package provides the SessionFactory interface. It extends the Referenceable and Serializable interface and provides factory methods to get session objects. The Session Factory has the following properties

- We should have one SessionFactory for one datasource / database configuration
- It is thread-safe hence so multiple threads can access the SessionFactory at the same time.
- The Session Factorynis quite heavy since it maintains the database mappings, configuration information, etc.
- The sessions inside Hibernate are created and managed by Session Factory
- Session Factory is a Singleton object which is immutable and created at the server startup
- Session Factory serves as the second-level cache for Hibernate

### What is a Session?
The Session interface provides APIs to create, read, update, and delete persistent objects. The Session object is created on demand when the application needs to interact with the database. The Session Factory provides the Session object and the important functionality of the Session is to create, read and delete operations for instances of mapped entity classes.

The Sessions has one instance per client/thread/one transaction.

- The Session object is not threaded safe like Session Factory
- It is a lightweight object
- It provides a first-level cache for Hibernate objects
- We can have multiple sessions for a SessionFactory.

### Methods

### 1. **save:**
   - **JPA or Hibernate:** Hibernate
   - **Use:** This method is used to save an entity to the database. If the identifier (primary key) is not set in the entity, it will insert a new record; otherwise, it will update the existing record.
   - **Code:**
     ```java
     Session session = sessionFactory.openSession();
     Transaction transaction = session.beginTransaction();
     session.save(entity);
     transaction.commit();
     session.close();
     ```
   - **Alternate:** In JPA, you can use `EntityManager.persist(entity)` which also adds an entity to the persistence context, but it does not guarantee an immediate execution of the SQL insert.
   - **Difference:** save() can return the generated ID, while persist() doesn't.
### 2. **persist:**
   - **JPA or Hibernate:** JPA
   - **Use:** This method is used to make an entity instance managed and persistent.
   - **Code:**
     ```java
     EntityManager entityManager = entityManagerFactory.createEntityManager();
     entityManager.getTransaction().begin();
     entityManager.persist(entity);
     entityManager.getTransaction().commit();
     entityManager.close();
     ```
   - **Alternate:** In Hibernate, you can use `save` for a similar purpose.

### 3. **saveOrUpdate:**
   - **JPA or Hibernate:** Hibernate
   - **Use:** This method is used to either save a new entity or update an existing one, depending on whether an identifier is assigned to the entity.
   - **Code:**
     ```java
     Session session = sessionFactory.openSession();
     Transaction transaction = session.beginTransaction();
     session.saveOrUpdate(entity);
     transaction.commit();
     session.close();
     ```
   - **Alternate:** In JPA, there isn't a direct equivalent. You typically use `persist` for new entities and `merge` for existing ones.

### 4. **delete:**
   - **JPA or Hibernate:** JPA and Hibernate
   - **Use:** This method is used to delete an entity from the database.
   - **Code:**
     ```java
     EntityManager entityManager = entityManagerFactory.createEntityManager();
     entityManager.getTransaction().begin();
     entityManager.remove(entity);
     entityManager.getTransaction().commit();
     entityManager.close();
     ```
   - **Alternate:** In Hibernate, you can use `session.delete(entity)`; in JPA, there isn't a direct equivalent.

### 5. **get:**
   - **JPA or Hibernate:** Hibernate,JPA
   - **Use:** This method is used to retrieve an entity by its identifier.Throws an exception if not found.
   - **Code:**
     ```java
     Session session = sessionFactory.openSession();
     Transaction transaction = session.beginTransaction();
     EntityClass entity = (EntityClass) session.get(EntityClass.class, entityId);
     transaction.commit();
     session.close();
     ```
   - **Alternate:** In JPA, you can use `find` method: `entityManager.find(EntityClass.class, entityId)`.
   - **Difference:** load() throws a LazyInitializationException if the entity is accessed outside of a transaction.

### 6. **load:**
   - **JPA or Hibernate:** Hibernate,JPA
   - **Use:** This method is used to retrieve an entity by its identifier, but it returns a proxy (a placeholder) without hitting the database until a method is called on the proxy.
   - **Code:**
     ```java
     Session session = sessionFactory.openSession();
     Transaction transaction = session.beginTransaction();
     EntityClass entity = (EntityClass) session.load(EntityClass.class, entityId);
     transaction.commit();
     session.close();
     ```
   - **Alternate:** In JPA, you can use `getReference` method: `entityManager.getReference(EntityClass.class, entityId)`.

### 7. **evict:**
   - **JPA or Hibernate:** Hibernate
   - **Use:** This method is used to remove an entity from the Hibernate session cache.
   - **Code:**
     ```java
     Session session = sessionFactory.openSession();
     EntityClass entity = (EntityClass) session.get(EntityClass.class, entityId);
     session.evict(entity);
     session.close();
     ```
   - **Alternate:** In JPA, you can use `EntityManager.clear()` to clear the entire persistence context.
   - **Difference:** detach() also removes relationships.

### 8. **update:**
   - **JPA or Hibernate:** Hibernate
   - **Use:** This method is used to reattach a detached object to the session and synchronize it with the database.
   - **Code:**
     ```java
     Session session = sessionFactory.openSession();
     Transaction transaction = session.beginTransaction();
     session.update(entity);
     transaction.commit();
     session.close();
     ```
   - **Alternate:** In JPA, you can use `merge` method: `entityManager.merge(entity)`.
   - **Difference:** merge() handles detached entities as well.


### 9. **merge:**
   - **JPA or Hibernate:** JPA
   - **Use:** This method is used to merge the state of a detached entity into the current persistence context.
   - **Code:**
     ```java
     EntityManager entityManager = entityManagerFactory.createEntityManager();
     entityManager.getTransaction().begin();
     entityManager.merge(entity);
     entityManager.getTransaction().commit();
     entityManager.close();
     ```
   - **Alternate:** In Hibernate, you can use `update` for a similar purpose.

### 10. **detach:**
   - **JPA or Hibernate:** JPA
   - **Use:** This method is used to detach an entity from the persistence context, making it detached or transient.
   - **Code:**
     ```java
     EntityManager entityManager = entityManagerFactory.createEntityManager();
     entityManager.detach(entity);
     ```

### 11. **clear:**
   - **JPA or Hibernate:** JPA
   - **Use:** This method is used to clear the entire persistence context, detaching all managed entities.
   - **Code:**
     ```java
     EntityManager entityManager = entityManagerFactory.createEntityManager();
     entityManager.clear();
     ```

### 12. **close:**
   - **JPA or Hibernate:** Both JPA and Hibernate
   - **Use:** This method is used to close the session or entity manager.
   - **Code:**
     ```java
     Session session = sessionFactory.openSession();
     session.close();
     // OR
     EntityManager entityManager = entityManagerFactory.createEntityManager();
     entityManager.close();
     ```

### 13. **remove:**
   - **JPA or Hibernate:** JPA
   - **Use:** This method is used to delete an entity from the database.
   - **Code:**
     ```java
     EntityManager entityManager = entityManagerFactory.createEntityManager();
     entityManager.getTransaction().begin();
     entityManager.remove(entity);
     entityManager.getTransaction().commit();
     entityManager.close();
     ```
   - **Alternate:** In Hibernate, you can use `session.delete(entity)`; in JPA, both `remove` and `delete` are used for the same purpose.
     
### 13. **persist, save, and saveOrUpdate**
Certainly, let's summarize the differences between `persist`, `save`, and `saveOrUpdate` in a table format:

| Parameter                 | `persist`                                      | `save`                                      | `saveOrUpdate`                                      |
|---------------------------|------------------------------------------------|---------------------------------------------|-----------------------------------------------------|
| **JPA or Hibernate**      | JPA                                            | Hibernate                                   | Hibernate                                           |
| **Return value**          | void                                           | Serializable                                | void                                                |
| **ID generation**          | Generates ID if none exists                   |  Generates ID if none exists               |  Generates ID if none exists                            |
| **Entity state**          | Entity state	                   | Entity state	               |  Transient to Persistent or Detached to Persistent         |
| **Use**                   | Make an entity instance managed and persistent | Save an entity to the database              | Either save a new entity or update an existing one  |
| **Code Example**          | ```entityManager.persist(entity);```           | ```session.save(entity);```                | ```session.saveOrUpdate(entity);```                 |
| **When to Use**           | For new entities                                | For both new and existing entities         | For both new and existing entities                   |
| **Identifier Behavior**   | Does not guarantee immediate execution         | May insert or update based on identifier   | May insert or update based on identifier             |
| **Primary Key Required**  | No                                             | No                                          | No                                                  |

**When to Use:**
- Use `persist` for new entities in a JPA context. It is primarily designed for managing the lifecycle of new entities.
- Use `save` in Hibernate for saving both new and existing entities. It is a more flexible method that can handle various scenarios.
- Use `saveOrUpdate` in Hibernate when you want to save a new entity or update an existing one without checking explicitly whether the entity already exists.
- persist(): Use when you're certain you're saving a new entity and don't need the generated ID immediately.
- save(): Use when you need the generated ID immediately after saving a new entity.
- saveOrUpdate(): Use when you're unsure whether an entity is new or existing, and you want to handle both cases in a single method call.

### Keys
### Primary key
![image](https://github.com/jdbirla/JD_Spring_Data_JPA_Hibernate_Master/assets/69948118/4704b177-e186-4a8b-ac3c-542854f39f30)

### Annotations
- https://github.com/jdbirla/JD_Spring_Data_JPA_Hibernate_Master/blob/master/Hibernare_annotation.pdf
### 5 important and similar methods of Session Interface
#### Persist
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

#### Save
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
#### Merge
- The Merge method is used to update the Persistent object with new values from a Detached object.
```java
User user = new User(); 
user.setName("ABC");  
session.save(user);  
session.evict(user); 
user.setName("XXX");  
User mergedUser = (User) session.merge(user);
```
#### Update
- The Update method is used to transition a detached object back to the persistent state. We cannot use a transient entity in the update method as it throws exceptions because the object doesn't exist in the database.
```java
User test = new User(); 
test.setName("ABC"); 
session.save(test);
session.evict(test);
test.setName("XXX")
session.update(test)
```

#### SaveOrUpdate
- The SaveorUpdate method is similar to the Update method in reattaching the instances. The major difference is this method does not throw exceptions upon saving a transient instance instead it transitions the transient object to the persistent state

```java
User user = new User(); 
user.setName("ABC"); 
session.saveOrUpdate(user);
```

### Caching
![image](https://github.com/jdbirla/JD_Spring_Data_JPA_Hibernate_Master/assets/69948118/507617e8-1c0b-4746-8b7d-5cb5aa3d09fa)

### JPA Inheritance
![image](https://github.com/jdbirla/JD_Spring_Data_JPA_Hibernate_Master/assets/69948118/111c1bf6-a348-4d5b-af3b-aad2f6604e89)


## Transactions
![image](https://github.com/jdbirla/JD_Spring_Data_JPA_Hibernate_Master/assets/69948118/1d08325b-16e1-466f-9f8a-ebfb2ddb91c0)
![image](https://github.com/jdbirla/JD_Spring_Data_JPA_Hibernate_Master/assets/69948118/f9c81bbb-0d13-4669-a5fe-1f8d37dc3197)

---

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
---

## Configuration
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
---
###  JPA VS Hibernate
![image](https://user-images.githubusercontent.com/69948118/173209797-a8a5237d-4885-4aa8-b9a6-7651a9309449.png)
![image](https://user-images.githubusercontent.com/69948118/173209984-26b1dd2a-3929-4989-baf9-725c3b5eb5c9.png)
![image](https://user-images.githubusercontent.com/69948118/175798578-53560c85-0adc-4777-820e-5f654f25114a.png)
![image](https://user-images.githubusercontent.com/69948118/175798641-1ef19dee-9e6b-48a5-b378-fc2e42b5e218.png)
![image](https://user-images.githubusercontent.com/69948118/175798758-6b117595-b66d-4edd-a959-6d9944ab6078.png)
![image](https://user-images.githubusercontent.com/69948118/175798832-18ed5761-31e8-49e3-ac3e-0c719045b4d6.png)
![image](https://user-images.githubusercontent.com/69948118/175798846-67b5b6db-2d59-4b78-92c0-284555bfe4b0.png)

----
### Dirty Checking
In Hibernate, "dirty checking" refers to the mechanism by which changes made to an object's state are automatically tracked and persisted to the database when a transaction is committed. Dirty checking helps avoid the need for explicit update statements in your code; instead, Hibernate automatically determines which properties of an object have been modified and updates only those changes.

Here's how dirty checking works in Hibernate:

1. **Entity State Tracking:**
   - When an entity is retrieved from the database, Hibernate keeps track of its state.
   - The entity is in the "persistent" state, and any changes made to its properties are tracked by Hibernate.

2. **Dirty Checking during Transaction Commit:**
   - When a transaction is committed, Hibernate checks the state of all entities that were part of the transaction.
   - It identifies which properties of these entities have been modified (are "dirty") since they were loaded or since the last transaction commit.

3. **Automatic Update Statements:**
   - Only the modified properties are included in the SQL UPDATE statements generated by Hibernate during the transaction commit.
   - This helps in optimizing database interactions, as only the necessary changes are sent to the database.

Let's look at a simple example to illustrate dirty checking:

```java
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "salary")
    private double salary;

    // getters and setters
}
```

In this example, we have an `Employee` entity with `id`, `name`, and `salary` properties.

```java
// Code within a transaction
Session session = sessionFactory.openSession();
Transaction transaction = session.beginTransaction();

// Load an employee from the database
Employee employee = session.get(Employee.class, 1L);

// Make changes to the loaded employee
employee.setSalary(50000.0);

// The following update statement is automatically generated during the transaction commit
// UPDATE employees SET salary = 50000.0 WHERE id = 1
transaction.commit();
session.close();
```

In this code snippet:

- We load an `Employee` entity from the database.
- We modify the `salary` property of the employee.
- When the transaction is committed, Hibernate automatically detects that the `salary` property has been modified (it's "dirty") and generates an SQL UPDATE statement to persist only that change to the database.

This is the essence of dirty checking in Hibernate – it simplifies the process of persisting changes to the database by automatically identifying and updating only the modified properties of entities during a transaction commit.

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







