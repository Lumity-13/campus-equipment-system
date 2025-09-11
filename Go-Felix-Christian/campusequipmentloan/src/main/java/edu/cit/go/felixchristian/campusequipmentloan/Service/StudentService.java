package edu.cit.go.felixchristian.campusequipmentloan.Service;

import edu.cit.go.felixchristian.campusequipmentloan.Model.Student;
import edu.cit.go.felixchristian.campusequipmentloan.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    StudentRepository studRepo;

    @Autowired
    public StudentService(StudentRepository studRepo) {
        this.studRepo = studRepo;
    }

    public Student postStudent(Student stud) {
        return studRepo.save(stud);
    }
}
