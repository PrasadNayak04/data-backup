package com.robosoft.library;

import java.time.LocalDate;
import java.util.Date;

public class LoanHistoryBorrower {
    private Borrower borrower;
    private LocalDate lendDate;

    public LoanHistoryBorrower(Borrower borrower, LocalDate lendDate) {
        this.borrower = borrower;
        this.lendDate = lendDate;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public void setBorrower(Borrower borrower) {
        this.borrower = borrower;
    }

    public LocalDate getLendDate() {
        return lendDate;
    }

    public void setLendDate(LocalDate lendDate) {
        this.lendDate = lendDate;
    }

    @Override
    public String toString() {
        return "Loan History Borrower {" +
                "borrower=" + borrower +
                ", lendDate=" + lendDate +
                '}';
    }
}
