package edu.cit.go.felixchristian.campusequipmentloan.Service;
import edu.cit.go.felixchristian.campusequipmentloan.Repository.LoanRepository;

import edu.cit.go.felixchristian.campusequipmentloan.Model.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LoanService {

    private final LoanRepository loanRepo;

    @Autowired
    public LoanService(LoanRepository loanRepo) {
        this.loanRepo = loanRepo;
    }

    public Loan saveLoan(Loan loan) {
        return loanRepo.save(loan);
    }

    public List<Loan> getAllLoans() {
        return loanRepo.findAll();
    }

    public Loan returnLoan(Long id) {
        Loan loan = loanRepo.findById(id).orElse(null);

        if (loan != null && !"RETURNED".equalsIgnoreCase(loan.getStatus())) {
            loan.setReturnDate(new Date()); // set current date as return date
            loan.setStatus("RETURNED");
            return loanRepo.save(loan);
        }
        return loan; // null if not found, or already returned
    }

}
