package com.example.AccountView;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Composite;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import com.vaadin.server.UserError;

public class SignUP extends Composite implements View {
	
	private final CustomLayout grid = new CustomLayout("register");
	private static int ACCOUNTID =100010;
	private static int count= 1;
	private final TextField user = new TextField("Please Enter a Username:");
	private final PasswordField pass= new PasswordField("Enter A Password :");
	private final TextField number = new TextField("Please Enter A Phone Number :");
    public  Button signup = new Button("Sign-UP");
    private final TextField firstName = new TextField("Please enter your first name");
    private final TextField LastName = new TextField("Please Enter your last name");
	
	public SignUP()
	{
		setCompositionRoot(drawSignUP());
	}
	
	public Component drawSignUP() {
	   firstName.setIcon(VaadinIcons.USER);
	    grid.addComponent(firstName,"firstname");
	    
	    LastName.setIcon(VaadinIcons.USER);
	    grid.addComponent(LastName,"lastname");
		
		
		user.setIcon(VaadinIcons.USER);
		grid.addComponent(user,"username");
		
		pass.setIcon(VaadinIcons.KEY);
		grid.addComponent(pass,"password");
		
		number.setIcon(VaadinIcons.PHONE);
		grid.addComponent(number,"phonenumber");
		
		grid.addComponent(signup,"ok");
		grid.setStyleName(".fff");
		grid.setSizeFull();
		grid.setWidth("100%");
		grid.setHeight("100%");
		return grid;
	
		
	}
	
	public String getUsername()
	{
		return user.getValue();
	}

	public String getPhone()
	{
		return number.getValue();
	}
	public String getPassword()
	{
		return pass.getValue();
	}
	public int getAccount()
	{    ACCOUNTID = count+ ACCOUNTID;
	count++;
		return ACCOUNTID;
	
		
		
	}
	
	public void sendtxt(String first, String number )
	{
	  final String ACCOUNT_SID = "ACd01b1844c5a5892d9e019142195d4e5e";
	  final String AUTH_TOKEN = "fae7aa963185f262a0e0910f51be4d68";

	 
	    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

	    Message message = Message.creator(new PhoneNumber(number), new PhoneNumber("+13128184419"),
	            "Hey " + first + " " +  " Thanks for signing up for online Banking! " )
	 
	        .create();
	}
	
	public String getFirstName()
	{
		return firstName.getValue();
	}
	public String getLastName()
	{
		return LastName.getValue();
	}
	public void getData(String first, String number)
	{
		sendtxt(first,number);
	}
	public void errorLog()
	{
		pass.setComponentError(new UserError("Please Enter valid Password!"));
		user.setComponentError(new UserError("Please Enter Valid Username!"));
		number.setComponentError(new UserError("Please Enter valid Phone number!"));
		firstName.setComponentError(new UserError("Please Enter Valid First name!"));
		LastName.setComponentError(new UserError("Please Enter valid Last Name!"));
		
	}
	
}
