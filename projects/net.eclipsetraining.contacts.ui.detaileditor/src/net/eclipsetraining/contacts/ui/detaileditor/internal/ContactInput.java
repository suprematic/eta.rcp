package net.eclipsetraining.contacts.ui.detaileditor.internal;

import net.eclipsetraining.contacts.core.Contact;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;

public class ContactInput implements IEditorInput {

	private final Contact contact;

	public ContactInput(final Contact contact) {
		this.contact = contact;
	}

	public boolean exists() {
		return true;
	}

	@SuppressWarnings("rawtypes")
	public Object getAdapter(final Class adapter) {
		return null;
	}

	public Contact getContact() {
		return contact;
	}

	public ImageDescriptor getImageDescriptor() {
		return ImageDescriptor.getMissingImageDescriptor();
	}

	public String getName() {
		return contact.getFirstName() + " " + contact.getLastName();
	}

	public String getToolTipText() {
		return "Contact";
	}

	public IPersistableElement getPersistable() {
		return null;
	}

}
