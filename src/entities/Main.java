package entities;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Bank kaspi = new Bank("Каспи");
        Bank halyk = new Bank("Халык");

        Customer amir = new Customer("Амир", "001");
        Customer dana = new Customer("Дана", "002");
        Customer beka = new Customer("Бека", "003");

        Account acc1 = new Account("KZ123", 100000, amir);
        Account acc2 = new Account("KZ456", 5000, dana);
        Account acc3 = new Account("KZ789", 250000, amir);
        Account acc4 = new Account("KZ999", 500, beka);

        amir.addAccount(acc1);
        amir.addAccount(acc3);
        dana.addAccount(acc2);
        beka.addAccount(acc4);

        kaspi.addCustomer(amir);
        kaspi.addCustomer(dana);
        kaspi.addAccount(acc1);
        kaspi.addAccount(acc2);

        halyk.addCustomer(beka);
        halyk.addAccount(acc3);
        halyk.addAccount(acc4);

        List<BankEntity> stuff = new ArrayList<>();
        stuff.add(acc1);
        stuff.add(amir);
        stuff.add(kaspi);

        for (BankEntity b : stuff) {
            b.show();
        }

        System.out.println(acc1);
        System.out.println(dana);
        System.out.println(halyk);

        Customer amir2 = new Customer("Амир", "001");
        System.out.println(amir.equals(amir2));
        System.out.println(amir.hashCode() == amir2.hashCode());

        for (Account a : kaspi.getRichAccounts(50000)) {
            System.out.println(a);
        }

        System.out.println(kaspi.findAccount("KZ123"));
        System.out.println(kaspi.findCustomer("002"));

        for (Account a : kaspi.sortByBalance()) {
            System.out.println(a);
        }

        acc4.deposit(10000);
        acc4.withdraw(5000);
        System.out.println(acc4);

        kaspi.show();
        halyk.show();
    }
}
