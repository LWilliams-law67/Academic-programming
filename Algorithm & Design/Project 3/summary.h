/*
 *      File  : summary.h
 *      Author: Luke Williams (law67)
 *      Course: COP3014
 *      Proj  : Project 03
 *      Descr : The declaration of the class that contains the object members
 *              of a summary for displaying transactions for the day.
*/
#include<iostream>
#include<array>
#include "transaction.h"

#ifndef SUMMARY_H_
#define SUMMARY_H_
class summary{
	public:
		summary(){
			totalTransactions = 0;
			completedTransactions = 0;
			voidedTransactions = 0;
		};
		void newSummaryTransaction();
		void removeSummaryTransaction(int transactionID);
		void printSummary();
		void quickSummary();
		
	private:
		std::array<transaction, 10> today;
		int totalTransactions, completedTransactions, voidedTransactions;
};
#endif
