package net.eclipsetraining.contacts.ui.views.list;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "net.eclipsetraining.contacts.ui.views.list.messages"; //$NON-NLS-1$
	public static String ContactListViewPart_firstName;
	public static String ContactListViewPart_lastName;
	public static String DeleteContactHandler_msgQuestion;
	public static String DeleteContactHandler_msgTitle;
	public static String SendEmailHandler_msgMessage;
	public static String SendEmailHandler_msgTitle;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
