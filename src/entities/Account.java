package entities;

class Account extends BankEntity {
    private double balance;
    private Customer owner;

    public Account(String number, double balance) {
        super(number);
        this.balance = balance;
    }

    public Account(String number, double balance, Customer owner) {
        this(number, balance);
        this.owner = owner;
    }

    public String getNumber() {
        return getId();
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

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    @Override
    public void show() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Счет " + getId() + ", баланс: " + balance +
                (owner != null ? ", владелец: " + owner.getName() : "");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Account)) return false;
        Account acc = (Account) obj;
        return getId().equals(acc.getId());
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(getId());
    }
}
