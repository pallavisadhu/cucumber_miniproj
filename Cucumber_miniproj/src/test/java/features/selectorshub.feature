Feature: selectorshub practice page

Background: Navigate to the selectors hub practice page
When the user checks the title of the webpage 
Then the title should be "Xpath Practice Page | Shadow dom, nested shadow dom, iframe, nested iframe and more complex automation scenarios."

@smoke
Scenario: To verify form fill 
When the user enter following details in the form
|Fields       |Values        |
|User Email   |test@gamil.com|
|Password     |test123       |
|Company      |ABC Comapny   |
|Mobile Number|2137869898    |
And the user click on the Submit button
Then the values to be added

@smoke
Scenario: To verify number of links under checkout here drop down button
When the user click on the checkout here button
Then the number of links should be 3.

@regression
Scenario: To verify number of options under choose a car drop down and print them
When the user click on the drop down
Then the number of options should be 4
And the options are "Volvo,Saab,Opel,Audi"

@smoke
Scenario: To verify Testers Food link
When the user click on the Testers Food link
Then the linke should be opened in another window

Scenario: To verify password textbox
When the user enters password 
Then the password should be "password"

Scenario: To verify coffee time text box
When the user enters text in the coffee time textbox
Then the text should be "yes"


@smoke @regression
Scenario Outline: To verify firstname and lastname text box
When user enters <firstname>,<lastname>
Then the name should be <output>

Examples:
|firstname  |lastname  |output      |
|"test1"    |"last1"   |"test1last1"|
|"test2"    |"last2"   |"test2last2"|




