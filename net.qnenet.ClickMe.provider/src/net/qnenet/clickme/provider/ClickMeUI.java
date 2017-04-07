package net.qnenet.clickme.provider;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;


/**
 * This is the Vaadin UI class. It is derived from the Vaadin Hello World example
 */

@Theme("valo")
public class ClickMeUI extends UI {
	private static final long serialVersionUID = 1L;
	private ClickMeImpl clickMeImpl;

//	public ClickMeUI() {
//	}

	public ClickMeUI(ClickMeImpl clickMeImpl) {
		this.clickMeImpl = clickMeImpl;
	}

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);

		Button button = new Button("Click Me " + clickMeImpl.nextInstance());
		
		button.addClickListener(evt -> {
			clickMeImpl.anotherClick();
			layout.addComponent(new Label("Thank you for clicking number " + clickMeImpl.getClicks()));
		});

		layout.addComponent(button);
	}
}
