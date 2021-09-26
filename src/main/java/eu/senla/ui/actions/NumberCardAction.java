package eu.senla.ui.actions;


import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

public class NumberCardAction extends AbstractAction {

    public static Logger logger = Logger.getLogger(String.valueOf(NumberCardAction.class));

    @Override
    public void execute() {

        String number;
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("ENTER NUMBER CARD IN FORMAT (XXXX-XXXX-XXXX-XXXX):");
            number = scanner.next();
        } catch (InputMismatchException ex) {
            logger.info("INCORRECT INPUT!");
            return;
        }


        facade.checkCard(number);

    }

}
