#include<iostream>
#include<string>
#include<limits>
#include "summary.h"

using namespace std;

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char** argv) {
	
	enum MENU {NO_entry = 0, NEW_transaction = 1, VOID_transaction = 2, PRINT_summary = 3, QUICK_summary = 4, EXIT = 9};
	int search = 0;
	summary today;
	int id_num;
			
	while(search != 9){
		cout << "1: new transaction '\t'";
		cout << "2: void transaction '\t'";
		cout << "3: print summary '\t'";
		cout << "4: quick summary '\t'";
		cout << "9: EXIT" << endl;
		cout << "ENTER a menu selection: ";
		cin >> search;
		cin.ignore();
		
		switch (search){
			case NO_entry:
				cout << "0 is not a menu option." << endl;
				break;
			case NEW_transaction:
				today.newSummaryTransaction();
				break;
			case VOID_transaction:
				cout << "ENTER the transaction ID to be voided: ";
				cin >> id_num;
				cin.ignore();
				today.removeSummaryTransaction(id_num);
				break;
			case PRINT_summary:
				today.printSummary();
				break;
			case QUICK_summary:
				today.quickSummary();
				break;	
			case EXIT:
				search = EXIT;
				break;
			default:
				cout << "ERROR: invalid menu option - please try again." << endl;
				continue;
		}		
		
	}
	
	return 0;
}
