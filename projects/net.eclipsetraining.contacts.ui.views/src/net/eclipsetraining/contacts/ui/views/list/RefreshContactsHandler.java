package net.eclipsetraining.contacts.ui.views.list;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

public class RefreshContactsHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		try {
			ContactListViewPart contactsView = (ContactListViewPart) PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getActivePage().showView("net.eclipsetraining.contacts.ui.view.list");

			contactsView.refreshContacts();

		} catch (PartInitException e) {
			throw new ExecutionException("Can't find contacts view", e);
		}

		return null;
	}

}
