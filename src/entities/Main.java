package entities;

public class Main {
    static void main(String[] args) {
        Account acc1 = new Account("bogatiy", 50000);
        Account acc2 = new Account("bedniy", 30000);

        acc1.show();
        acc2.show();

        if (acc1.getBalance() > acc2.getBalance()) {
            System.out.println(acc1.getAccountNumber() + " has more money");
        } else {
            System.out.println(acc2.getAccountNumber() + " has more money");
        }

        System.out.println();

        Customer customer1 = new Customer("Aidos", "1111");
        Customer customer2 = new Customer("Assel", "2222");

        customer1.show();
        customer2.show();

        if (customer1.getId().equals(customer2.getId())) {
            System.out.println("Same customer");
        } else {
            System.out.println("Different customers");
        }

        System.out.println();

        Bank bank1 = new Bank("Halyk", 1000);
        Bank bank2 = new Bank("Kaspi", 1500);

        bank1.show();
        bank2.show();

        if (bank1.getCustomers() > bank2.getCustomers()) {
            System.out.println(bank1.getName() + " is bigger");
        } else {
            System.out.println(bank2.getName() + " is bigger");
        }
    }
}