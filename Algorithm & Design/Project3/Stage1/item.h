/*
 *      File  : item.h
 *      Author: Luke Williams (law67)
 *      Course: COP3014
 *      Proj  : Project 03
 *      Descr : The declaration of the class that contains the object members
 *              of items for selling and to print in the summary for the day.
*/
#include<string>

using namespace std;

class item{
	private:
		double cost;
		double sell;
		string name;
		char* name_ptr;
		
	public:
		item();
		~item();
		void setItemName();
		void setItemCost();
		void setItemSell();
		char* getItemName();
		double getItemCost();
		double getItemSell();
}; 
