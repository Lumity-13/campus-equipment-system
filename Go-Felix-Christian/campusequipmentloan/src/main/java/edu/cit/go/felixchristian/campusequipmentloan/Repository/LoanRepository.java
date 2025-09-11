package edu.cit.go.felixchristian.campusequipmentloan.Repository;

import edu.cit.go.felixchristian.campusequipmentloan.Model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
    // Find all ongoing loans
    List<Loan> findByStatus(String status);

    // Find all loans by student
    List<Loan> findByStudentStudentId(Long studentId);
}
