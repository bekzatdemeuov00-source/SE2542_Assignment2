package entities;

class Customer extends BankEntity {
    private String name;
    private java.util.List<Account> accounts;

    public Customer(String name, String id) {
        super(id);
        this.name = name;
        this.accounts = new java.util.ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getCustomerId() {
        return getId();
    }

    public java.util.List<Account> getAccounts() {
        return new java.util.ArrayList<>(accounts);
    }

    public void addAccount(Account acc) {
        if (!accounts.contains(acc)) {
            accounts.add(acc);
            acc.setOwner(this);
        }
    }

    public double getTotalBalance() {
        return accounts.stream()
                .mapToDouble(Account::getBalance)
                .sum();
    }

    @Override
    public void show() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return name + " (ID: " + getId() + "), счетов: " +
                accounts.size() + ", всего денег: " + getTotalBalance();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Customer)) return false;
        Customer c = (Customer) obj;
        return getId().equals(c.getId());
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(getId());
    }
}
