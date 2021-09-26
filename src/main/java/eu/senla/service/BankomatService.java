package eu.senla.service;

import eu.senla.api.dao.IBankomatDao;


public class BankomatService {

    private final IBankomatDao bankomatDao;

    public BankomatService(IBankomatDao bankomatDao) {this.bankomatDao = bankomatDao;
    }

    public void checkCard(String number) {
        bankomatDao.checkCard(number);
    }

    public void checkPasswordCard(int password) {
        bankomatDao.checkPasswordCard(password);
    }

    public void accountAmount() {
        bankomatDao.accountAmount();
    }

    public void removeMoney(Integer money) {
        bankomatDao.removeMoney(money);
    }

    public void increaseBalance(Integer money) {
        bankomatDao.increaseBalance(money);
    }
}
