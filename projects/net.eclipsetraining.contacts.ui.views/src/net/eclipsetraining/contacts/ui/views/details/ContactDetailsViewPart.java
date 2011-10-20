package net.eclipsetraining.contacts.ui.views.details;

import java.text.SimpleDateFormat;

import net.eclipsetraining.contacts.core.Contact;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

public class ContactDetailsViewPart extends ViewPart {

	private final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MMM.yyyy"); //$NON-NLS-1$

	private ContactDetailsComposite cmp;

	@Override
	public void createPartControl(Composite parent) {
		cmp = new ContactDetailsComposite(parent, SWT.NONE);

		ISelectionService selectionService = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService();
		selectionService.addSelectionListener(new ISelectionListener() {

			@Override
			public void selectionChanged(IWorkbenchPart part, ISelection selection) {
				if (selection instanceof StructuredSelection) {
					Object selected = ((StructuredSelection) selection).getFirstElement();

					if (selected instanceof Contact) {
						Contact contact = (Contact) selected;
						displayDetails(contact);
					}
				}
			}

		});
	}

	private void displayDetails(Contact contact) {
		cmp.txtFirstName.setText(contact.getFirstName());
		cmp.txtLastName.setText(contact.getLastName());
		cmp.txtBirthdate.setText(contact.getBirthday() != null ? DATE_FORMAT.format(contact.getBirthday()) : ""); //$NON-NLS-1$

	}

	@Override
	public void setFocus() {
		cmp.txtFirstName.setFocus();

	}

}
