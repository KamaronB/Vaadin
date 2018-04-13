package com.example.BankForm;

import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.Composite;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

public class DefaultView extends Composite implements View{
	
	public DefaultView() {
		 Panel panel = new Panel("My Custom Component");
	        VerticalLayout panelContent = new VerticalLayout();
	        panel.setContent(panelContent);

	        // Compose from multiple components
	        Label label = new Label("");
	        panelContent.addComponent(label);
	        panelContent.addComponent(new Button("Ok"));

	        // The composition root MUST be set
	        setCompositionRoot(panel);
	        
	        
	}

}
