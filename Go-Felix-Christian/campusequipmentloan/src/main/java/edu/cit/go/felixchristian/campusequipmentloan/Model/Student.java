package edu.cit.go.felixchristian.campusequipmentloan.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    private String studentNo;
    private String name;
    private String email;

    public Student() {
        super();
    }

    public Student(Long studentId, String studentNo, String name, String email) {
        super();
        this.studentId = studentId;
        this.studentNo = studentNo;
        this.name = name;
        this.email = email;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
