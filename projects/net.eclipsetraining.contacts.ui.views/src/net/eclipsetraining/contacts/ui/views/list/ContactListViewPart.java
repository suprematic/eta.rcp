package net.eclipsetraining.contacts.ui.views.list;

import net.eclipsetraining.contacts.core.Contact;
import net.eclipsetraining.contacts.core.ContactsRepositoryFactory;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.part.ViewPart;

public class ContactListViewPart extends ViewPart {

	private TableViewer contactsViewer;

	@Override
	public void createPartControl(Composite parent) {

		final Composite tableComposite = new Composite(parent, SWT.NONE);
		final TableColumnLayout tableColumnLayout = new TableColumnLayout();
		tableComposite.setLayout(tableColumnLayout);

		Table tbl = new Table(tableComposite, SWT.BORDER | SWT.FULL_SELECTION);
		tbl.setHeaderVisible(true);
		tbl.setLinesVisible(true);

		TableColumn tcFirstName = new TableColumn(tbl, SWT.LEFT);
		tcFirstName.setText("First Name");
		tcFirstName.setWidth(100);

		TableColumn tcLastName = new TableColumn(tbl, SWT.LEFT);
		tcLastName.setText("Last Name");
		tcLastName.setWidth(150);

		// Init TableViewer
		contactsViewer = new TableViewer(tbl);
		contactsViewer.setContentProvider(new ArrayContentProvider());
		contactsViewer.setComparator(new ContactViewerComparator());

		// First name column
		final TableViewerColumn tvcFirstName = new TableViewerColumn(contactsViewer, tcFirstName);
		tableColumnLayout.setColumnData(tvcFirstName.getColumn(), new ColumnWeightData(40));
		tvcFirstName.setLabelProvider(new ColumnLabelProvider() {

			@Override
			public String getText(final Object element) {
				return ((Contact) element).getFirstName();
			}
		});

		// Last name column
		final TableViewerColumn tvcLastName = new TableViewerColumn(contactsViewer, tcLastName);
		tableColumnLayout.setColumnData(tvcLastName.getColumn(), new ColumnWeightData(60));
		tvcLastName.setLabelProvider(new ColumnLabelProvider() {

			@Override
			public String getText(final Object element) {
				return ((Contact) element).getLastName();
			}
		});

		getSite().setSelectionProvider(contactsViewer);

		createContextMenu();

		// Finally set input
		refreshContacts();

	}

	private void createContextMenu() {
		MenuManager mgr = new MenuManager();
		Menu menu = mgr.createContextMenu(contactsViewer.getControl());
		contactsViewer.getControl().setMenu(menu);

		getViewSite().registerContextMenu("net.eclipsetraining.contacts.ui.view.list", mgr, contactsViewer);

	}

	void refreshContacts() {

		Object contacts = ContactsRepositoryFactory.getContactsRepository().getAllContacts();

		contactsViewer.setInput(contacts);
	}

	@Override
	public void setFocus() {
		contactsViewer.getTable().setFocus();
	}
}
