# rmm-services-server-app
Challenge of Ninja One

# Summary

This project is a implementation about the Ninja One challenge.

In this project we need create a Spring Boot Project, with microservices architecture 

# Used technology

* Spring FrameWork 
* Spring Boot
* Spring Data JPA
* Spring Web 
* Spring Security
* JSON Web Token Support For The JVM
* Postgresql  
* PostMan
* JAVA

After to read the challenge, I created my ER Diagram as a solution, show below next picture

![Image text](https://github.com/santacruzfreddy/rmm-services-server-app/blob/master/images/diagramRmm.png)

# Setup and run Project
next explanation is how setup and run this project
* git clone this repository
* Open project with Intellig IDEA, eclipse, netbeans or visual studio code.
* For run this project should have install and setup Java 11 in your machine, and in your IDE that prefer.
* For run this project should have install postgres, also create a database with name -> "test" and password -> "password".
* last run application, when this run to create all tables.

# Import WorkSpace POSTMAN
Inside this project in the folder rmm-services-server-app exists and file .zip with name workSpacePostMan.zip, in this workSpace 
has all request that need to test project.

* Import WorkSpace inside PostMan
Decompress workSpacePostMan.zip, before From PostMan UI import to folder as show next images

* Pulse "Import" button

![Image text](https://github.com/santacruzfreddy/rmm-services-server-app/blob/master/images/pulseImport.png)

* Pulse "Folder" Tab

![Image text](https://github.com/santacruzfreddy/rmm-services-server-app/blob/master/images/pulseTabFolder.png)

* Pulse "Choose folder from your computer" button

![Image text](https://github.com/santacruzfreddy/rmm-services-server-app/blob/master/images/pulseChoose.png)

* After you choose decompress folder.

![Image text](https://github.com/santacruzfreddy/rmm-services-server-app/blob/master/images/selectFolder.png)

* Select Collection

![Image text](https://github.com/santacruzfreddy/rmm-services-server-app/blob/master/images/selectCollections.png)

* Show all request import

![Image text](https://github.com/santacruzfreddy/rmm-services-server-app/blob/master/images/importColletion.png)

Once the workspace is loaded, you can setter test data

# Upload data test

Explanation like you can run project to load test data  to run the project.

Once you import postman workspase
* Run project 
* Select in postman environment "local"

![Image text](https://github.com/santacruzfreddy/rmm-services-server-app/blob/master/images/selectEnvironment.png)

* Exists a request in the colletion "Authentification" with name "authentification", this request generate a Java web token which allow conect all request 

![Image text](https://github.com/santacruzfreddy/rmm-services-server-app/blob/master/images/requestAuth.png)

* Configurate variable "Authorization"
 note: copy jwt generate with Authentification request, after edit local environment in the Authorization in Current value field paste jwt.
  example -> Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTY0MTk1MTE3MiwiZXhwIjoxNjQyMDA1MTcyfQ.WK_F128BZMxKAlIepMUsTLRi27ULe4h1TjjX5FKSIHQ
  this value should star with "Bearer ".
  
 ![Image text](https://github.com/santacruzfreddy/rmm-services-server-app/blob/master/images/configurationEnvironment.png)
 
 * You choose from Customer Colletion -> CreateCustomer 
 note: this request create customer also create a new accout link with it.
 
 ![Image text](https://github.com/santacruzfreddy/rmm-services-server-app/blob/master/images/createCustomer.png)
 
 * You choose from Services Colletion -> CreateMultipleServices
 note: this request create services test 
 
 ![Image text](https://github.com/santacruzfreddy/rmm-services-server-app/blob/master/images/pulseImport.png)
 
 
 # Run
 
 * You choose from Account Colletion -> GetAllAccount
 note: this request get all accounts with state = true, you copy accountId 
 
 ![Image text](https://github.com/santacruzfreddy/rmm-services-server-app/blob/master/images/getAllAccount.png)
 
 
 
 


 

  
  
