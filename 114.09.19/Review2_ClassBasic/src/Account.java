//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Account {
    private String accountNumber;
    private double balance;

    public double getBalance() {
        return balance;
    }
    public Account(String accountNumber,double initialBalance){
        this.setAccountNumber(accountNumber);
        try {
            this.setBalance(initialBalance);
        } catch (illegalArgumentException e) {
            System.out.println("初始餘額錯誤: " + e.getMessage()+",餘額設為0");
            this.balance = 0.0;
        }
        this.balance = 0.0;
    }

public String getAccountNumber () {
    return accountNumber;
}
    public void setBalance(double balance) {
        if(balance>0){
            this.balance = balance;
        }else{
            throw new IllegalArgumentException ("餘額必須為正數");
        }
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            throw new IllegalArgumentException ("存款金額必須為正數");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            throw new IllegalArgumentException ("提款金額不合法");
        }
    }
}