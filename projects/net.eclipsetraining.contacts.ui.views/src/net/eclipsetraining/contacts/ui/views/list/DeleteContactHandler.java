package net.eclipsetraining.contacts.ui.views.list;

import net.eclipsetraining.contacts.core.Contact;
import net.eclipsetraining.contacts.core.ContactsRepositoryFactory;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

public class DeleteContactHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();

		ISelection selection = HandlerUtil.getCurrentSelection(event);
		if (selection instanceof StructuredSelection) {
			Object selected = ((StructuredSelection) selection).getFirstElement();

			if (selected instanceof Contact) {
				Contact contact = (Contact) selected;

				if (MessageDialog.openQuestion(shell, "Delete Contact",
						"Do you want to delete " + contact.getFirstName() + "?")) {

					ContactsRepositoryFactory.getContactsRepository().removeContact(contact);

					// TODO the repository must be smart enough to inform all
					// interested parties that the contact has been deleted.
					// This could be done e.g. via listener-observer mechanism
				}
			}
		}

		return null;
	}
}
