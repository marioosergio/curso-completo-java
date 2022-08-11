package entities;

public class Account {

	private int accNumber;
	private String accName;
	private double balance;

	public Account(int accNumber, String accName) {
		this.accNumber = accNumber;
		this.accName = accName;
	}

	public Account(int accNumber, String accName, double initialDeposit) {
		this.accNumber = accNumber;
		this.accName = accName;
		deposit(initialDeposit);
	}

	public int getAccNumber() {
		return accNumber;
	}

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public double getBalance() {
		return balance;
	}

	public void deposit(double amount) {
		balance += amount;
	}

	public void withdraw(double amount) {
		balance -= amount + 5.00;
	}

	@Override
	public String toString() {
		return "Account " + accNumber + ", Holder: " + accName + ", Balance: $ " + String.format("%.2f", balance);
	}

}
