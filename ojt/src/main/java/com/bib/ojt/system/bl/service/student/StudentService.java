package com.bib.ojt.system.bl.service.student;

import com.bib.ojt.system.bl.dto.StudentDTO;
import com.bib.ojt.system.web.form.StudentForm;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    void doAddStudent(StudentForm studentForm);

    List<StudentDTO> doGetStduentList();

    StudentForm doGetStudentById(Integer studentId);

    void doUpdateStudent(StudentForm studentForm);

    void doDeleteStudent(Integer studentId);
}
