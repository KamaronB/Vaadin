package com.example.AccountView;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Composite;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.AccountView.CheckingAccount;
@Theme("mytheme")
public class Account extends Composite implements View {

private VerticalLayout layout = new VerticalLayout();

private final Button deposit = new Button();
private final Button withdraw = new Button();
private static final long serialVersionUID = 1113799434508676095L;


	public Account(){
		
		
	setCompositionRoot(drawAccount());
		
		
				
	}
	
	
	public Component drawAccount()
	{    
	    

        TextField Transactions = new TextField();
      
        Button deposit = new Button("Deposit");
        Button withdraw = new Button("Withdraw");
        
        
        layout.addComponent(Transactions);
        layout.addComponent(deposit);
        layout.addComponent(withdraw);
       
        
        return layout;
        
		
	}
	
	public void addNamelabel(String name)
	{
		 Label Name = new Label("Hello " + name + " Welcome to your Online Bank! ");
		layout.addComponent(Name);
		
	}
	public void addInfoLabel(double balance, int AccountID)
	{
		Label amount = new Label(" Account Number: " +AccountID +" Your Current Balance Is " + balance );
		
		layout.addComponent(amount);
	}
	
   
		
	}
	    
	
	