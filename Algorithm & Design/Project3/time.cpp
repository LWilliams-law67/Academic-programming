/*
 *      File  : time.h
 *      Author: Luke Williams (law67)
 *      Course: COP3014
 *      Proj  : Project 03
 *      Descr : The definition of the class that creates a time for a new transaction
*/
#include<iostream>
#include<sting>
#include "time.h"

time::time(){
	hour = 0;
	minutes = 0;
	seconds = 0;
}

void time::setTime(int h, int m, int s){
	seconds = s;
	minutes = m;
	hour = h;
}

void time::getTime(){
	std::cout << hour << ":" << minutes << ":" << seconds;
}
