Feature:
validate the Novo login functionality

Scenario:
To validate the login with valid credentials

Given user starts "chrome" browser
And user launched the application URL "https://chasma-novo-dev.azurewebsites.net/"
When user enters username "bdatla@pixentia.com" in text field using xpath "//input[@formcontrolname='username']"
And user enters password "Test123$" in text field using xpath "//input[@formcontrolname='password']"
And user clicks on the login button using xpath "//button[@type='submit']"
Then user will redirects to "Home" tab


