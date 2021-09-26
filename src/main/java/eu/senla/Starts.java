package eu.senla;

import eu.senla.ui.menu.Builder;
import eu.senla.ui.menu.MenuController;
import eu.senla.ui.menu.Navigator;

public class Starts {

    public static void main(String[] args) {

        Builder builder = new Builder();
        Navigator navigator = new Navigator();
        MenuController menuController = new MenuController(builder, navigator);
        menuController.run();

    }
}
