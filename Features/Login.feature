Feature: Login for nopc

@smoke
Scenario: Check with Login with vaild cridintials 
	Given User Launch any web application
	When User goto website "https://admin-demo.nopcommerce.com/login"
	Then user set username as "admin@yourstore.com" 
	And Password as "admin"
	Then user click on login 
	And verifiy page titile as "Dashboard / nopCommerce administration"
	Then user clicks on logout 
	And verifiy logout page titile as "Your store. Login"
	And close the browser 
	
@reggression
Scenario Outline: Login Data Driven
	Given User Launch any web application
	When User goto website "https://admin-demo.nopcommerce.com/login"
	Then user set username as "<username>"
	And Password as "<password>"
	Then user click on login 
	And verifiy page titile as "Dashboard / nopCommerce administration"
	Then user clicks on logout 
	And verifiy logout page titile as "Your store. Login"
	And close the browser
	
	Examples: 
	
	| username | password |
	| admin@yourstore.com | admin |
	| admin@yourstore.com | admin |
	
	
	
