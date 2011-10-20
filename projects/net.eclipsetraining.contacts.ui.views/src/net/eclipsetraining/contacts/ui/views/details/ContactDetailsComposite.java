package net.eclipsetraining.contacts.ui.views.details;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class ContactDetailsComposite extends Composite {

	final Text txtFirstName;
	final Text txtLastName;
	final Text txtBirthdate;

	public ContactDetailsComposite(Composite parent, int style) {
		super(parent, style);

		new Label(this, SWT.NONE).setText("First Name");
		txtFirstName = new Text(this, SWT.BORDER);
		txtFirstName.setEnabled(false);

		new Label(this, SWT.NONE).setText("Last Name");
		txtLastName = new Text(this, SWT.BORDER);
		txtLastName.setEnabled(false);

		new Label(this, SWT.NONE).setText("Birthdate");
		txtBirthdate = new Text(this, SWT.BORDER);
		txtBirthdate.setEnabled(false);

		this.setLayout(new GridLayout(2, false));

		GridDataFactory gdfGrab = GridDataFactory.fillDefaults().grab(true,
				false);
		txtFirstName.setLayoutData(gdfGrab.create());
		txtLastName.setLayoutData(gdfGrab.create());
		txtBirthdate.setLayoutData(gdfGrab.create());

	}

}
