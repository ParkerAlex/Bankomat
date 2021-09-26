package eu.senla.ui.actions;

import eu.senla.ui.menu.IAction;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

public class IncreaseBalanceAction extends AbstractAction {

    public static Logger logger = Logger.getLogger(String.valueOf(IncreaseBalanceAction.class));

    @Override
    public void execute() {

        Integer money;
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("ENTER THE AMOUNT TO REPLENISH THE BALANCE:");
             money = scanner.nextInt();
        } catch (InputMismatchException ex) {
            logger.info("INCORRECT INPUT!");
            return;
        }


        facade.increaseBalance(money);
    }
}
