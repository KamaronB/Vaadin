package com.example.BankForm;

import javax.servlet.annotation.WebServlet;

import com.example.BankForm.Account;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Composite;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI implements View{

    @Override
    protected void init(VaadinRequest vaadinRequest) {
      /*  final VerticalLayout layout = new VerticalLayout();
        
        final TextField name = new TextField();
        name.setCaption("Type your name here:");

        Button button = new Button("Click Me");
        button.addClickListener(e -> {
            layout.addComponent(new Label("Thanks " + name.getValue() 
                    + ", it works!"));
        });
        
        layout.addComponents(name, button);
        
        setContent(layout);*/
    	
    	
        // Create the custom layout and set it as a component in
        // the current layout
    	
    	Account account = new Account();
    	
    	//Account account = new Account();
    	
        CustomLayout bankview = new CustomLayout("Layout3");

        // Create components and bind them to the location tags
        // in the custom layout.
        
        final TextField username2 = new TextField();
        username2.setWidth(4, Unit.INCH);
        bankview.addComponent(username2, "username");
        username2.setIcon(VaadinIcons.USER);
        
       
        
        
        final CssLayout top = new CssLayout();
        final CssLayout container = new CssLayout();
        
        //bankview.addComponent(viewLayout);
        
        //Username and Password
        
        String username = "kamaron";
        String password = "bickham";

        final PasswordField password2 = new PasswordField();
        password2.setWidth(4, Unit.INCH);
        bankview.addComponent(password2, "password");
        password2.setIcon(VaadinIcons.KEY);

        final Button ok = new Button("Login");
        bankview.addComponent(ok, "okbutton");
        
        VerticalLayout layout = new VerticalLayout(container);
        
        Button button = new Button("Press me");
        
        container.addComponent(button);
        
        
        
        //Add a navigator to switch views
        
        final Navigator nav = new Navigator (this,container);
        nav.setErrorView(this);
        nav.addView("Account", Account.class);
        nav.addView("", DefaultView.class);
        
        

         setContent(bankview);
         
         
        
        //add click listener to button
        
         ok.addClickListener(e-> {
        	 //verify password & username
        	 
         if (password2.getValue().equals(password) && username2.getValue().equals(username))
         {  
        	 nav.navigateTo("Account");}
         else
         {
        	 
        	 
        	 
         }
        	
         
         } );
         
        
      
         
        
    }
  
    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = true)
    public static class MyUIServlet extends VaadinServlet {
    }
}
