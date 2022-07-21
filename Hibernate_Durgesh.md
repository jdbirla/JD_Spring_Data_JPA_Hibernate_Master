## Hibernate Tutorial by Durgesh
src: https://www.youtube.com/watch?v=KqzLEKHtLlw&list=PL0zysOflRCekX8OO7V7pGQ9kxZ28JyJlk
![image](https://user-images.githubusercontent.com/69948118/179667439-a3932d8e-60c3-4edc-8f82-1ac5be0ec22a.png)
![image](https://user-images.githubusercontent.com/69948118/179667832-af38c07f-22d8-40b6-a80f-8df5424de65b.png)
![image](https://user-images.githubusercontent.com/69948118/179668234-55303ddb-dcc6-44c9-98e4-b60d4b23b734.png)
![image](https://user-images.githubusercontent.com/69948118/179670356-40bd11e8-d5ef-4006-966f-35c9427b7ae2.png)
![image](https://user-images.githubusercontent.com/69948118/179678122-3dc0d9d1-f2b3-48fb-b26d-74a115c49980.png)
![image](https://user-images.githubusercontent.com/69948118/179679344-c769db57-8b9b-4c6a-88b0-043ff682e44a.png)
![image](https://user-images.githubusercontent.com/69948118/179683225-69326668-c2c8-4437-aecd-2c10e5133fa5.png)
![image](https://user-images.githubusercontent.com/69948118/179701339-8f0c752f-54f8-414d-bad1-9898ac4f507f.png)
![image](https://user-images.githubusercontent.com/69948118/179701561-ad875628-cebe-4a11-a7d7-571d125b0d76.png)
![image](https://user-images.githubusercontent.com/69948118/179701881-9ffafd37-9bfb-49f3-8b7d-add0b0934cd7.png)
![image](https://user-images.githubusercontent.com/69948118/179702015-63bb7b65-52fb-4b61-bd6e-62b7c1ad8fc3.png)
![image](https://user-images.githubusercontent.com/69948118/179702146-2daed882-e33d-4997-ab5f-2a368b23d27e.png)
![image](https://user-images.githubusercontent.com/69948118/179702719-ef05f824-5ad3-4a75-a8fa-a916d55accf2.png)
![image](https://user-images.githubusercontent.com/69948118/179702744-315c7ddf-4162-477e-81c6-ca8b0b0e4fb7.png)
![image](https://user-images.githubusercontent.com/69948118/179704795-be2abe1b-dd21-47d7-96cf-ce542d0242b7.png)
![image](https://user-images.githubusercontent.com/69948118/179709579-133d6a32-411b-4ebd-9ae4-3dcb27478c55.png)
- one to one
![image](https://user-images.githubusercontent.com/69948118/180091577-15114f44-c1dd-467b-99a2-ba532be40ce9.png)
- Uni -directional
![image](https://user-images.githubusercontent.com/69948118/180091601-fab5d769-baad-44a0-b81e-b1fbc75bc29c.png)
![image](https://user-images.githubusercontent.com/69948118/180092426-ff72ddaa-d011-4ce9-b12c-fb60f2d4ba8e.png)
![image](https://user-images.githubusercontent.com/69948118/180092478-de59ad42-e0fb-4c88-b502-6f5948018e13.png)
- bi directinal  (FK column will be created in both the tables)
![image](https://user-images.githubusercontent.com/69948118/180092798-f7ed1b49-33d2-4f60-a8fd-ce3789e9b3e8.png)
![image](https://user-images.githubusercontent.com/69948118/180092712-3bf89d6e-c440-480f-a81e-16cbe8528df6.png)

- If want FK shoul not create in answer table than we have to use mappedBY = "answer" which denotes that only answer field will be responsible for FK creation which is available in question table
![image](https://user-images.githubusercontent.com/69948118/180092921-4655680e-494d-4ec0-9c47-2813e3edbfad.png)

- One to many
- If we are not using mappedby then new table will be created with questionid and answerid
- This is biderctional mapping but as we are using mappedby="question" which is avaible in answer table meaning FK will be created into answer table with questipn id

![image](https://user-images.githubusercontent.com/69948118/180095060-a2cba4e9-d43c-4004-a053-3edc86f700b1.png)
![image](https://user-images.githubusercontent.com/69948118/180095087-0393888c-f40b-4289-a2da-d3ea0c741127.png)
![image](https://user-images.githubusercontent.com/69948118/180095112-9891e4fc-7e4f-4207-958c-d0733f44f20c.png)

- Many to Many
![image](https://user-images.githubusercontent.com/69948118/180097110-d5ba8582-da5e-49ae-a5a8-3074aa9d52b4.png)
![image](https://user-images.githubusercontent.com/69948118/180098433-fc731ab6-6ace-4783-b86a-f4a9c4149297.png)
![image](https://user-images.githubusercontent.com/69948118/180098028-07b3c3f2-e185-4f64-84d1-0ec7dcb005c9.png)
![image](https://user-images.githubusercontent.com/69948118/180098209-725e287e-ecfc-4116-a70a-65942d962578.png)
![image](https://user-images.githubusercontent.com/69948118/180098313-e45dfe67-4c9a-42f5-9568-36c795ed5583.png)

- Fetch Type Lazy Loading
![image](https://user-images.githubusercontent.com/69948118/180098804-a28c60d5-5378-4ad0-b159-9052bbfa00d2.png)
![image](https://user-images.githubusercontent.com/69948118/180099058-ccb78330-e9dc-44cc-8565-8734c3d3742c.png)
![image](https://user-images.githubusercontent.com/69948118/180099526-279a339f-b119-44a9-85b4-ac516b938bd0.png)
![image](https://user-images.githubusercontent.com/69948118/180099633-b7f5a23c-16e8-4ca2-bf80-f83738c6f3e0.png)

- Hibernate states
![image](https://user-images.githubusercontent.com/69948118/180100074-69c23c85-b7f4-45c1-bdfc-e8d444530e64.png)
![image](https://user-images.githubusercontent.com/69948118/180100940-50af8d5b-3f59-46d7-9a67-ab28fbf403ca.png)
![image](https://user-images.githubusercontent.com/69948118/180101629-23a755c9-3a76-4b3e-8139-7a1b8c55c9ba.png)
![image](https://user-images.githubusercontent.com/69948118/180101813-fce1c7ad-f900-4e70-baf5-067fbd3b7352.png)
![image](https://user-images.githubusercontent.com/69948118/180102217-77ebb6f8-553c-41e3-a2e1-cbb99674e245.png)

- HQL
![image](https://user-images.githubusercontent.com/69948118/180115038-c2ea1ca1-33ad-4471-9d86-b26ab2f4631c.png)
![image](https://user-images.githubusercontent.com/69948118/180115094-33979451-c8fa-4f31-b2d2-cade7006fb43.png)
![image](https://user-images.githubusercontent.com/69948118/180115367-a87ac837-3b50-4521-93f3-38f7e1f22b18.png)
![image](https://user-images.githubusercontent.com/69948118/180115723-49e9d5ee-0bbd-4422-8d54-3f9527312c30.png)
![image](https://user-images.githubusercontent.com/69948118/180116751-ecd90fbd-727d-43de-9316-d39ba4660281.png)
![image](https://user-images.githubusercontent.com/69948118/180116661-73a2eb82-74b0-434c-ab0e-6bbf5908aaca.png)


- Pagination
![image](https://user-images.githubusercontent.com/69948118/180129406-1f62bced-827f-4f01-beb2-9d9b4b9e0346.png)

- Native SQL Queries
![image](https://user-images.githubusercontent.com/69948118/180130446-a7e9f09c-28f3-4eb9-ad51-03e984e8166e.png)

- Hibernate Cascading









