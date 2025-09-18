package edu.cit.go.felixchristian.campusequipmentloan.Model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "loan")

public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanId;

    @ManyToOne
    @JoinColumn(name = "equipment_id")
    private Equipment equipment;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    private LocalDate startDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private String status;
    private Double penaltyAmount = 0.0;

    public Loan() {
        super();
    }

    public Loan(Long loanId, Equipment equipment, Student student, LocalDate startDate, LocalDate dueDate, LocalDate returnDate, String status, Double penaltyAmount) {
        this.loanId = loanId;
        this.equipment = equipment;
        this.student = student;
        this.startDate = startDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.status = status;
        this.penaltyAmount = penaltyAmount;
    }

    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getPenaltyAmount() {
        return penaltyAmount;
    }

    public void setPenaltyAmount(Double penaltyAmount) {
        this.penaltyAmount = penaltyAmount;
    }
}
