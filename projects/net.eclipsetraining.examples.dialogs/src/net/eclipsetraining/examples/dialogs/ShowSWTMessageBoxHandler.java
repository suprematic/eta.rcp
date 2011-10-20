package net.eclipsetraining.examples.dialogs;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

public class ShowSWTMessageBoxHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getShell();

		MessageBox mb = new MessageBox(shell, SWT.ICON_INFORMATION);
		mb.setText("MessageBox");
		mb.setMessage("This is an SWT message box.");
		int result = mb.open();

		System.out.println("Result=" + result);
		return null;
	}
}