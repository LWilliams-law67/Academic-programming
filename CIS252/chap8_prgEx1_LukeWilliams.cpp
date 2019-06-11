/*
	Author: Luke Williams
	Date: 5 March 2018
	Description: Chapter 8 programming exercise 1: This program calculates a customer's bill
				for a local cable company. There are two types of customers: residential and business,
				each has a different rate for calculating a bill. The named constants are defined in a
				namespace.
*/

#include<iostream>
#include<iomanip>

using namespace std;
namespace residential
{
	const double RES_BILL_PROC_FEES = 4.50;
	const double RES_BASIC_SERV_COST = 20.50;
	const double RES_COST_PREM_CHANNEL = 7.50;
}
namespace business
{
	const double BUS_BILL_PROC_FEES = 15.00;
	const double BUS_BASIC_SERV_COST = 75.00;
	const double BUS_BASIC_CONN_COST = 5.00;
	const double BUS_COST_PREM_CHANNEL = 50.00;
}

int main()
{
	int accountNumber;
	char customerType;
	int numOfPremChannels;
	int numOfBasicServConn;
	double amountDue;
	
	cout << fixed << showpoint << setprecision(2);
	cout << "This program computes a cable bill." << endl;
	
	cout << "Enter account number (an integer): " << endl;
	cin >> accountNumber;
	cout << endl;
	
	cout << "Enter customer type: R or r (residential), B or b (business): ";
	cin >> customerType;
	cout << endl;
	
	switch (customerType)
	{
		case 'r':
		case 'R':
			cout << "Enter the number of premium channels: ";
			cin >> numOfPremChannels;
			cout << endl;
			
			using namespace residential;
				amountDue = RES_BILL_PROC_FEES + RES_BASIC_SERV_COST
							+ numOfPremChannels * RES_COST_PREM_CHANNEL;
			
			cout << "Account number: " << accountNumber << endl;
			cout << "Amount Due: $" << amountDue << endl;
			break;
			
		case 'b':
		case 'B':
			cout << "Enter the number of basic service connections: ";
			cin >> numOfBasicServConn;
			cout << endl;
			
			cout << "Enter the number of premium channels: ";
			cin >> numOfPremChannels;
			cout << endl;
			
			using namespace business;
			if (numOfBasicServConn <= 10)
				amountDue = BUS_BILL_PROC_FEES + BUS_BASIC_SERV_COST
							+ numOfPremChannels * BUS_COST_PREM_CHANNEL;
			else
				amountDue = BUS_BILL_PROC_FEES + BUS_BASIC_SERV_COST
							+ (numOfBasicServConn - 10) * BUS_BASIC_CONN_COST
							+ numOfPremChannels * BUS_COST_PREM_CHANNEL;
							
			cout << "Account number: " << accountNumber << endl;
			cout << "Amount Due: $" << amountDue << endl;
			break;
			
		default:
			cout << "Invalid customer type." << endl;
	}
	
	return 0;
}
