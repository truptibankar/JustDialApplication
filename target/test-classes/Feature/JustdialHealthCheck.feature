@ui @healthcheck
Feature: Just Dial Application Health Check

 Scenario: User is able to sign up in the Application
   Given User navigates to the application url
   When User click on the sign up link of the application
   And User enters name as "Trupti" and phone number as "9011831537" ans click on submit button
   Then User is displayed with the message as "OTP is sent on number"
   
  Scenario: User receives an error message when tries to enter incorrect mobile no in the log
   Given User navigates to the application url
   When User click on the sign up link of the application
   And User enters name as "Trupti" and phone number as "1234567890" and click on submit button
   Then User gets an error message "Please Enter Valid Mobile number!"
   
   Scenario: User receives an error message when tries to enter incorrect name in the login popup
     Given User navigates to the application url
     When User click on the login link at the top right corner of application
     And User do not right any name and phone number but clicks on submit button
     Then User gets error message as "Please enter a valid name !!"
     
   Scenario: User is able to enter only 10 digits in mobile no text box
     Given User navigates to the application url
     When User click on the login link at the top right corner of application
     Then User is able to enter only "10" digits in mobile no text box
     
   
   
   
   
   
   

