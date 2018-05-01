package com.example.AccountView;

import com.vaadin.annotations.Theme;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.server.UserError;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Composite;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
@Theme("mytheme")
public class DefaultView extends Composite implements View{
	CustomLayout layout = new CustomLayout("Layout3");

	 final TextField username2 = new TextField();
	final PasswordField password2 = new PasswordField();
	 final Button ok = new Button("Login");
	 boolean valid = false;
    
    
	public DefaultView() {
		
	
		this.setCompositionRoot(drawLayout()); 

	        
	}
	
	public Component drawLayout() 
	{
		layout.addComponent(password2,"password");
		password2.setWidth(4, Unit.INCH);
	  
	    password2.setIcon(VaadinIcons.KEY);
	    
	     
	        username2.setWidth(4, Unit.INCH);
	        layout.addComponent(username2,"username");
	        username2.setIcon(VaadinIcons.USER);
	       
	        layout.addComponent(ok,"ok");
	        
	       // ok.addClickListener(e->);
	        
	        return layout;
	        
	        
	        
	        
	}
	
	public boolean validLogin()
	{  
		
		 valid = false;
		
		 ok.addClickListener(e->{
		if(password2.getValue() =="bickham" && username2.getValue()=="kamaron")
		{
			this.valid= true;
		}
		else
			this.valid=false; });
		
		return valid;
		
	}
	
	public void errorLog()
	{
		password2.setComponentError(new UserError("Please Enter valid Password!"));
		username2.setComponentError(new UserError("Please Enter Valid Username!"));
		
	}
	
	public String getPassword()
	{
		return password2.getValue();
	}
	public String getUsername()
	{
		return username2.getValue();
	}
	
}
