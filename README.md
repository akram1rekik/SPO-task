# ServicePartnerONE


This is an API to optimize workforce management for a cleaning partner.
It uses a simplex optimizer to solve the optimzation problem using Choco Solver


### Usage
From the project root directory

1.  Run the application

        gradle -i bootRun

2.  Run the tests

        gradle -i test


### API Description


   Endpoint: 
        
        http://localhost:8080/optimize

   Supported Methods
    
        POST

   Request Header 
        
        Content-Type: application/json

   An example

        curl -X POST -H "Content-Type: application/json" --data "{\"rooms\":[35,21,17],\"senior\":10,\"junior\":6}" http://localhost:8080/optimize
