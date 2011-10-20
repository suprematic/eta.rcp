package net.eclipsetraining.contacts.ui.views.list;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.part.ViewPart;

public class ContactListViewPart extends ViewPart {

	private Table tbl;

	@Override
	public void createPartControl(Composite parent) {

		tbl = new Table(parent, SWT.NONE);
		tbl.setHeaderVisible(true);
		tbl.setLinesVisible(true);

		TableColumn tcFirstName = new TableColumn(tbl, SWT.LEFT);
		tcFirstName.setText("First Name");
		tcFirstName.setWidth(100);

		TableColumn tcLastName = new TableColumn(tbl, SWT.LEFT);
		tcLastName.setText("Last Name");
		tcLastName.setWidth(150);

	}

	@Override
	public void setFocus() {
		tbl.setFocus();
	}

}
