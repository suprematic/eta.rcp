package net.eclipsetraining.contacts.core.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import net.eclipsetraining.contacts.core.Contact;
import net.eclipsetraining.contacts.core.IContactsRepository;

public class DummyContactsRepository implements IContactsRepository {

	private final Collection<Contact> contacts = Collections
			.synchronizedCollection(new ArrayList<Contact>());

	public DummyContactsRepository() {

		final Contact contact = new Contact();
		contact.setFirstName("Max");
		contact.setLastName("Mustermann");
		contact.setStreet("Ludwigstraße 1");
		contact.setZip("80539");
		contact.setCity("München");
		contact.setState("Bayern");
		contact.setCountry("Deutschland");
		contact.setEmail("max.mustermann@eclipse-training.net");
		contact.setPhone("+49 89 123999");
		contacts.add(contact);

		Contact contact2 = new Contact();
		contact2.setFirstName("John");
		contact2.setLastName("Doe");
		contact2.setStreet("526 West 26th Street");
		contact2.setZip("10001");
		contact2.setCity("New York");
		contact2.setState("New York");
		contact2.setCountry("United States of America");
		contact2.setEmail("john.doe@eclipse-training.net");
		contact2.setPhone("+1 646 123 4567");
		contacts.add(contact2);

		Contact contact3 = new Contact();
		contact3.setFirstName("Urs");
		contact3.setLastName("Müller");
		contact3.setStreet("Bubenbergplatz 5");
		contact3.setZip("3001");
		contact3.setCity("Bern");
		contact3.setState("Bern");
		contact3.setCountry("Schweiz");
		contact3.setEmail("urs.mueller@eclipse-training.net");
		contact3.setPhone("+41 31 1234567");
		contacts.add(contact3);
	}

	public void addContact(final Contact contact) {
		contacts.add(contact);
	}

	public Collection<Contact> getAllContacts() {
		return Collections.unmodifiableCollection(contacts);
	}

	public void removeContact(final Contact contact) {
		contacts.remove(contact);
	}
}
