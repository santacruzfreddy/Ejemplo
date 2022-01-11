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

After to read the challenge, I created my ER Diagram as a solution, show below next picture

![Image text](https://github.com/santacruzfreddy/rmm-services-server-app/blob/master/images/diagramRmm.png)

# Setup and run Project
next explanation is how setup and run this project
* git clone this repository
* Open project with Intellig IDEA, eclipse, netbeans or visual studio code.
* For run this project should have install and setup Java 11 in your machine.
* For run this project should have install postgres, also create a database with name -> "test" and password -> "password".
* last run application, when this run to create all tables.




# UpLoad data test

Explanation like you can load data to run the project


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
  
  
