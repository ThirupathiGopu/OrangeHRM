Feature: Login

Scenario: Login with valid credrtials 
Given Lanch chrome browser
When Enter url"https://opensource-demo.orangehrmlive.com/"
And Enter user name  as "Admin" 
And Enter Password as "addmin123"
And click on login link
Then Page Title should be "OrangeHRM"
Then click on profile button 
When click on logout button
Then Page Title should be "OrangeHRM"
And close browser

