/*
 *      File  : transaction.h
 *      Author: Luke Williams (law67)
 *      Course: COP3014
 *      Proj  : Project 03
 *      Descr : The declaration of the class that contains the objects members
 *              of transactions for adding and removing from the summary for the day.
 */
 
 class transaction{
 	public:
 		transaction();
 		~transaction();
 		transaction(int id, double sellPrice, double costPrice, char* time);	//call setTransactionTime and transactionID in this function
 		void setTransactionID();										//used to generate a transaction identification number
 		void setTransactionTime();
		int getTransactionID();
		char* getTransactionTime();									//requests time from of transaction from the user
 		double transactionProfit(double sellPrice, double CostPrice);	//use function calls as parameters to pull cost from item and sell from transaction
 		
 	private:
 		char* time;
 		double profit;
 		item items; // items = new item();
};
