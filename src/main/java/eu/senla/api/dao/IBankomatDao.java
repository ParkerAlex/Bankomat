package eu.senla.api.dao;

public interface IBankomatDao {

    void checkCard(String number);

    void checkPasswordCard(int password);

    void accountAmount();

    void removeMoney(Integer money);

    void increaseBalance(Integer money);
}
