# FlexionCodeReview

The Application is written in Client - Server Architecture model

Frontend of the application is written in AngularJS, Backend of the Application is written in Spring Boot

Front End Pre-Installation Requirment --- 
Angular CLI: 12.0.0-next.4,
Node: 12.16.3,
NPM : 6.14.5,

Backend Pre-Installation  Requirement ---
openjdk version "1.8.0_282",
Apache Maven 3.6.3 

To test the front end requirement please open command prompt or terminal and run these commands
Angular CLI : "ng v", Node :"node -v", NPM: "npm -v"

To test the Backend end requirement please open command prompt or terminal and run these commands
openjdk : "java -version", Apache Maven : "mvn -v",


Backend java codes are present in FlexionCodeReview\src\main\java folder
Frontend angular codes are present in FlexionCodeReview\src\main\ui folder

To run application in local environment 

Backend Application. 

1) Change the packing to jar in pom.xml file under properties element. 
2) Open command prompt or terminal, go to ${YourCopiedDirectory}\FlexionCodeReview folder, run "mvn clean install"
3) All the junit test cases should pass, and Unit-Conversion-2.0.jar file should be created under ${YourCopiedDirectory}\FlexionCodeReview\target\ folder. 
4) on the command prompt or terminal, go to ${YourCopiedDirectory}\FlexionCodeReview\target\  folder and run "java -jar Unit-Conversion-2.0.jar"
5) Open any browser and go to "http://localhost:8082/", You should see a HTML page which "This is index.html". This confirms backend application is running properly. 

Front End Application. 
1) Open command prompt or terminal, go to ${YourCopiedDirectory}\FlexionCodeReview\src\main\ui
2) Run the command "npm start"
3) Open any browser and go to "http://localhost:4200/", You should see the Unit Converison Application UI. 


To run application in PROD environment 

Backend Application. 
1) Change the packing to war in pom.xml file under properties element. 
2) Open command prompt or terminal, go to ${YourCopiedDirectory}\FlexionCodeReview folder, run command "mvn clean install"
3) All the junit test cases should pass, and Unit-Conversion-2.0.war file should be created under ${YourCopiedDirectory}\FlexionCodeReview\target folder.
4) Copy the war file and Deploy the it on a web server of your choice. Tomcat is used here but feel free to use any other webserver. 
5) Under Tomcat installtion directory, copy the  war file under webapps folder, stop and start Tomcat the server. Stop and Start script are the under bin folder in tomcat directory. 
6) Open any browser and go to "http://YourWebServerDNS:8080/UnitConversion-2.0/", You should see a HTML page which "This is index.html". This confirms backend application is running properly. ( Please note that "YourWebServerDNS" in the URL is the hostname of prod server, please change it accordingly) 

Front End Application. 
1) Open command prompt or terminal or explorer, Go to ${YourCopiedDirectory}\FlexionCodeReview\src\main\ui\src\environments folder, Under the folder, please open the file "environment.prod.ts" using notepad or vi editor or any editor of your choice. 
2) Change the apiUrl to above URL where the WAR file was deployed like  "apiUrl": "http://YourWebServerDNS:8080/UnitConversion-2.0".
(Please note that "YourWebServerDNS" in the URL is the hostname of prod server, please change it accordingly) 
3) Open command prompt or terminal, go to ${YourCopiedDirectory}\FlexionCodeReview\src\main\ui
4) Run the command "npm run-script build". A \dist folder will be created under ${YourCopiedDirectory}\FlexionCodeReview\src\main\ui directory. 
5) Copy the ui folder under \dist\ folder, and deploy it on Webserver of your choice. Tomcat is used here but feel free to use any other webserver. 
5) Open any browser and go to "http://YourWebServerDNS:8080/ui/", You should see the Unit Converison Application UI. ( Please note that "YourWebServerDNS" in the URL is the hostname of prod server, please change it accordingly)



Some of Common issue you may experience during PROD installation. 

1) My UI application deployed on Prod tomcat server is not working. 

a) Please make sure the apiUrl in  "environment.prod.ts" is updated properly. Check your webserver port number. 
b) Please make sure that there is no '/' at the end the apiUrl in  "environment.prod.ts"
c) If you are running Tomcat, please make sure the value 'Valve className="org.apache.catalina.valves.rewrite.RewriteValve' is present in host element of server.xml under ${TomcatDirectory}\conf\ folder
d) Also If you are running Tomcat, please make sure you have the rewrite.config file under ${TomcatDirectory}\conf\Catalina\localhost. Please add the rule as shown below. 
   
	RewriteCond %{REQUEST_PATH} !-f   
		 	
	RewriteRule ^/ui/(.*) /ui/index.html 

Please refer below link for Deep linking issues with Angular Application. 

http://codedumpster.nithinbiliya.com/deep-linking-issue-angular-application-tomcat-server/


Next Developement task
1) Converting the Application to Microservices Architecture.
2) Better CI/CD pipeline 
3) Integrating with Docker and Kubernates. 
4) Removing the in-memory database and adding RDBMS or NoSql database. 
5) Changing the UI.
6) Integration with Security Tools like Sonar or HP fortify, 
7) Better documentation, more logs, 

AWS Code - pipeline used for CI/CD process. Various stages has been created already. 
1) Source Stage - As soon as you push the code to GITHUB, Code-pipeline picks it up A hook is setup(Done) 
2) Test Stage -  AWS Code Build runs all the test cases using maven. (Done) 
3) Manual Approval Stage -  AWS Code -PipeLine wait for the manual approval. SNS is setup for sending emails. (Done) 
4) Build Stage - AWS Code build is used for build the War file and dist folder. (Done) 
4) Deploy Stage - AWS Code deploy is used for deploying to EC2 Instance (In progress) 



