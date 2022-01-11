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

Pulse "Choose folder from your computer" button

![Image text](https://github.com/santacruzfreddy/rmm-services-server-app/blob/master/images/pulseChoose.png)

After you choose decompress folder.

Once the workspace is loaded, you can setter test data

# UpLoad data test

Explanation like you can load data to run the project.


# Exposed Rest API 

In this project a have many Rest API, this can be run with PostMan 

* API REST to create a Service with Http POST
  
  http://localhost:8080/service/create
  
  in body put next Json
  {
    "servicerId":1,
    "serviceName":"Antivirus",
    "state":true,
    "creationUser":"UserDefault",
    "prices":[
        {
            "applyType":true,
            "price":7,
            "type":"Mac"
        },{
            "applyType":true,
            "price":5,
            "type":"WindowsWorkstation"
        },
        {
            "applyType":true,
            "price":5,
            "type":"WindowsServer"
        }
    ]
  }
  
  
