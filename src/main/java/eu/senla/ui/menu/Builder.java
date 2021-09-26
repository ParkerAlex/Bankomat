package eu.senla.ui.menu;

import eu.senla.ui.actions.*;

public class Builder {

    private Menu rootMenu;

    public Menu getRootMenu() {
        return rootMenu;
    }

//    public Builder() {
//    }

    public void build() {

        Menu mainMenu = new Menu("MAIN MENU");
        Menu cardMenu = new Menu("CHECK CARD");
        Menu passwordMenu = new Menu("PASSWORD MENU");
        Menu cardCorrectMenu = new Menu("CARD CORRECT MENU");
        Menu settingsMenu = new Menu("MENU SETTINGS");

        mainMenu.addMenuItem(new MenuItem("INSERT CARD", new CardMenuAction(), cardMenu));
//        mainMenu.addMenuItem(new MenuItem("MENU SERVICE", new ServiceMenuAction(), serviceMenu));
//        mainMenu.addMenuItem(new MenuItem("MENU SETTINGS", new SettingsMenuAction(), settingsMenu));
        mainMenu.addMenuItem(new MenuItem("EXIT", new ExitAction(), mainMenu));

        cardMenu.addMenuItem(new MenuItem("FOR NEXT ENTER NUMBER CARD:", new NumberCardAction(), passwordMenu));
        cardMenu.addMenuItem(new MenuItem("EXIT IN MAIN MENU:", new MainMenuAction(), mainMenu));

        passwordMenu.addMenuItem(new MenuItem("FOR NEXT ENTER PASSWORD:", new PasswordCardAction(), cardCorrectMenu));
        passwordMenu.addMenuItem(new MenuItem("EXIT IN MAIN MENU:", new MainMenuAction(), mainMenu));

        cardCorrectMenu.addMenuItem(new MenuItem("ACCOUNT AMOUNT", new AccountAmountAction(), cardCorrectMenu));
        cardCorrectMenu.addMenuItem(new MenuItem("REMOVE MONEY", new RemoveMoneyAction(), cardCorrectMenu));
        cardCorrectMenu.addMenuItem(new MenuItem("INCREASE BALANCE", new IncreaseBalanceAction(), cardCorrectMenu));
        cardCorrectMenu.addMenuItem(new MenuItem("EXIT IN MAIN MENU:", new MainMenuAction(), mainMenu));

//        serviceMenu.addMenuItem(new MenuItem("Add SERVICE and PRICE", new AddServiceAction(), serviceMenu));
        settingsMenu.addMenuItem(new MenuItem("EXIT IN MAIN MENU:", new MainMenuAction(), mainMenu));

        this.rootMenu = mainMenu;
    }
}
