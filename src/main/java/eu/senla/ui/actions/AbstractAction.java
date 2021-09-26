package eu.senla.ui.actions;

import eu.senla.Facade;
import eu.senla.ui.menu.IAction;

public abstract class AbstractAction implements IAction {

	protected Facade facade = Facade.getINSTANCE();
}
