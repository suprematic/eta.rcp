package net.eclipsetraining.contacts.ui.newwizard.internal;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class NewContactNamePage extends WizardPage {

	Text txtFirstName;

	Text txtLastName;

	protected NewContactNamePage(final String pageName) {
		super(pageName);
		setTitle("New Contact");
		setDescription("Let's add the contacts's basic contact information...");
	}

	public void createControl(final Composite parent) {
		final Composite cmp = new Composite(parent, SWT.NONE);
		cmp.setLayout(new GridLayout(2, false));

		final GridLayout gridLayout = new GridLayout(2, false);
		cmp.setLayout(gridLayout);

		txtFirstName = createText(cmp, "First name");
		txtLastName = createText(cmp, "Last name");

		final ModifyListener modifyListener = new ModifyListener() {

			public void modifyText(final ModifyEvent aE) {
				setPageComplete(validatePage());
			}
		};

		txtFirstName.addModifyListener(modifyListener);
		txtLastName.addModifyListener(modifyListener);

		setPageComplete(false);
		setControl(cmp);
	}

	private boolean validatePage() {

		final boolean isComplete = (txtFirstName.getText().length() > 0 && txtLastName.getText().length() > 0);

		if (!isComplete)
			setErrorMessage("Please fill in all input fields");
		else
			setErrorMessage(null);

		return isComplete;
	}

	private static Text createText(final Composite parent, final String labelText) {

		final Label label = new Label(parent, SWT.NONE);
		label.setText(labelText);

		final Text text = new Text(parent, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		return text;
	}
}
