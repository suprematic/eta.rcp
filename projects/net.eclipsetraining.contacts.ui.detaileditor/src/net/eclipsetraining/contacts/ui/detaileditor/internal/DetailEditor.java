package net.eclipsetraining.contacts.ui.detaileditor.internal;

import net.eclipsetraining.contacts.core.Contact;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.ISaveablePart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;

public class DetailEditor extends EditorPart {

	private DetailComposite cmp;
	private boolean dirty;

	@Override
	public void init(final IEditorSite site, final IEditorInput input) throws PartInitException {
		if (!(input instanceof ContactInput)) {
			throw new PartInitException("Invalid input: must be a ContactInput");
		}
		setSite(site);
		setInput(input);
	}

	@Override
	public void createPartControl(final Composite parent) {
		final ModifyListener modifyListener = new ModifyListener() {

			public void modifyText(final ModifyEvent e) {
				dirty = true;
				firePropertyChange(ISaveablePart.PROP_DIRTY);
			}
		};

		cmp = new DetailComposite(parent, SWT.NONE);

		model2ui();

		cmp.txtFirstName.addModifyListener(modifyListener);
		cmp.txtLastName.addModifyListener(modifyListener);

	}

	private void model2ui() {
		Contact c = ((ContactInput) getEditorInput()).getContact();
		cmp.txtFirstName.setText(c.getFirstName());
		cmp.txtLastName.setText(c.getLastName());
		this.dirty = false;

		setPartName(getEditorInput().getName());
	}

	@Override
	public void doSave(final IProgressMonitor monitor) {
		ui2model();
		dirty = false;
		firePropertyChange(ISaveablePart.PROP_DIRTY);
		setPartName(getEditorInput().getName());
	}

	private void ui2model() {
		Contact c = ((ContactInput) getEditorInput()).getContact();
		c.setFirstName(cmp.txtFirstName.getText());
		c.setLastName(cmp.txtLastName.getText());
	}

	@Override
	public boolean isDirty() {
		return dirty;
	}

	@Override
	public void setFocus() {
		cmp.txtFirstName.setFocus();
	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

	@Override
	public void doSaveAs() {
		// noop
	}

}
