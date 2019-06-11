/*
 *      File  : summary.cpp
 *      Author: Luke Williams (law67)
 *      Course: COP3014
 *      Proj  : Project 03
 *      Descr : The definition of the class that contains the object members
 *              of a summary for displaying transactions for the day.
*/
#include<iostream>
#include "summary.h"

summary::summary(){
	totalTransactions = 0;
	completedTransactions = 0;
	voidedTransactions = 0;
}
/*
void summary::newSummaryTransaction(){
	for(int i = 0; i < 10; i++){
		if(today[i] == ' ')
			today[i] = new transaction;	//bad code
		else continue;
	}
}

void summary::removeSummaryTransaction(){
	
}

void summary::printSummary(){
	int selection = 0;
	
	cout << "1: NAME '\t'";
	cout << "2: ID # '\t'";
	cout << "3: Profit per transaction '\t'" << endl;
	cout << "Please select a sorting option for today's summary: ";
	cin >> selection;
	cin.ignore();
	
	switch (selection){
		case 1:
			for(int i = 0; i < 10; i++){
				cout << today[i] << " '\t' ";
			}
			break;
		case 2:
			for(int i = 0; i < 10; i++){
				cout << today[i] << " '\t' ";
			}
			break;
		case 3:
			for(int i = 0; i < 10; i++){
				cout << today[i] << " '\t' ";
			}
			break;
		default:
			cout << "INVALID ENTRY.";
			break;
	}

}*/
