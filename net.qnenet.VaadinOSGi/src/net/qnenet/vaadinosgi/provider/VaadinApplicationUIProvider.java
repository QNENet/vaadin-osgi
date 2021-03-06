package net.qnenet.vaadinosgi.provider;

import com.vaadin.server.UIClassSelectionEvent;
import com.vaadin.server.UICreateEvent;
import com.vaadin.server.UIProvider;
import com.vaadin.ui.UI;

import net.qnenet.vaadinosgi.provider.VaadinOSGiServlet.LocalVaadinServletService;


@SuppressWarnings("serial")
public class VaadinApplicationUIProvider extends UIProvider {

	public UI createInstance(UICreateEvent event) {
		LocalVaadinServletService service = (LocalVaadinServletService) event.getRequest().getService();
		return service.getApplication().getInstance(event);
	}

	@Override
	public Class<? extends UI> getUIClass(UIClassSelectionEvent event) {
		LocalVaadinServletService service = (LocalVaadinServletService) event.getRequest().getService();
		return service.getApplication().getUIClass(event);
	}
}