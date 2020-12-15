@ui @healthcheck
Feature: Just Dial Application Health Check

 Scenario: User is able to sign up in the Application
   Given User navigates to the application url
   When User click on the sign up link of the application
   And User enters name as "Trupti" and phone number as "9011831537" ans click on submit button
   Then User is displayed with the message as "OTP is sent on number"
   
  #Scenario: User receives an error message when tries to enter incorrect mobile no in the log
   #Given User navigates to the application url
   #When User click on the sign up link of the application
   #And User enters name as "Trupti" and phone number as "1234567890" ans click on submit button
   #Then User gets an error message "Please Enter Valid Mobile number"
   
   
   

