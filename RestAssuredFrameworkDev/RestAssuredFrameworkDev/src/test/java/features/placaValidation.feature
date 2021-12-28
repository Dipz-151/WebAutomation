Feature: Validating Place API's

Scenario: Validating if a new place is getting added successfully using ADDPlaceAPI
	Given Add Place Payload
	When User calls "AddPlaceAPI" with Post http request 
	Then API call is successful with status code 200
	And "Status" in response body is "Ok"
	And "scope" in response body is "APP"
	