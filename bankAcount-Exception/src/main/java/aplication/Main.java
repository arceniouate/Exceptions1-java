package aplication;

import entites.Account;

import javax.xml.transform.sax.SAXSource;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws RuntimeException {
        Scanner l=new Scanner(System.in);



            System.out.println("Enter the date Acount ");
            System.out.println("Number");
            int n = l.nextInt();
            System.out.println("Holder");
            String name = l.next();
            System.out.println("Inicial Balance");
            double balance = l.nextDouble();
            System.out.println("Withdraw limit:");
            double lim = l.nextDouble();
            Account account = new Account(n, name, balance, lim);
            System.out.println("Enter amount for withdraw");
            double amout = l.nextDouble();
        try {
            account.Wthidraw(amout);

            System.out.println(account.getBalance());
        } catch (Exception e) {
            System.out.println("Withdraw error: " + e.getMessage());
        }


    }
}
