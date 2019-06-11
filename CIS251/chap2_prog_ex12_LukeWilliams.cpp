/*
	Author: Luke Williams
	Date: September 29, 2017
	Description: Chapter 2 programming exercise 12 for CIS 251
				Equating the cost and revenue of the milk industry
*/

#include <iostream>
#include <iomanip>
using namespace std;

int main()

{
	int CARTONS;
	double LITERS, COST, REVENUE;
	
	cout << "Enter the following fields:" << endl;
	cout << endl;
	
	cout << "LITERS: ";
	cin >> LITERS;
	cout << endl;
	
	cout << "COST: ";
	cin >> COST;
	cout << endl;
	
	cout << "PROFIT: ";
	cin >> REVENUE;
	cout << endl;
	
	CARTONS = LITERS / 3.78 + 0.5;
	
	cout << fixed;
	cout << "Cartons needed: " << CARTONS << endl;
	cout << endl;
	cout << showpoint << setprecision(2);
	cout << "Cost of producing " << LITERS << " liters of milk is: $" << COST << endl;
	cout << endl;
	cout << "Profit: $" << REVENUE << endl;
	
	return 0;
}
