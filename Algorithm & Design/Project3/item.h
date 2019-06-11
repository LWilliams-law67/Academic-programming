/*
 *      File  : item.h
 *      Author: Luke Williams (law67)
 *      Course: COP3014
 *      Proj  : Project 03
 *      Descr : The declaration of the class that contains the object members
 *              of items for selling and to print in the summary for the day.
*/
#include<iostream>
#include <string>

#ifndef ITEM_H_
#define ITEM_H_
class item{
	public:
		item();
		void setItemName(std::string itemName);
		void setItemCost(double itemCost);
		void setItemSell(double itemSell);
		std::string getItemName();
		double getItemCost();
		double getItemSell();
		
	private:
		double cost;
		double sell;
		std::string name;
		
};
#endif
