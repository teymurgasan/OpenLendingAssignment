# Open Lending Assignment Task

## Task:
*1. Search for "Open Lending" on Google*    
*2. Locate the Automated Lending Platform | Open Lending | United States result and navigate to it*    
*3. Go to the Blog section (Resources → Insights → Load More)*    
*4. Navigating through each page of results, verify that there are no duplicate blog entries*    
*5. Please use GitHub to track your code changes and share your completed assignment*    

## Framework
In this framework were used:    
+ TesNG 6.14.3 for Assertion    
+ Selenium Web Driver 3.141.59 for UI interaction    
+ Bonigarcia Web Driver Manager 5.1.1 for Web Driver Management    
+ Log4j 1.7.25 for logs  

To run test use 
```bash
mvn clean test
```
Test are set up to run in headless mode, configuration can be changed in **configuration.properties**  
After test execution logs will be stored in **log.out** file
