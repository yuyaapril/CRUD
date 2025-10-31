package com.bib.ojt.system.bl.dto;

import com.bib.ojt.system.persistence.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

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
    private String image;
    private MultipartFile file;

    public StudentDTO(Student student){
        this.studentId = student.getStudentId();
        this.name = student.getName();
        this.email = student.getEmail();
        this.age = student.getAge();
        this.gender = student.getGender();
        this.genderString = student.getGender() == 0 ? "Male" : "Female";
        this.address = student.getAddress();
        this.image = student.getImage();
//        this.file = student.getFile();
    }
}
