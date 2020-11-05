Feature: Add Customer 

Background: commman stpes in this feature 
	Given User Launch any web application 
	When User goto website "https://admin-demo.nopcommerce.com/login"
	Then user set username as "admin@yourstore.com" 
	And Password as "admin" 
	Then user click on login 
	And verifiy page titile as "Dashboard / nopCommerce administration" 
	Then user clicks on cxtab 
	Then user clicks on subcxtab 
	
@smoke	
Scenario: Add cx with vaild cridintials 
	Then Then user clicks on addcxtab 
	Then user fill complete form with valid details 
	And user clicks on save button and validate msg 
	And close the browser 
	
@reggression	
Scenario: search cx with vaild cridintials 
	Then user enter search details 
	And click on search button 
	And verifiy serch is succsfull 
	And close the browser 
	