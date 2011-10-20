package net.eclipsetraining.contacts.ui.detaileditor.internal;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class DetailComposite extends Composite {

	final Text txtFirstName;
	final Text txtLastName;

	public DetailComposite(Composite parent, int style) {
		super(parent, style);

		new Label(this, SWT.NONE).setText("First Name");
		txtFirstName = new Text(this, SWT.BORDER);

		new Label(this, SWT.NONE).setText("Last Name");
		txtLastName = new Text(this, SWT.BORDER);

		this.setLayout(new GridLayout(2, false));

		GridDataFactory gdfGrab = GridDataFactory.fillDefaults().grab(true, false);
		txtFirstName.setLayoutData(gdfGrab.create());
		txtLastName.setLayoutData(gdfGrab.create());

	}
}
