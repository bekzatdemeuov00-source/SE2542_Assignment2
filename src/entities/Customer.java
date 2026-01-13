package entities;

import java.util.*;

public class Customer extends BankEntity {
    private String name;
    private String customerId;
    private List<Account> accounts;
    public Customer(String name, String customerId) {
        super(customerId);
        this.name = name;
        this.customerId = customerId;
        this.accounts = new ArrayList<>();
    }
    public String getName() {return name;}
    public String getCustomerId() {return customerId;}
    public void addAccount(Account a) {
        if (!accounts.contains(a)) {
            accounts.add(a);
            a.setOwner(this);
        }
    }
    public double getTotalMoney() {
        double sum = 0;
        for (Account a : accounts) {
            sum += a.getBalance();
        }
        return sum;
    }
    @Override
    public void show() {System.out.println(this);}
    @Override
    public String toString() {
        return name + " (ID: " + customerId + "), счетов: " +
                accounts.size() + ", всего: " + getTotalMoney() + "₸";
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Customer)) return false;
        Customer c = (Customer) obj;
        return customerId.equals(c.customerId);
    }
    @Override
    public int hashCode() {
        return Objects.hash(customerId);
    }
}
