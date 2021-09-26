package eu.senla.model;

public class Client {

    private long number;
    private int password;

    public Client(long number, int password) {
        this.number = number;
        this.password = password;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Bankomat{" +
                "number=" + number +
                ", password=" + password +
                '}';
    }
}
