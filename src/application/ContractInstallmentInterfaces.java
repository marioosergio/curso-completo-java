package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.ContractInterfaces;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalTax;

public class ContractInstallmentInterfaces {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter contract data");
        System.out.print("Number: ");
        Integer number = sc.nextInt();
        System.out.print("Date (dd/MM/yyyy): ");
        Date date = sdf.parse(sc.next());
        System.out.print("Contract value: ");
        Double contractValue = sc.nextDouble();

        ContractInterfaces contracts = new ContractInterfaces(number, date, contractValue);

        System.out.print("Enter number of installments: ");
        int n = sc.nextInt();

        ContractService contractService = new ContractService(new PaypalTax());

        contractService.processContract(contracts, n);

        System.out.println("Installments:");

        for (Installment x : contracts.getInstallments()) {
            System.out.println(x);
        }

        sc.close();
    }

}
