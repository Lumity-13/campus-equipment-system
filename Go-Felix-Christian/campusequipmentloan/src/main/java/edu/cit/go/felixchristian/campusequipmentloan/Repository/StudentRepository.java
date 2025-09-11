package edu.cit.go.felixchristian.campusequipmentloan.Repository;

import edu.cit.go.felixchristian.campusequipmentloan.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    public Student findByName(String name);
}
