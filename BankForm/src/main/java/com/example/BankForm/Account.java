package com.example.BankForm;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Composite;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

public class Account extends Composite implements View {

	
	 
	  
	public Account() 
	{   
     Panel panel = new Panel();
   setCompositionRoot(panel);
	}
	  @Override
	  public void enter(ViewChangeEvent event) {
	

		  setSizeFull();
		
		  Button button = new Button();
		  
		Notification.show("You did it");
		
	  }
	}