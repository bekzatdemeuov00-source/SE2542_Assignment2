package entities;

import java.util.Objects;

public class Account extends BankEntity {

    private String number;
    private double balance;
    private Customer owner;

    public Account(String number, double balance, Customer owner) {
        super(number);
        this.number = number;
        this.balance = balance;
        this.owner = owner;
    }

    public String getNumber() {
        return number;
    }

    public double getBalance() {
        return balance;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    public void deposit(double money) {
        if (money > 0) {
            balance += money;
        }
    }

    public void withdraw(double money) {
        if (money > 0 && money <= balance) {
            balance -= money;
        }
    }

    @Override
    public void show() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Счет " + number +
                ", баланс: " + balance +
                (owner != null ? ", владелец: " + owner.getName() : "");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Account)) return false;
        Account a = (Account) obj;
        return number.equals(a.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
