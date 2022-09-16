package model.services;

import java.util.Calendar;
import java.util.Date;

import model.entities.ContractInterfaces;
import model.entities.Installment;

public class ContractService {

    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(ContractInterfaces contract, Integer months) {
        double basicQuota = contract.getTotalValue() / months;

        for (int i = 1; i <= months; i++) {
            Date date = addMonths(contract.getDate(), i);
            double updatedQuota = basicQuota + onlinePaymentService.monthFee(basicQuota, i);
            double totalQuota = updatedQuota + onlinePaymentService.paymentFee(updatedQuota);
            contract.addInstallment(new Installment(date, totalQuota));
        }
    }

    private Date addMonths(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, n);
        return cal.getTime();
    }
}
