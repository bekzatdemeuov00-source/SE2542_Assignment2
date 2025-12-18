package entities;

public class Bank {
    private String name;
    private int customers;

    public Bank(String name,int customers) {
        this.name = name;
        this.customers = customers;
    }

    public String getName() {
        return name;
    }

    public int getCustomers() {
        return customers;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCustomers(int customers) {
        this.customers = customers;
    }
    public void show(){System.out.println("Banks:" + name + ", Customers:" + customers);}
}
