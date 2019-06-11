/*
 *      File  : time.h
 *      Author: Luke Williams (law67)
 *      Course: COP3014
 *      Proj  : Project 03
 *      Descr : The declaration of the class that creates a time for a new transaction
*/
#include<iostream>

#ifndef TIME_H_
#define TIME_H_
class time{
	public:
		time();
		void setTime(int h, int m, int s);
		void getTime();
		
	private:
		int hour;
		int minutes;
		int seconds;
};
#endif
