Feature: Search for a flight

Scenario: Search for a flight, one way, any city, any date, one adult
		Search results: filter 1 stop, order the first flight, select third result.
		Flight details: Assert on travel summary

	Given User is on web page
	When User select flight option
	And User select one way travel option
	And User select origin city for a flight "Ciudad de México"
	And User select destination city for a flight "Cancún"
	And User select departure date "19/10/2018"
	And User select adults for flight "1"
	And User select children for flight "0"
	And User clicks Search button "flight"
	Then The page shows the results table for flights
	And User filter for 1 stop
	And User order flight "Salida (primera)"
	And User select third flight
	Then Summary trip page is displayed
	Then Explorer is closed
	

	