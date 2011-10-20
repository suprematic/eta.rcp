package net.eclipsetraining.contacts.core;

import net.eclipsetraining.contacts.core.internal.DummyContactsRepository;

public class ContactsRepositoryFactory {

    private static final IContactsRepository CONTACTS_REPOSITORY = new DummyContactsRepository();

    public static IContactsRepository getContactsRepository() {
        return CONTACTS_REPOSITORY;
    }
}
