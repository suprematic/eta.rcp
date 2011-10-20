package net.eclipsetraining.contacts.ui.views.list;

import net.eclipsetraining.contacts.core.Contact;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;

class ContactViewerComparator extends ViewerComparator {

	@Override
	public int compare(final Viewer viewer, final Object e1, final Object e2) {

		if (!(e1 instanceof Contact) || !(e2 instanceof Contact)) {
			throw new IllegalArgumentException("Can only compare Contacts"); //$NON-NLS-1$
		}

		final Contact contact1 = (Contact) e1;
		final Contact contact2 = (Contact) e2;

		return contact1.getLastName().compareTo(contact2.getLastName());
	}
}