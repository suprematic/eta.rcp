package net.eclipsetraining.contacts.ui.detaileditor.internal;

import net.eclipsetraining.contacts.core.Contact;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;

public class EditContactHandler extends AbstractHandler implements IHandler {

	public Object execute(final ExecutionEvent event) throws ExecutionException {

		final ISelection currentSelection = HandlerUtil.getCurrentSelection(event);
		if (!currentSelection.isEmpty()) {
			if (currentSelection instanceof IStructuredSelection) {

				final Object element = ((IStructuredSelection) currentSelection).getFirstElement();
				final IWorkbenchPart activePart = HandlerUtil.getActivePart(event);
				if (activePart != null && element instanceof Contact) {

					final Contact contact = (Contact) element;
					try {
						IWorkbenchPage page = activePart.getSite().getPage();
						page.openEditor(new ContactInput(contact),
								"net.eclipsetraining.contacts.ui.detaileditor.editors.detail");
					} catch (final PartInitException e) {
						throw new ExecutionException("Cannot open the contact detail editor", e);
					}
				}
			}
		}
		return null;
	}
}
