package eu.senla.ui.actions;

import eu.senla.ui.menu.IAction;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

public class PasswordCardAction extends AbstractAction {

    public static Logger logger = Logger.getLogger(String.valueOf(NumberCardAction.class));

    @Override
    public void execute() {

        int password;
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("ENTER PASSWORD CARD IN FORMAT (XXXX):");
            password = scanner.nextInt();
        } catch (InputMismatchException ex) {
            logger.info("INCORRECT INPUT!");
            return;
        }

        facade.checkPasswordCard(password);
    }

}
