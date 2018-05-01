package com.example.AccountView;

public class CheckingAccount extends BankAccount {
	
      static final double FEE = 0.15;
      
      
     public CheckingAccount(String name, double amount)
      {
    	  super(name,amount);
    	  
    	 accountNumber= accountNumber + "-10";
    	  
    	  
      }
      
      public String toString()
      {
    	  String info = "Checking Account Number " + accountNumber + " belongs to " + owner;
    	  
    	  return info;
      }
      
      public String accountInfo()
      {  
    	  
    	  String info = "\n" + "Checking Account Number:" + accountNumber + "\n" 
    			  
    			  + "Client:" + owner + "\n" + "Current Balance:" + balance;
    	  
    	  return info;
    	  
      }
      
      public String transaction(String type,double amount)
      { String trans=null;
    	  
    	  if (type.equalsIgnoreCase("deposit")){
      		
      		deposit(amount);
      		trans = "Deposit of " + amount + " , Balance= " + (balance-FEE);
      }
      	
      	else if(type.equalsIgnoreCase("withdraw") && balance<amount)
      		
      		trans= "Insufficient Funds to withdraw " + amount+  " , Balance= " + (balance-FEE);
      	
      	else if(type.equalsIgnoreCase("withdraw") && balance>amount){
      		
      		withdraw(amount);
      	    trans = "Withdrawal of " + amount + ", Balance= " + (balance-FEE);
      	}
      	
      	return trans;
      }
      
  

}
