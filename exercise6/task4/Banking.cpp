#include <iostream>
#include <iomanip>
using namespace std;
//////////////////////////////////////////////////////////////////////
//                        class BankAccount
//  this is the abstract base class for all types of bank accounts
//  it has the following member functions
//		deposit() 	make deposit into account
//		account_num()	access the account number
//		balance()	access the account balance
//		print()		pure virtual function to print data members
//  it has the following data members
//		acctnum		the account number
//		bal		the amount of money in the account
//////////////////////////////////////////////////////////////////////

class BankAccount
{
public:
  BankAccount(int=0,float=0);
  void deposit(float amount)   { bal += amount; }
  int account_num() const      { return acctnum; }
  float balance() const        { return bal; }
  virtual void print() = 0;
protected:
  int acctnum;
  float bal;
};

//////////////////////////////////////////////////////////////////////
//  constructor for BankAccounts; both args can default to zero

BankAccount::BankAccount(int num, float ibal)
{
  acctnum = num;
  bal = ibal;
}

//////////////////////////////////////////////////////////////////////
//                        class Checking
//  this class is derived from BankAccount; it represents checking accounts
//  it contains the following additional member functions
//		Checking()	constructor
//		cash_check()    cash check and debit balance
//		print()		virtual function to print data members
//  it contains the following additional data members
//		minimum		per check charge added if bal < minbal
//		charge		amount charged per check when bal < minbal
//////////////////////////////////////////////////////////////////////

class Checking : public BankAccount
{
public:
  Checking(int=0,float=0,float=1000,float=.25);
  int cash_check(float);
  virtual void print();
protected:
  float minimum;
  float charge;
};

//////////////////////////////////////////////////////////////////////
//  constructor for checking accounts -- all parms can default

Checking::Checking(int num, float ibal, float min, float chg)
                   : BankAccount(num,ibal)
{
  minimum = min;
  charge = chg;
}

//////////////////////////////////////////////////////////////////////
//  cash a check
//	return false if there is not enough money to cash the check
//	otherwise cash the check, deduct per check fee if below
//      the minimum balance

int Checking::cash_check(float amount)
{
  char pause;

//  check for insufficient funds, write message and exit false
  if (amount >= bal)
    {
      cout << endl << "Cannot cash check for $" << amount << " on account "
	   << acctnum << "; insufficient funds." << endl;
      cout << "Press enter to continue." << endl;
      cin.get(pause);
      return 0;
    }

//  cash check and deduct per check charge if necessary
  if (bal < minimum)
    bal -= amount + charge;
  else
    bal -= amount;
  return 1;
}

///////////////////////////////////////////////////////////////////////
//  virtual print function for Checking

void Checking::print()
{
  cout << "Checking Account: " << acctnum << endl;
  cout << "\tBalance: " << bal << endl;
  cout << "\tMinimum to Avoid Charges: " << minimum << endl;
  cout << "\tCharge per Check: " << charge << endl << endl;
}

//////////////////////////////////////////////////////////////////////
//                        class InterestChecking
//  this class is derived from Checking; it represents interest
//  bearing checking accounts
//  it contains the following additional member functions
//	   InterestChecking()	constructor
//	   interest()  		calculate and add interest if bal > minbal
//	   print()		virtual function to print data members
//  it contains the following additional data members
//	   intrate		annual interest rate earned when bal > minbal
//                              credited monthly
//         minint		minimum balance required to receive interest
//	   moncharge	        monthly fee (only charged if minimum balance 
//                              not met)
//////////////////////////////////////////////////////////////////////

class InterestChecking : public Checking
{
public:
  InterestChecking(int=0,float=0,float=1000,float=2500,float=.25,
		   float=2.5,float=10);
  void interest();
  virtual void print();
protected:
  float intrate;
  float minint;
  float moncharge;
};

//////////////////////////////////////////////////////////////////////
//  constructor for InterestChecking accounts -- all parms can default

InterestChecking::InterestChecking(int num, float ibal, float cmin, float imin,
            float chg, float rate, float monchg) : Checking(num,ibal,cmin,chg)
{
  intrate = rate;
  minint = imin;
  moncharge = monchg;
}

//////////////////////////////////////////////////////////////////////
//  add interest to InterestChecking account -- interest is earned
//  only when balance is above the minimum; if not, the monthly fee is charged

void InterestChecking::interest()
{
  const int nummths = 12;
  const int cvtpct = 100;
  if (bal >= minint)
    {
      float intamt = bal * intrate / (nummths * cvtpct);
      bal += intamt;
    }
  else
    bal -= moncharge;
}

