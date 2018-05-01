package com.example.AccountView;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import com.example.AccountView.SignUP;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import com.example.AccountView.BankAccount;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.server.VaadinServletRequest;
import com.vaadin.server.VaadinServletResponse;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Composite;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.themes.ValoTheme;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.example.AccountView.Account;
import com.example.AccountView.DefaultView;
import java.sql.*;
import com.mysql.*;

/**
 * This UI is the application entry point. A UI may either represent a browser
 * window (or tab) or some part of an HTML page where a Vaadin application is
 * embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is
 * intended to be overridden to add component to the user interface and
 * initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

	@Override
	protected void init(VaadinRequest vaadinRequest) {

		DataBase DB = new DataBase();

		DB.getConnection();

		if (DB.getConnection() == null) {
			System.out.println("connection Failed");
		} else {
			System.out.println("connection Succceded");
		}

		// Create account instance

		// DB.execute(DB.getConnection(), "insert into CUSTOMER_LOG (CUS_ID, Username,
		// Password) " + " values(12345,'john', 'doe' )");

		// Create instance of default view & signup View
		DefaultView view = new DefaultView();
		SignUP signup = new SignUP();

		// Create Menu items(Login Button, Title, and register button)
		Label title = new Label("Menu");
		title.addStyleName(ValoTheme.MENU_TITLE);

		Button login = new Button("MyAccount", e -> getNavigator().navigateTo("Account"));
		login.addStyleNames(ValoTheme.BUTTON_LINK, ValoTheme.MENU_ITEM);

		Button sign_up = new Button("Register", e -> getNavigator().navigateTo("Sign-Up"));
		sign_up.addStyleNames(ValoTheme.BUTTON_LINK, ValoTheme.MENU_ITEM);

		CssLayout menu = new CssLayout(title, login, sign_up);
		menu.addStyleName(ValoTheme.MENU_ROOT);

		// Create container to toss view into
		CssLayout viewContainer = new CssLayout();
		CustomLayout layout = new CustomLayout("Layout3");

		// Set login invisible until credentials verified through ClickListener
		login.setVisible(false);

		Account account = new Account();
		view.ok.addClickListener(e -> {
			if (DB.login(DB.getConnection(), view.getUsername(), view.getPassword()) == true) {
				login.setVisible(true);
				account.addNamelabel(view.getUsername());
				account.addInfoLabel(DB.getBalance(DB.getConnection(),view.getUsername()), DB.getAccount(DB.getConnection(),view.getUsername()));

			} else
				view.errorLog();
		});

		// set signup button to add entries to database
		signup.signup.addClickListener(e -> {
			if (signup.getUsername() != null && signup.getPassword() != null && signup.getFirstName()!=null && signup.getPhone() !=null && signup.getLastName() !=null) {
				//DB.execute(DB.getConnection(),
						//"insert into CUSTOMER_LOG (CUS_ID,Username,Password,Firstname,Lastname) " + " values("
							//	+ signup.getAccount() + ",'" + signup.getUsername() + "','" + signup.getPassword() + "','"+ signup.getFirstName()+ "','"+signup.getLastName() + "' )");
				signup.getData(signup.getUsername(),signup.getPhone());
				getNavigator().navigateTo("");

			}
			else
			{signup.errorLog();}

		});
		
		//Setup deposit/withdrawal information
		
		//account.deposit.addClickListener(e->{ })
		

		// Split mainLayout between the menu and view container
		CssLayout mainLayout = new CssLayout(menu, viewContainer);

		mainLayout.setSizeFull();
		setContent(mainLayout);

		//Create navigator and add instance of views

		Navigator navigator = new Navigator(this, viewContainer);
		navigator.addView("", view);
		navigator.addView("Account", account);
		navigator.addView("Sign-Up", signup);

	}

	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
	public static class MyUIServlet extends VaadinServlet {

	}
}