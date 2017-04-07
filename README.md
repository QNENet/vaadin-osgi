Example of using Peter Kriens Vaadin OSGi technique https://github.com/osgi/osgi.enroute.examples.vaadin

The VaadinResources class looks through all bundles for VAADIN directories.

In a standard setup it just needs/finds the widgetset and theme from the Vaadin Server and Vaadin Theme bundles and nothine else is required.  
For custom widgets and/or themes new bundle(s) containg a VAADIN dir can be created as separate modules which can be started and stopped as required.

The only problem with this method (using the latest Vaadin 8.1 and earlier) is an exception is thrown but the system works OK anyway  
java.lang.ClassNotFoundException: AppWidgetset cannot be found by net.qnenet.ClickMe.provider_1.0.0.201704070504
at org.eclipse.osgi.internal.loader.BundleLoader.findClassInternal(BundleLoader.java:439)
at org.eclipse.osgi.internal.loader.BundleLoader.findClass(BundleLoader.java:352)
at org.eclipse.osgi.internal.loader.BundleLoader.findClass(BundleLoader.java:344)
at org.eclipse.osgi.internal.loader.ModuleClassLoader.loadClass(ModuleClassLoader.java:160)
at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
at org.eclipse.osgi.internal.framework.EquinoxBundle.loadClass(EquinoxBundle.java:573)
at net.qnenet.vaadinosgi.provider.VaadinOSGiServlet$1.loadClass(VaadinOSGiServlet.java:64)

The system is very simple and works well.

You only need to include the VaadinOSGi bundle as a runtime dependency.

I am not sure, but I think the standard Vaadin servlet url setup prevents other urls. 

This method enables any urls to be used.  In this example localhost:8080/click
