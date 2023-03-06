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

