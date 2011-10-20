package net.eclipsetraining.contacts.ui.views.details;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "net.eclipsetraining.contacts.ui.views.details.messages"; //$NON-NLS-1$
	public static String ContactDetailsComposite_birthdate;
	public static String ContactDetailsComposite_firstName;
	public static String ContactDetailsComposite_lastName;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
