package net.eclipsetraining.contacts.client.internal;

import java.util.Collection;

import net.eclipsetraining.contacts.core.Contact;
import net.eclipsetraining.contacts.core.ContactsRepositoryFactory;
import net.eclipsetraining.contacts.core.IContactsRepository;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	public void start(final BundleContext context) throws Exception {
		final IContactsRepository contactsRepository = ContactsRepositoryFactory
				.getContactsRepository();
		Collection<Contact> allContacts = contactsRepository.getAllContacts();
		System.out.println("Total contacts: " + allContacts.size());
		for (final Contact contact : allContacts) {
			System.out.println("\t" + contact.getFirstName());
		}
	}

	public void stop(final BundleContext context) throws Exception {
		// noop
	}
}
