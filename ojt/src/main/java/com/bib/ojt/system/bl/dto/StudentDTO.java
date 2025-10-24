package com.bib.ojt.system.bl.dto;

import com.bib.ojt.system.persistence.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private Integer studentId;
    private String name;
    private String email;
    private int age;
    private int gender;
    private String genderString;
    private String address;

    public StudentDTO(Student student){
        this.studentId = student.getStudentId();
        this.name = student.getName();
        this.email = student.getEmail();
        this.age = student.getAge();
        this.gender = student.getGender();
        this.genderString = student.getGender() == 0 ? "Male" : "Female";
        this.address = student.getAddress();
    }
}
