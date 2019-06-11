/*
 *      File  : summary.cpp
 *      Author: Luke Williams (law67)
 *      Course: COP3014
 *      Proj  : Project 03
 *      Descr : The definition of the class that contains the object members
 *              of a summary for displaying transactions for the day.
*/
#include<iostream>
#include<string>
#include<limits>
#include<stdio.h>
#include "summary.h"

using namespace std;

void summary::newSummaryTransaction(){
	int h, m, s;
	double sale, cost;
	string name;
	
	cout << "Please input the information for this transaction: " << endl;
	cout << "Time of transaction: HOUR: ";
	cin >> h;
	cout << " MINUTES: ";
	cin >> m;
	cout << " SECONDS: ";
	cin >> s;
	cin.ignore(numeric_limits<streamsize>::max());
	cout << endl;
	//user has inputed hour, minutes, and seconds for transaction.
	
	cout << "Name of the item: ";
	getline(cin, name);
	cin.ignore(numeric_limits<streamsize>::max());
	cout << endl;
	//user has speicified an item name for transaction.
	
	cout << "Sale price to customer: ";
	cin >> sale;
	cin.ignore();
	cout << "'\n'Cost price for company: ";
	cin >> cost;
	cin.ignore();
	cout << endl;
	//user has provided item sale and cost prices for transaction.
	
	transaction open(h,m,s,name,sale,cost);
	//cretes transaction object 'open' with user specified parameters for the ctor.
	
	for(int i = 0; i < 10; i++){
		if((i == 9) && (today[i].getTransactionID() != 0)){
			cout << "Your transaction limit has been reached for today.'\n'Please remove a transaction before creating a new one." << endl;
			break;
		}
		else if(today[i].getTransactionID() != 0)
				continue;
			 else{
				today[i] = open;
				totalTransactions++;
				completedTransactions++;
				cout << "'\n'Thank you. Your transaction has been created in today's summary.'\n'" << endl;
				break;
		}
	}
	//loop puts this transactions data into today's summary array if the 10 transaction limit has not been reached.

}

void summary::removeSummaryTransaction(int transactionID){
	transaction closed;
	for(int i = 0; i < 10; i++){
		if((i == 9) && (today[i].getTransactionID() != transactionID)){
			cout << "The transaction ID you are looking for does not exist.'\n'Try another search." << endl;
			break;
		}
		else if(today[i].getTransactionID() != transactionID)
				continue;
			 else{
				today[i] = closed;
				totalTransactions++;
				voidedTransactions++;
				cout << "'\n'Thank you. Your transaction has been created in today's summary.'\n'" << endl;
				break;
		}
		//loop removes the user specified transaction from today's summary.
		//if the transaction ID is not found an error message is displayed and loop breaks back to main menu.
	}
}

void summary::printSummary(){
	enum SORT {NAME = 1, ID = 2, PROFIT = 3, CANCEL = 4};
	int select = 0;
	transaction temp;
	
	cout << "1: NAME '\t'";
	cout << "2: ID # '\t'";
	cout << "3: Profit per transaction '\t'";
	cout << "4: Cancel print '\t'" << endl;
	cout << "Please select a sorting option for today's summary: ";
	cin >> select;
	cin.ignore();
	
	switch (select){
		case NAME:
			for(int i = 0; i < today.size()-1; i++){
				
				for(int j = 0; j < today.size()-i-1; j++){
					if(today[j].getItemName() > today[j+1].getItemName()){
						temp = today[j+1];
						today[j+1] = today[j];
						today[j] = temp;
					}
					else
						continue;
				}
			}
			break;
		case ID:
			for(int i = 0; i < today.size()-1; i++){
				
				for(int j = 0; j < today.size()-i-1; j++){
					if(today[j].getTransactionID() > today[j+1].getTransactionID()){
						temp = today[j+1];
						today[j+1] = today[j];
						today[j] = temp;
					}
					else
						continue;
				}
			}
			break;
		case PROFIT:
			for(int i = 0; i < today.size()-1; i++){
				
				for(int j = 0; j < today.size()-i-1; j++){
					if(today[j].getTransactionProfit() > today[j+1].getTransactionProfit()){
						temp = today[j+1];
						today[j+1] = today[j];
						today[j] = temp;
					}
					else
						continue;
				}
			}
			break;
		case CANCEL:
			break;
		default:
			cout << "INVALID ENTRY. Returning to main menu.";
			break;
	}
	for(int i = 0; i < today.size(); i++){
		if(today[i].getTransactionID() != 0){
			cout << "ID: " << today[i].getTransactionID() << " ITEM: " << today[i].getItemName() << " TIME: ";
			today[i].getTransactionTime();
			cout << endl;
			cout << "COST: " << today[i].getItemCost() << " SALE: " << today[i].getItemSell() << " PROFIT: " << today[i].getTransactionProfit() << endl;
			cout << endl;
		}
		else
			continue;
	}
}

void summary::quickSummary(){
	cout << "Total transactions today: " << totalTransactions << endl;
	cout << "Sales: " << completedTransactions << endl;
	cout << "Voided transactions: " << voidedTransactions << endl;
	cout << "Transactions in summary: " << (completedTransactions - voidedTransactions) << endl;
	cout << endl;
}


