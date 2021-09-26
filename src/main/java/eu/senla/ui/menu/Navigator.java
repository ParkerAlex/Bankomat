package eu.senla.ui.menu;

import java.util.List;

public class Navigator {

	private Menu currentMenu;

	public void setCurrentMenu(Menu currentMenu) {
		this.currentMenu = currentMenu;
	}

	public void printMenu() {
		System.out.println(currentMenu.getName() + ": ");
		List<MenuItem> items = currentMenu.getMenuItems();
		for (int i = 0; i < items.size(); i++) {
			System.out.println(i + ". " + items.get(i).getTitle());
		}
	}

	public void navigate(Integer index) {

		MenuItem item = currentMenu.getMenuItems().get(index);
		item.doAction();
		setCurrentMenu(item.getNextMenu());
	}

}
