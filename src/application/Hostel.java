package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Rooms;

public class Hostel {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("How many rooms will be rented? ");
		int n = sc.nextInt();

		Rooms[] vect = new Rooms[10];

		for (int i = 1; i <= n; i++) {
			System.out.println("\nRent #" + i + ":");
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Email: ");
			String email = sc.nextLine();
			System.out.print("Room: ");
			int room = sc.nextInt();
			vect[room] = new Rooms(name, email);
		}

		System.out.println("\nBusy rooms:");

		for (int i = 0; i < vect.length; i++) {
			if (vect[i] != null) {
				System.out.println(i + ": " + vect[i]);
			}
		}

		sc.close();

	}

}
