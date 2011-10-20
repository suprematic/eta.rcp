package net.eclipsetraining.contacts.ui.newwizard.internal;

import java.util.Date;

import net.eclipsetraining.contacts.core.Contact;
import net.eclipsetraining.contacts.core.ContactsRepositoryFactory;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

public class NewContactWizard extends Wizard implements INewWizard {

	private NewContactNamePage pageContactName;

	@Override
	public void addPages() {
		addPage(pageContactName);

	}

	public void init(final IWorkbench workbench, final IStructuredSelection selection) {
		setWindowTitle("New Contact Wizard");
		pageContactName = new NewContactNamePage("new_contact_name_page");
	}

	@Override
	public boolean performFinish() {
		final Contact contact = new Contact();

		contact.setFirstName(pageContactName.txtFirstName.getText());
		contact.setLastName(pageContactName.txtLastName.getText());
		contact.setBirthday(new Date());

		ContactsRepositoryFactory.getContactsRepository().addContact(contact);

		return true;
	}
}
