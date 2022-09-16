package model.services;

public class PaypalTax implements OnlinePaymentService {

    private static final double PAYMENT_FEE = 0.02;
    private static final double MONTHLY_FEE = 0.01;

    @Override
    public double paymentFee(double amount) {
        return amount * PAYMENT_FEE;
    }

    @Override
    public double monthFee(double amount, int months) {
        return amount * MONTHLY_FEE * months;
    }
}
