package entities;

class Main {
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

        java.util.List<BankEntity> list =
                java.util.Arrays.asList(acc1, amir, kaspi);

        for (BankEntity e : list) {
            e.show();
        }
    }
}
