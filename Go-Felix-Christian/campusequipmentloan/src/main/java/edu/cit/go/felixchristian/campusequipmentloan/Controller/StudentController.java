package edu.cit.go.felixchristian.campusequipmentloan.Controller;

import edu.cit.go.felixchristian.campusequipmentloan.Model.Student;
import edu.cit.go.felixchristian.campusequipmentloan.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    private final StudentService studServ;

    public StudentController(StudentService studServ) {
        this.studServ = studServ;
    }

    @PostMapping
    public Student postStudent(@RequestBody Student stud) {
        return studServ.postStudent(stud);
    }
}
