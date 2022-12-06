# JD_Mongo_DB_Spring_DATA
URL: https://dxc.udemy.com/course/mongodb-with-spring-boot-spring-data-mongorepository-mlab-cloudfoundry/learn/lecture/18149648#overview
Instructor: Infybuzz Learning

![image](https://user-images.githubusercontent.com/69948118/205444749-976ba371-dce2-48f5-a357-1758dd1bf820.png)
![image](https://user-images.githubusercontent.com/69948118/205444831-f9b2454c-4614-4829-88ce-39a512db0147.png)
![image](https://user-images.githubusercontent.com/69948118/205527939-76d276bb-3bcb-4f26-928d-562aa525d35e.png)
![image](https://user-images.githubusercontent.com/69948118/205528057-df7d0663-1f34-4540-84f8-20ae1b7be036.png)
![image](https://user-images.githubusercontent.com/69948118/205528089-6b3e7596-15ef-43e4-9567-1bd4d9619536.png)
### Installing mondodb in windows
 - After installation create C:\data\db directories in installed dircetory
 - installing https://studio3t.com/ client for UI
 ![image](https://user-images.githubusercontent.com/69948118/205530559-f076c237-71f2-41ab-916b-f4ebe80b0f35.png)

## Creating Data Base
![image](https://user-images.githubusercontent.com/69948118/205530750-e074f225-6516-4c7c-8b46-4edf4d593011.png)

### Mondo DB read query using studio 3T
```mongodb
{
    $and : [
        {
            "name" : "Peter"
        },
        {
            "mail" : "petere@gamil.com"
        }
    ]
}

```
```mongodb
{ $or : [ { "name" : "Jitu" }, { "mail" : "petere@gamil.com" } ] }
```
```
{ "name" : { $in : [ "Jitu", "steve" ] } }
``
```
db.student.find({ "name": "Steve" }, { "name" : 1, "mail" :2 ,"subjects" : 1}) 
```

### Update query
```
db.student.update(
    {
      "name" : "Jitu"
    },
    {
      $set : {
         "mail" : "Jitu@gmail.com"
      }
    }
)
```

### CRUD Operation using Spring Data MongoDb
- By defautl spring Boot conneting with default daba base in mongo which is Test for overrding that we have create config file 
- articlet https://stackoverflow.com/questions/72537715/spring-boot-and-mongodb-always-connect-to-database-test
- Check our class com.jd.spring.data.mongo.MongoConfig


