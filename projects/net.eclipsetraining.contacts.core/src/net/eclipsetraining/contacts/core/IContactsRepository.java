package net.eclipsetraining.contacts.core;

import java.util.Collection;

public interface IContactsRepository {

    void addContact(Contact contact);

    Collection<Contact> getAllContacts();

    void removeContact(Contact contact);
}
