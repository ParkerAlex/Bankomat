package eu.senla.dao;

import eu.senla.api.dao.IBankomatDao;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class BankomatDao implements IBankomatDao {

    @Override
    public void checkCard(String number) {

        try (FileReader reader = new FileReader("numberCard.txt")) {
            char[] buf = new char[256];
            int c;
            while ((c = reader.read(buf)) > 0) {

                if (c < 256) {
                    buf = Arrays.copyOf(buf, c);
                }

                String s = String.valueOf(buf);

                if (s.equals(number)) {
                    System.out.println("CARD ENTERED CORRECT:");
                } else {
                    System.out.println("CARD NUMBER UNCORRECT:");
                    System.out.println("PICK UP THE CARD:");
                    System.exit(0);

                }

            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public void checkPasswordCard(int password) {

        int counter = 0;

        try (FileReader reader = new FileReader("passwordCard.txt")) {
            char[] buf = new char[256];
            int c;
            while ((c = reader.read(buf)) > 0) {

                if (c < 256) {
                    buf = Arrays.copyOf(buf, c);
                }

                String s = String.valueOf(buf);

                if (s.equals(password)) {
                    counter = 0;
                    System.out.println("PIN CODE CARD ENTERED CORRECT:");
                } else {
                    counter++;
                    if (counter == 1) {
                        System.out.println("PIN CODE CARD UNCORRECT, TWO ATTEMPTS LEFT:");
                    } else if (counter == 2) {
                        System.out.println("PIN CODE CARD UNCORRECT, ONE ATTEMPTS LEFT:");
                    } else if (counter >= 3) {
                        System.out.println("PIN CODE CARD UNCORRECT, YOUR CARD THE BLOCKED:");
                        System.out.println("PICK UP THE CARD:");
                        System.out.println();

                        System.exit(0);
                    }

                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void accountAmount() {

        ArrayList<String> money = new ArrayList<>(Arrays.asList());

        try {
            File file = new File("client.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {

                money.add(line);
                line = reader.readLine();
            }
            String price = money.get(0);
            System.out.println("ACCOUNT BALANCE = " + price);
            System.out.println();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void removeMoney(Integer money) {

        ArrayList<String> moneyClientInBankomat = new ArrayList<>(Arrays.asList());
        Integer residualAmount = 0;
        String priceMax = null;
        Integer newLimitMoney = 0;

        try {
            File file = new File("client.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {

                moneyClientInBankomat.add(line);
                line = reader.readLine();
            }
            String price = moneyClientInBankomat.get(0);
            priceMax = moneyClientInBankomat.get(1);
            String limitMoney = moneyClientInBankomat.get(2);

            Integer s = Integer.valueOf(price);
            Integer intLimitMoney = Integer.valueOf(limitMoney);

            if((money <= s) && (intLimitMoney >= money)) {
                residualAmount = s - money;
                System.out.println("TAKE THE MONEY");
                System.out.println("ACCOUNT BALANCE = " + residualAmount);
                System.out.println();

                Integer limitMoneyOld = Integer.valueOf(limitMoney);
                newLimitMoney = limitMoneyOld - money;
            }else{
                System.out.println("YOUR BALANCE AMOUNT EXCEEDS WITHDRAWAL AMOUNTS OR THE ATM IS OUT OF MONEY");
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileWriter writer = new FileWriter("client.txt", false);
            writer.flush();
            writer.write(residualAmount + System.getProperty("line.separator"));
            writer.write(priceMax + System.getProperty("line.separator"));
            writer.write(newLimitMoney + System.getProperty("line.separator"));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void increaseBalance(Integer money) {

        ArrayList<String> moneyClientInBankomat = new ArrayList<>(Arrays.asList());
        Integer residualAmount = 0;
        String priceMax = null;
        Integer newLimitMoney = 0;

        try {
            File file = new File("client.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {

                moneyClientInBankomat.add(line);
                line = reader.readLine();
            }
            String price = moneyClientInBankomat.get(0);
            priceMax = moneyClientInBankomat.get(1);
            String limitMoney = moneyClientInBankomat.get(2);

            Integer s = Integer.valueOf(price);
            Integer newPriceMax = Integer.valueOf(priceMax);

            if(money < newPriceMax) {
                residualAmount = s + money;
                System.out.println("TAKE THE MONEY");
                System.out.println("ACCOUNT BALANCE = " + residualAmount);
                System.out.println();

                Integer limitMoneyOld = Integer.valueOf(limitMoney);
                newLimitMoney = limitMoneyOld + money;
            }else{
                System.out.println("THE AMOUNT OF BALANCE REPLENISHMENT EXCEEDS 1,000,000");
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileWriter writer = new FileWriter("client.txt", false);
            writer.flush();
            writer.write(residualAmount + System.getProperty("line.separator"));
            writer.write(priceMax + System.getProperty("line.separator"));
            writer.write(newLimitMoney + System.getProperty("line.separator"));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
