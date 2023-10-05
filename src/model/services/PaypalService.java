package model.services;

public class PaypalService implements OnlinePaymentService {

    public double interest(double amount, int months) {
        return amount * 0.01 * months;
    }

    public double paymentFee(double amount) {
        return amount * 0.02;
    }

}
