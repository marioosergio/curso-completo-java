package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;

public class BankAccunt {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		Account account;

		System.out.print("Enter account number: ");
		int accNumber = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter account holder: ");
		String accName = sc.nextLine();

		System.out.print("Is there an initial deposit (y/n)? ");
		char answer = sc.next().charAt(0);

		if (answer == 'y') {
			System.out.print("\nEnter initial deposit value: ");
			double initialDeposit = sc.nextDouble();
			account = new Account(accNumber, accName, initialDeposit);
		}

		else {
			account = new Account(accNumber, accName);
		}

		System.out.println("\nAccount data:");
		System.out.println(account);

		System.out.print("\nEnter a deposit value: ");
		double deposit = sc.nextDouble();
		account.deposit(deposit);

		System.out.println("\nUpdated Account data:");
		System.out.println(account);

		System.out.print("\nEnter a wihdraw value: ");
		double withdraw = sc.nextDouble();
		account.withdraw(withdraw);

		System.out.println("\nUpdated Account data:");
		System.out.println(account);

		sc.close();

	}

}
