package edu.cit.go.felixchristian.campusequipmentloan.Repository;

import edu.cit.go.felixchristian.campusequipmentloan.Model.Loan;
import edu.cit.go.felixchristian.campusequipmentloan.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
    public List<Loan> findByStatus(String status);
    public List<Loan> findByStudentStudentId(Long studentId);
    public List<Loan> findByStudentAndStatus(Student student, String status);
}
