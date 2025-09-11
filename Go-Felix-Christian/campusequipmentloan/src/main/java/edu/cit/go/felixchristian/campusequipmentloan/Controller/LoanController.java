package edu.cit.go.felixchristian.campusequipmentloan.Controller;

import edu.cit.go.felixchristian.campusequipmentloan.Model.Loan;
import edu.cit.go.felixchristian.campusequipmentloan.Service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    private final LoanService loanServ;

    @Autowired
    public LoanController(LoanService loanServ) {
        this.loanServ = loanServ;
    }

    @PostMapping
    public Loan saveLoan(@RequestBody Loan loan) {
        return loanServ.saveLoan(loan);
    }

    @GetMapping
    public List<Loan> getAllLoans() {
        return loanServ.getAllLoans();
    }

    @PostMapping("/{id}/return")
    public Loan returnLoan(@PathVariable Long id) {
        return loanServ.returnLoan(id);
    }
}
