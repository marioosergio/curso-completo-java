package model.services;

public interface OnlinePaymentService {

    double paymentFee(double amount);

    double monthFee(double amount, int months);

}
