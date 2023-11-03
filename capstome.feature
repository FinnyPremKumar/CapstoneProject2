Feature: To test WebdriverUniversityTest
	
  Scenario: Verify title and image functionality
    Given I am on the homepage
    When I click on the IFRAME link
    Then a new tab should open and I switch to it
    And I verify the presence of the image and navigate through images
