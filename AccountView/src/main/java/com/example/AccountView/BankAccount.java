package com.example.AccountView;

public abstract class BankAccount {

	private static int numberOfAccounts= 100001;
	protected double balance;
	protected String owner;
	protected String accountNumber;
	
	
	
	
	public BankAccount()
	{ 
		
		
	   accountNumber=" " + numberOfAccounts;
		
		
		
		
		
		numberOfAccounts++;
		
	
		
	}
	
	public BankAccount(String name,double amount)
	{
		owner = name;
		balance= amount;
		
		accountNumber= " " + numberOfAccounts;
		
		numberOfAccounts++;
		
		
	}
	public BankAccount(BankAccount oldAccount, double amount)
	{
		oldAccount.owner= owner;
		oldAccount.accountNumber=accountNumber;
		
		oldAccount.balance=amount;
	}
	public void deposit(double amount)
	{ 
		balance = amount + balance;
	
		
	}
	public void withdraw(double amount)
	{
		
	balance = balance- amount;
	  
	  
	}
    
    public String transaction(String type, double amount)
    {      String trans=null;
    	
    	if (type.equalsIgnoreCase("deposit")){
    		
    		deposit(amount);
    		trans = "Deposit of " + amount + ", Balance= " + balance;
    }
    	
    	else if(type.equalsIgnoreCase("withdraw") && balance<amount)
    		
    		trans= " Insufficient Funds to withdraw " + amount+  ", Balance= " + balance;
    	
    	else if(type.equalsIgnoreCase("withdraw") && balance>amount){
    		
    		withdraw(amount);
    	    trans = "Withdrawal of " + amount + ", Balance= " + balance;
    	}
    	
    	return trans;
    
    }
    
    
    public abstract String accountInfo();
    

}
