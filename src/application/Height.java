package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Person;

public class Height {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Quantas pessoas serão digitadas? ");
		int n = sc.nextInt();

		Person[] vect = new Person[n];

		for (int i = 0; i < vect.length; i++) {
			sc.nextLine();
			System.out.printf("Dados da %sa pessoa:%n", i + 1);
			System.out.print("Nome: ");
			String name = sc.nextLine();
			System.out.print("Idade: ");
			int age = sc.nextInt();
			System.out.print("Altura: ");
			double height = sc.nextDouble();
			vect[i] = new Person(name, age, height);
			System.out.println();
		}

		double sumHeight = 0;
		int countAge = 0;
		for (int i = 0; i < vect.length; i++) {
			sumHeight += vect[i].getHeight();
			if (vect[i].getAge() < 16.0) {
				countAge++;
			}
		}

		double avgHeight = sumHeight / vect.length;
		double underAge = countAge * 100 / vect.length;

		System.out.printf("Altura media: %.2f%n", avgHeight);
		System.out.printf("Pessoas com menos de 16 anos: %.1f%%%n", underAge);

		for (int i = 0; i < vect.length; i++) {
			if (vect[i].getAge() < 16) {
				System.out.println(vect[i].getName());
			}
		}

		sc.close();

	}

}
