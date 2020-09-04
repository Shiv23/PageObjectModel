#PageObjectModel
Page Object Model framework with TestNG

libraries used for this project are - Selenium TestNG Extent Reports

Steps to clone execute the tests 
git clone https://github.com/Shiv23/PageObjectModel 
cd PageObjectModel 
mvn clean test


Jenkins File is added to configure a Declarative Pipeline, and build is triggered at every code push event.
A Webhook is configured to this repository using ngrok that exposes my local jenkins to public so as to be accessible over internet
