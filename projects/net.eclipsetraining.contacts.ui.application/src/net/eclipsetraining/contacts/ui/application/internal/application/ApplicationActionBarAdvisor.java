package net.eclipsetraining.contacts.ui.application.internal.application;

import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.actions.ContributionItemFactory;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

public class ApplicationActionBarAdvisor extends ActionBarAdvisor {

	private IWorkbenchAction actionQuit;
	private IWorkbenchAction actionAbout;
	private IWorkbenchAction actionNew;
	private IWorkbenchAction actionSave;
	private IWorkbenchAction actionSaveAll;
	private IWorkbenchAction actionPrefs;
	private IContributionItem shortlistViews;
	private IContributionItem shortlistPerspectives;

	public ApplicationActionBarAdvisor(final IActionBarConfigurer configurer) {
		super(configurer);
	}

	@Override
	protected void makeActions(final IWorkbenchWindow window) {
		actionNew = ActionFactory.NEW.create(window);
		actionNew.setText("&New");
		actionSave = ActionFactory.SAVE.create(window);
		actionSaveAll = ActionFactory.SAVE_ALL.create(window);
		actionQuit = ActionFactory.QUIT.create(window);
		actionAbout = ActionFactory.ABOUT.create(window);
		actionPrefs = ActionFactory.PREFERENCES.create(window);
		shortlistViews = ContributionItemFactory.VIEWS_SHORTLIST.create(window);
		shortlistPerspectives = ContributionItemFactory.PERSPECTIVES_SHORTLIST.create(window);
	}

	@Override
	protected void fillMenuBar(final IMenuManager menuBar) {
		MenuManager mgrFile = new MenuManager("&File", IWorkbenchActionConstants.M_FILE);
		mgrFile.add(actionNew);
		mgrFile.add(actionSave);
		mgrFile.add(actionSaveAll);
		mgrFile.add(new Separator());
		mgrFile.add(actionQuit);

		MenuManager mgrWindow = new MenuManager("&Window", IWorkbenchActionConstants.M_FILE);
		MenuManager mgrWindowViews = new MenuManager("Show &View");
		mgrWindowViews.add(shortlistViews);
		MenuManager mgrWindowPerspectives = new MenuManager("&Open Perspectives");
		mgrWindowPerspectives.add(shortlistPerspectives);
		mgrWindow.add(mgrWindowPerspectives);
		mgrWindow.add(mgrWindowViews);
		mgrWindow.add(new Separator());
		mgrWindow.add(actionPrefs);

		MenuManager mgrHelp = new MenuManager("&Help", IWorkbenchActionConstants.M_FILE);
		mgrHelp.add(actionAbout);

		menuBar.add(mgrFile);
		menuBar.add(mgrWindow);
		menuBar.add(mgrHelp);
	}

	@Override
	protected void fillCoolBar(ICoolBarManager coolBar) {
		ToolBarManager tbFile = new ToolBarManager(coolBar.getStyle());
		tbFile.add(actionNew);
		tbFile.add(actionSave);
		tbFile.add(actionSaveAll);

		coolBar.add(tbFile);

	}

}
