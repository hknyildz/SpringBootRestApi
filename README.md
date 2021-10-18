# SpringBootRestApi

An application to demonstrate how Spring Boot, Spring Data, and Postgres can be used together to create a simple RESTful API using an embedded tomcat server.

# Dependicies
- SpringBoot
- Maven
- Postgres
# Usage
- mvnv package
- cd target
- java -jar springBootApi-1.0-SNAPSHOT.jar
- Verify the server is running @ http://localhost:8080/bill
 # Features

  - Adding Purchasing Specialist
    - Each purchasing specialist had a limit. (default limit is 200. changeable from application.properties)
    - Each purchasing specialist is identified by First Name, Last Name and E-mail. The Same Name and
    The transactions of people with surname information but with different email addresses are carried out in a separate way
    it is evaluated.
    
  - Deleting Purchasing Specialist
    - Deleting the purchasing specialist by Id.

  - Adding bills
    - the amount in the new bill is sum with the approved bills of the purchasing specialist. If the amount exceeds the limit, the          bill is not approved. if it does not exceed the bill is approved.
    
   - Deleting bill
     - Deleting the bill by Id.

# Folder Structure
```
PROJECT_FOLDER
│  README.md
│  pom.xml           
└──[src]      
│  └──[main]      
│     └──[java]      
│     └──[resources]
|        |  SpringBootRestApi.postman_collection.json   #The postman collection that you can use the send request to server
│        └──application.properties      #contains springboot cofigurations
│        
│
└──[target]              #Java build files, auto-created after running java build: mvn install
│  └──[classes]
 ```
# Response Examples
- Add new purchasing specialist
  ![PostPs](https://user-images.githubusercontent.com/68272945/137669022-c4bbf6a9-5f3b-4e97-afcc-140ae27ea9e2.PNG)
  
- Get al purchasing specialists
  ![getAllPs](https://user-images.githubusercontent.com/68272945/137669378-2a0aaf5e-ee7e-4503-ba4f-d7e9a500c8f5.PNG)

- Delete purchasing specialist by id
  ![DeletePs](https://user-images.githubusercontent.com/68272945/137669082-91a66b97-3dfe-4b7d-bdc4-ec124cb4b33a.PNG)
  
- Add new bill
  ![PostBill](https://user-images.githubusercontent.com/68272945/137669131-19da5b4f-94a8-4ffb-a325-eaeb2bbe514e.PNG)
  
- Get all bills
  ![GetBills](https://user-images.githubusercontent.com/68272945/137669402-b3fce0d9-f943-413e-95c0-a6974c74926e.PNG)
  
- Get accepted bills
  ![getAcceptedBills](https://user-images.githubusercontent.com/68272945/137669483-47a8bbd7-c12f-4341-9479-a44c4cd6f27a.PNG)
  
- Get declined bills
  ![getDeclinedBills](https://user-images.githubusercontent.com/68272945/137669541-a3cd964a-8fc2-4db3-9382-6c197a77009e.PNG)
  
- Get accepted bills by id
  ![getAcceptedBillsById](https://user-images.githubusercontent.com/68272945/137669586-3b1a94c0-0741-4465-99a8-76868fd9c2ba.PNG)

- Get declined bills by id
  ![getDeclinedBillsById](https://user-images.githubusercontent.com/68272945/137669617-db7d2527-c8db-4077-90c6-9eb94511cf87.PNG)
  
- Delete bill by id
  ![deleteBill](https://user-images.githubusercontent.com/68272945/137669649-51316583-58b5-44ef-b131-0464f62cd1a5.PNG)





