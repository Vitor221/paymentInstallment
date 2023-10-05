package model.services;

import model.entities.Contract;
import model.entities.Installment;

import java.time.LocalDate;

public class ContractService {

    private OnlinePaymentService paymentService;

    public ContractService(OnlinePaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void processContract(Contract contract, int month) {

        double totalValue = contract.getTotalValue() / month;

        for(int i = 1; i <= month; i++) {
            LocalDate dueDate = contract.getDate().plusMonths(i);
            double interest = paymentService.interest(totalValue, i);
            double fee = paymentService.paymentFee(totalValue + interest);
            double installmentTotal = totalValue + interest + fee;

            contract.getInstallments().add(new Installment(dueDate, installmentTotal));
        }

    }
}
