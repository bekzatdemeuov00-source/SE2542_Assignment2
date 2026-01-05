package entities;

class Bank extends BankEntity {
    private java.util.List<Customer> customers;
    private java.util.List<Account> accounts;

    public Bank(String name) {
        super(name);
        this.customers = new java.util.ArrayList<>();
        this.accounts = new java.util.ArrayList<>();
    }

    public String getName() {
        return getId();
    }

    public int getCustomerCount() {
        return customers.size();
    }

    public void addCustomer(Customer c) {
        if (!customers.contains(c)) {
            customers.add(c);
        }
    }

    public void addAccount(Account acc) {
        if (!accounts.contains(acc)) {
            accounts.add(acc);
        }
    }

    public java.util.List<Account> getRichAccounts(double min) {
        return accounts.stream()
                .filter(a -> a.getBalance() > min)
                .toList();
    }

    public Customer findCustomer(String id) {
        return customers.stream()
                .filter(c -> c.getCustomerId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Account findAccount(String number) {
        return accounts.stream()
                .filter(a -> a.getNumber().equals(number))
                .findFirst()
                .orElse(null);
    }

    public java.util.List<Account> sortByBalance() {
        return accounts.stream()
                .sorted(java.util.Comparator.comparingDouble(Account::getBalance).reversed())
                .toList();
    }

    public java.util.List<Customer> sortByName() {
        return customers.stream()
                .sorted(java.util.Comparator.comparing(Customer::getName))
                .toList();
    }

    public double getTotalMoney() {
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
        return "Банк " + getId() + ", клиентов: " +
                customers.size() + ", счетов: " +
                accounts.size() + ", денег: " + getTotalMoney();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Bank)) return false;
        Bank b = (Bank) obj;
        return getId().equals(b.getId());
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(getId());
    }
}