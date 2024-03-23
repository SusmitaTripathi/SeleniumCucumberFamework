Feature: Search and place the order for products

	@SearchProduct
Scenario Outline: Search experience for product search in home and offer page
	Given User is on greencart landing page 
	When User searches with shortname <Name> and extracts actual name of product
	Then User searches for <Name> shortname in offer page
	And User verifies if product exists
	Examples:
	| Name |
	| Tom  |
	| Beet |