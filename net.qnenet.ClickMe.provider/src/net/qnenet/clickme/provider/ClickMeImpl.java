package net.qnenet.clickme.provider;

import java.util.concurrent.atomic.AtomicInteger;

import org.osgi.service.component.annotations.Component;

import com.vaadin.server.UIClassSelectionEvent;
import com.vaadin.server.UICreateEvent;

import net.qnenet.vaadinosgi.api.VaadinOSGi;

/**
 * A simple example application. This is registered as a service and will create
 * the UI instances for Vaadin.
 * <p>
 * In this application we just keep track of the instances and the number of
 * clicks.
 *
 */


@Component(name = "net.qnenet.ClickMe", property = "alias=/click")
public class ClickMeImpl implements VaadinOSGi {
	AtomicInteger instance = new AtomicInteger();
	AtomicInteger clicks = new AtomicInteger();

	
	@SuppressWarnings("rawtypes")
	@Override
	public Class getUIClass(UIClassSelectionEvent uiClassSelectionEvent) {
		return ClickMeUI.class;
	}


	@Override
	public ClickMeUI getInstance(UICreateEvent event) {
		return new ClickMeUI(this);
	}

	public int nextInstance() {
		return instance.getAndIncrement();
	}

	public void anotherClick() {
		clicks.incrementAndGet();
	}

	public int getClicks() {
		return clicks.get();
	}



}
