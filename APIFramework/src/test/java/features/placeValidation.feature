Feature: Validating Place API

@AddPlace
  Scenario Outline: Verify the place is being successfully added using AddPlaceAPI
    Given 	Add Place payload "<name>" "<language>" "<address>"
    When 	user calls "AddPlaceAPI" with "POST" http request
    Then 	API call got success with status 200
    And 	"status" in response body is "OK"
    And 	"scope" in response body is "APP"
    And     verify place_id created maps to "<name>" using "getPlaceAPI"
    
    
   Examples:
   |name	 |language|address|
   |Ansuman	 |English |India|
   #|Pizza house|French|USA|
   
  @DeletePlace
   Scenario: Verify if deletePlaceAPI functionality is working.
   	Given Delete place payload
   	When  user calls "deletePlaceAPI" with "POST" http request
   	Then  API call got success with status 200
   	And   "status" in response body is "OK"