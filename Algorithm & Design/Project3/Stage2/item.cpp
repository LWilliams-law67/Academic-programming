/*
 *      File  : item.h
 *      Author: Luke Williams (law67)
 *      Course: COP3014
 *      Proj  : Project 03
 *      Descr : The definition of the class that contains the initialized members
 *              of items for selling and generating a profit to print in the summary for the day.
*/
#include "item.h"
#include<iostream>

item::item(){
	sell = 0.0;
	cost = 0.0;
	name = "none";
}

void item::setItemName(std::string itemName){
	this->name = itemName;
}

void item::setItemCost(double itemCost){
	this->cost = itemCost;
}

void item::setItemSell(double itemSell){
	this->sell = itemSell;
}

std::string item::getItemName(){
	return name;
}

double item::getItemCost(){
	return cost;
}

double item::getItemSell(){
	return sell;
}
