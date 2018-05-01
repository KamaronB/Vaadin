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
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import com.vaadin.ui.Composite;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI{

    @Override
    protected void init(VaadinRequest vaadinRequest) {
    
    	 CustomLayout layout = new CustomLayout("Layout3");
    	 
    	 final PasswordField password2 = new PasswordField();
         password2.setWidth(4, Unit.INCH);
         layout.addComponent(password2, "password");
         password2.setIcon(VaadinIcons.KEY);
         
         final TextField username2 = new TextField();
         username2.setWidth(4, Unit.INCH);
         layout.addComponent(username2, "username");
         username2.setIcon(VaadinIcons.USER);
         
         final Button ok = new Button("Login");
        ok.setWidth(1, Unit.INCH);
         
         layout.addComponent(ok, "ok");
    	 
    	 setContent(layout);
    	 
    	 
            CssLayout AccountView = new CssLayout();
            
            
            
            Navigator nav = new Navigator(this, AccountView);
            nav.addView("Account", Account.class);
            nav.addView("", MyUI.class);
          
            ok.addClickListener(e-> {
           	 //verify password & username
           	 
            if (password2.getValue().equals("bickham") && username2.getValue().equals("kamaron"))
            {  
           .navigateTo("Account");
            }
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
