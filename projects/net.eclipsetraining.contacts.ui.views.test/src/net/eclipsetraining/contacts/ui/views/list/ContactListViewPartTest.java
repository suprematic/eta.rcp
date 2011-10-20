package net.eclipsetraining.contacts.ui.views.list;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.junit.Test;

public class ContactListViewPartTest {

	@Test
	public void testOpenView() throws PartInitException {

		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();

		IViewPart view = page.showView("net.eclipsetraining.contacts.ui.view.list");

		assertNotNull(view);
		assertTrue(view instanceof ContactListViewPart);
	}

}
