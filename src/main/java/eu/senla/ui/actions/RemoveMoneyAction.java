package eu.senla.ui.actions;

import eu.senla.ui.menu.IAction;

import java.util.Scanner;

public class RemoveMoneyAction extends AbstractAction {

    @Override
    public void execute() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("ENTER WITHDRAWAL AMOUNT OF MONEY:");
        Integer money = scanner.nextInt();
        facade.removeMoney(money);
    }
}
