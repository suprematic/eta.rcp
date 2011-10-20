package net.eclipsetraining.contacts.ui.application.internal.application;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(final IPageLayout layout) {
		layout.setEditorAreaVisible(true);
	}
}
