package com.bib.ojt.system.web.form;

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
public class StudentForm {
    Integer studentId;
    String name;
    String email;
    Integer age;
    int gender;
    String address;
    String image;
    MultipartFile file;


    public StudentForm(Student student) {
        this.studentId = student.getStudentId();
        this.name = student.getName();
        this.email = student.getEmail();
        this.age = student.getAge();
        this.gender = student.getGender();
        this.address = student.getAddress();
        this.image = student.getImage();
//        this.file = student.getFile();
    }


}