///////////////////////////////////////////////////////////////////////
//  virtual print function for InterestChecking

void InterestChecking::print()
{
  cout << "Interest Checking Account: " << acctnum << endl;
  cout << "\tBalance: " << bal << endl;
  cout << "\tMinimum to Avoid Charges: " << minimum << endl;
  cout << "\tCharge per Check: " << charge << endl;
  cout << "\tMinimum for Interest and No Monthly Fee: " << minint << endl;
  cout << "\tInterest: " << intrate << "%" << endl;
  cout << "\tMonthly Fee: " << moncharge
       << "\n\n";
}

//////////////////////////////////////////////////////////////////////
//                        class Savings
//  this class is derived from BankAccount; it represents savings accounts
//  it contains the following additional member functions
//		Savings()	constructor
//		interest()      caculate and add interest
//		withdraw()	debit account for a withdrawal
//		print()		virtual function to print data members
//  it contains the following additional data members
//		intrate		annual interest rate earned
//                              credited monthly
//////////////////////////////////////////////////////////////////////

class Savings : public BankAccount
{
public:
  Savings(int=0,float=0,float = 3.5);
  void interest();
  int withdraw(float);
  virtual void print();
protected:
  float intrate;
};

//////////////////////////////////////////////////////////////////////
//  constructor for savings accounts -- all parms can default

Savings::Savings(int num, float ibal, float rate) : BankAccount(num,ibal)
{
  intrate = rate;
}

//////////////////////////////////////////////////////////////////////
//  withdraw from a Savings account -- returns false if the withdrawal
//  was not done because of insufficient funds; otherwise return true

int Savings::withdraw(float amount)
{
  char pause;
  if (bal <= amount)
    {
      cout << endl << "Withdrawal of $" << amount << " from account "
	   << acctnum << " not permitted; insufficient funds." << endl;
      cout << endl << "Press Enter to continue." << endl;
      cin.get(pause);
      return 0;
    }
  bal -= amount;
  return 1;
}

//////////////////////////////////////////////////////////////////////
//  add interest to a savings account

void Savings::interest()
{
  const int nummths = 12;
  const int cvtpct = 100;
  float intamt = bal * intrate / (nummths * cvtpct);
  bal += intamt;
}

///////////////////////////////////////////////////////////////////////
//  virtual print function for Savings

void Savings::print()
{
  cout << "Savings Account: " << acctnum << endl;
  cout << "\tBalance: " << bal << endl;
  cout << "\tInterest: " << intrate << "%" << endl << endl;
}

//////////////////////////////////////////////////////////////////////
//  main program to test our classes

int main(int argc, char **argv)
{
  BankAccount * accounts[4];

//  define bank accounts
  Checking stroustrup(1001,750);
  InterestChecking thompson(1005,3500);
  Savings kernighan(1022,1000);
  Checking ritchie(1014,600);

  accounts[0] = &stroustrup;
  accounts[1] = &thompson;
  accounts[2] = &kernighan;
  accounts[3] = &ritchie;

//  set up output for dollar amounts
  cout.setf(ios::fixed,ios::floatfield);
  cout.setf(ios::showpoint);
  cout << setprecision(2);

//  checking account transactions
  stroustrup.deposit(1500);
  stroustrup.cash_check(250);
  stroustrup.cash_check(195.99);
  stroustrup.cash_check(650);
  stroustrup.cash_check(1195);
  ritchie.cash_check(125.50);
  ritchie.deposit(1200);
  ritchie.cash_check(369.99);

//  interest checking account transactions
  thompson.cash_check(365.55);
  thompson.deposit(965);

//  savings account transactions
  kernighan.withdraw(450);
  kernighan.deposit(300);
  kernighan.withdraw(400);

//  add interest where appropriate
  thompson.interest();
  kernighan.interest();

//  report on account balances
  cout << endl << endl << "\t\tAccount Balances" << endl << endl;
  cout << endl << "Account Number:  " << stroustrup.account_num();
  cout << "      Balance:  $ " << stroustrup.balance() << endl;
  cout << endl << "Account Number:  " << kernighan.account_num();
  cout << "      Balance:  $ " << kernighan.balance() << endl;
  cout << endl << "Account Number:  " << thompson.account_num();
  cout << "      Balance:  $ " << thompson.balance() << endl;
  cout << endl << "Account Number:  " << ritchie.account_num();
  cout << "      Balance:  $ " << ritchie.balance() << endl;
  cout << endl;

  for (int i = 0 ; i < 4 ; i++)
  {
    accounts[i]->print();
	}
return 0;
}
