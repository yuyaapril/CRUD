package com.bib.ojt.system.persistence.entity;

import com.bib.ojt.system.web.form.StudentForm;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "student_list")
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer studentId;

    String name;

    String email;

    Integer age;

    int gender;

    String address;

    Boolean delFlag;

    Date createdAt;

    Date updatedAt;

    String image;

//    MultipartFile file;

    //Student <= StudentForm
    public Student(StudentForm studentForm) {
        this.name = studentForm.getName();
        this.email = studentForm.getEmail();
        this.age = studentForm.getAge();
        this.gender = studentForm.getGender();
        this.address = studentForm.getAddress();
        this.image = studentForm.getImage();
//        this.file = studentForm.getFile();
    }
}
