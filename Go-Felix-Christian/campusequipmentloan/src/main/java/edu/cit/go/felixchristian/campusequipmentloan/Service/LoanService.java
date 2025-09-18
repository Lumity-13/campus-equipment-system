package edu.cit.go.felixchristian.campusequipmentloan.Service;
import edu.cit.go.felixchristian.campusequipmentloan.Model.Equipment;
import edu.cit.go.felixchristian.campusequipmentloan.Model.Student;
import edu.cit.go.felixchristian.campusequipmentloan.Repository.EquipmentRepository;
import edu.cit.go.felixchristian.campusequipmentloan.Repository.LoanRepository;

import edu.cit.go.felixchristian.campusequipmentloan.Model.Loan;
import edu.cit.go.felixchristian.campusequipmentloan.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class LoanService {

    private final LoanRepository loanRepo;
    private final StudentRepository studentRepo;
    private final EquipmentRepository equipmentRepo;

    @Autowired
    public LoanService(LoanRepository loanRepo, StudentRepository studentRepo, EquipmentRepository equipmentRepo) {
        this.loanRepo = loanRepo;
        this.studentRepo = studentRepo;
        this.equipmentRepo = equipmentRepo;
    }

    public Loan saveLoan(Loan loan) {
        return loanRepo.save(loan);
    }

    public List<Loan> getAllLoans() {
        return loanRepo.findAll();
    }

    public Loan createLoan(Long studentId, Long equipmentId, String startDateStr) {
        Student student = studentRepo.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Equipment equipment = equipmentRepo.findById(equipmentId)
                .orElseThrow(() -> new RuntimeException("Equipment not found"));

        // ✅ Rule: Max 2 active loans per student
        List<Loan> activeLoans = loanRepo.findByStudentAndStatus(student, "ACTIVE");
        if (activeLoans.size() >= 2) {
            throw new RuntimeException("Student already has 2 active loans.");
        }

        LocalDate startDate = (startDateStr != null)
                ? LocalDate.parse(startDateStr)
                : LocalDate.now();

        Loan loan = new Loan();
        loan.setStudent(student);
        loan.setEquipment(equipment);
        loan.setStartDate(startDate);
        loan.setDueDate(startDate.plusDays(7));
        loan.setStatus("ACTIVE");
        loan.setPenaltyAmount(0.0);

        return loanRepo.save(loan);
    }

    public Loan returnLoan(Long loanId, String returnDateStr) {
        Loan loan = loanRepo.findById(loanId)
                .orElseThrow(() -> new RuntimeException("Loan not found"));

        LocalDate returnDate = (returnDateStr != null)
                ? LocalDate.parse(returnDateStr)
                : LocalDate.now();

        loan.setReturnDate(returnDate);

        if (loan.getReturnDate().isAfter(loan.getDueDate())) {
            long daysLate = ChronoUnit.DAYS.between(loan.getDueDate(), loan.getReturnDate());
            double penalty = daysLate * 50.0;
            loan.setPenaltyAmount(penalty);
            loan.setStatus("OVERDUE");
        } else {
            loan.setStatus("RETURNED");
        }

        return loanRepo.save(loan);
    }
}
