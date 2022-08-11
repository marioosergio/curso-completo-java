package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.EmployeeList;

public class EmployeeSalaryList {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("How many employees will be registered? ");
		int n = sc.nextInt();

		List<EmployeeList> list = new ArrayList<>();

		for (int i = 1; i <= n; i++) {
			System.out.println();
			System.out.println("Employee #" + i);
			System.out.print("Id: ");
			Integer id = sc.nextInt();
			while (hasId(list, id)) {
				System.out.println("Id already taken! Try again: ");
				id = sc.nextInt();
			}
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salary: ");
			Double salary = sc.nextDouble();

			EmployeeList employee = new EmployeeList(id, name, salary);

			list.add(employee);
		}

		System.out.println();
		System.out.print("Enter the employee id that will have salary increase: ");
		int idSalary = sc.nextInt();

		EmployeeList emp = list.stream().filter(x -> x.getId() == idSalary).findFirst().orElse(null);

		if (emp == null) {
			System.out.println("This Id does not exist!");
		} else {
			System.out.print("Enter the percentage: ");
			double percent = sc.nextDouble();

			emp.increaseSalary(percent);
		}

		System.out.println();
		System.out.println("List of employees:");

		for (EmployeeList y : list) {
			System.out.println(y);
		}

		sc.close();
	}

	public static boolean hasId(List<EmployeeList> list, int id) {
		EmployeeList emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}

}
