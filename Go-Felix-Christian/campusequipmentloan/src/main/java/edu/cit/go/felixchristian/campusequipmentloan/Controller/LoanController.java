package edu.cit.go.felixchristian.campusequipmentloan.Controller;

import edu.cit.go.felixchristian.campusequipmentloan.Model.Equipment;
import edu.cit.go.felixchristian.campusequipmentloan.Model.Loan;
import edu.cit.go.felixchristian.campusequipmentloan.Model.Student;
import edu.cit.go.felixchristian.campusequipmentloan.Service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    private final LoanService loanServ;

    @Autowired
    public LoanController(LoanService loanServ) {
        this.loanServ = loanServ;
    }

    @GetMapping
    public List<Loan> getAllLoans() {
        return loanServ.getAllLoans();
    }

    @PostMapping
    public Loan createLoan(@RequestBody Map<String, Object> body) {
        Long studentId = Long.valueOf(body.get("studentId").toString());
        Long equipmentId = Long.valueOf(body.get("equipmentId").toString());
        String startDateStr = (String) body.get("startDate");

        return loanServ.createLoan(studentId, equipmentId, startDateStr);
    }

    @PostMapping("/{id}/return")
    public Loan returnLoan(@PathVariable Long loanId, @RequestBody Map<String, String> body) {
        String returnDateStr = body.get("returnDate"); // e.g. "2025-09-15"
        return loanServ.returnLoan(loanId, returnDateStr);
    }
}
