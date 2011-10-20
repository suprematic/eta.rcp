package net.eclipsetraining.contacts.ui.views.details;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

public class ContactDetailsViewPart extends ViewPart {

	private ContactDetailsComposite cmp;

	@Override
	public void createPartControl(Composite parent) {
		cmp = new ContactDetailsComposite(parent, SWT.NONE);

	}

	@Override
	public void setFocus() {
		cmp.txtFirstName.setFocus();

	}

}
