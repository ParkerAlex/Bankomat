package eu.senla;

import eu.senla.dao.BankomatDao;
import eu.senla.dao.ClientDao;

import eu.senla.service.BankomatService;
import eu.senla.service.ClientService;


import java.time.LocalDate;

public class Facade {


    private ClientService clientService;
    private BankomatService bankomatService;

    private void init() {
        ClientDao clientDao = new ClientDao();
        BankomatDao bankomatDao = new BankomatDao();
        clientService = new ClientService(clientDao);
        bankomatService = new BankomatService(bankomatDao);
    }

    private Facade() {
    }

    private static Facade INSTANCE;

    public static Facade getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new Facade();
            INSTANCE.init();
        }
        return INSTANCE;
    }

    public void checkCard(String number){
        bankomatService.checkCard(number);
    }

    public void checkPasswordCard(int password){
        bankomatService.checkPasswordCard(password);
    }

    public void accountAmount() {
        bankomatService.accountAmount();
    }

    public void removeMoney(Integer money) {
        bankomatService.removeMoney(money);

    }

    public void increaseBalance(Integer money) {
        bankomatService.increaseBalance(money);
    }
}
