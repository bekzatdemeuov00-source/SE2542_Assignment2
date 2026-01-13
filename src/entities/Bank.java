package entities;

import java.util.*;

public class Bank extends BankEntity {

    private String name;
    private List<Customer> customers;
    private List<Account> accounts;

    public Bank(String name) {
        super(name);
        this.name = name;
        customers = new ArrayList<>();
        accounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addCustomer(Customer c) {
        if (!customers.contains(c)) {
            customers.add(c);
        }
    }

    public void addAccount(Account a) {
        if (!accounts.contains(a)) {
            accounts.add(a);
        }
    }

    public int getCustomerCount() {
        return customers.size();
    }

    public List<Account> getRichAccounts(double min) {
        List<Account> result = new ArrayList<>();
        for (Account a : accounts) {
            if (a.getBalance() > min) {
                result.add(a);
            }
        }
        return result;
    }

    public Customer findCustomer(String id) {
        for (Customer c : customers) {
            if (c.getCustomerId().equals(id)) return c;
        }
        return null;
    }

    public Account findAccount(String number) {
        for (Account a : accounts) {
            if (a.getNumber().equals(number)) return a;
        }
        return null;
    }

    public List<Account> sortByBalance() {
        List<Account> sorted = new ArrayList<>(accounts);
        sorted.sort((a1, a2) -> Double.compare(a2.getBalance(), a1.getBalance()));
        return sorted;
    }

    public double getTotalMoney() {
        double sum = 0;
        for (Account a : accounts) {
            sum += a.getBalance();
        }
        return sum;
    }

    @Override
    public void show() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Банк " + name +
                ", клиентов: " + customers.size() +
                ", счетов: " + accounts.size() +
                ", денег: " + getTotalMoney() + "₸";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Bank)) return false;
        Bank b = (Bank) obj;
        return name.equals(b.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
