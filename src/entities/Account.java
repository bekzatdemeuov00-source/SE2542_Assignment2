package entities;

public class Account {
    private String accountNumber;
    private int balance;

    public Account(String accountNumber,int balance){
        this.accountNumber=accountNumber;
        this.balance=balance;
    }

    public String getAccountNumber() {return accountNumber;}

    public int getBalance() {
        return balance;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
    public void show(){System.out.println("entities.Account: " + accountNumber + ", Balance: " + balance);}
}
