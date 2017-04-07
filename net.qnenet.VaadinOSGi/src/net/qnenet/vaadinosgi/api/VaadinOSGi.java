package net.qnenet.vaadinosgi.api;

import org.osgi.annotation.versioning.ConsumerType;

import com.vaadin.server.UIClassSelectionEvent;
import com.vaadin.server.UICreateEvent;
import com.vaadin.ui.UI;

//import com.vaadin.server.UIClassSelectionEvent;
////import co.diderot.vaadin.diderot.base.application.ui.BaseUI;
//import com.vaadin.server.UICreateEvent;
//import com.vaadin.ui.UI;

/**
 * A service interface for bundles that want to create a Vaadin magicVaadinApplication.
 * These services should be registered with the {@link #SERVICE_PROPERY_ALIAS}
 * to the path where the magicVaadinApplication should reside.
 * <p>
 * Normally in Vaadin the instances are created by Vaadin but in this case the
 * magicVaadinApplication can setup the instances.
 * 
 * @param <T>
 *            the UI type this magicVaadinApplication supports
 */
@ConsumerType
public interface VaadinOSGi {
	/**
	 * Service property for the alias
	 */
	String SERVICE_PROPERY_ALIAS = "alias";

	/**
	 * Return the class to be used for the UI. This class can contain the @Theme annotation 
	 * @param uiClassSelectionEvent 
	 * @return the class
	 */
	@SuppressWarnings("rawtypes")
	Class getUIClass(UIClassSelectionEvent uiClassSelectionEvent);

	/**
	 * Create an instance for a new session. This class must extend the class returned from {@link #getUIClass()}
	 * 
	 * @param event the create event
	 * @return
	 */
	UI getInstance(UICreateEvent event);


}
