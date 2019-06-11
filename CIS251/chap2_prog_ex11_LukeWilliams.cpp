/*
	Author: Luke Williams
	Date: September 29, 2017
	Description: Chapter 2 programming exercise 11 for CIS 251
				Equating the cost and revenue of the milk industry
*/

#include <iostream>
#include <iomanip>
using namespace std;

int main()

{
	int CARTONS;
	double LITERS, COST, REVENUE;
	
	cout << "Enter the total amount of milk produced in liters: ";
	cin >> LITERS;
	cout << endl;
	
	CARTONS = LITERS / 3.78 + 0.5;
	COST = LITERS * 0.38;
	REVENUE = CARTONS * 0.27;
	
	cout << fixed;
	cout << "Cartons needed: " << CARTONS << endl;
	cout << endl;
	cout << showpoint << setprecision(2);
	cout << "Cost of producing " << LITERS << " liters of milk is: $" << COST << endl;
	cout << endl;
	cout << "Profit: $" << REVENUE << endl;
	
	return 0;
}
