Feature: Search for a fly

Scenario: Search an hotel, any date, any city, 2 adults, 2 rooms (1 adult per room)
		Search results: Assert on each filter category (price, name, zone, etc), 
		Sort by price, filter any hotel by hotel name, pick it and continue, select rooms
		and finish

	Given User is on web page
	When User select hotel option
	And User select destination city for an hotel "Chihuahua"
	And User select check-in "19/10/2018"
	And User select check-out "25/10/2018"
	And User select rooms "2"
	And User select adults for hotel "1"
	And User select children for hotel "0"
	And User clicks Search button "hotel"
	Then Page shows Results table for hotel searchs
	And User sort by price "1"
	And User search an hotel "Posada"
	And User select hotel No "1"
	Then Page shows Hotel result
	Then Explorer is closed