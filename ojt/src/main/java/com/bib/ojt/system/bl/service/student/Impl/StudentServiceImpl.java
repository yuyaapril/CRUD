package com.bib.ojt.system.bl.service.student.Impl;

import com.bib.ojt.system.bl.dto.StudentDTO;
import com.bib.ojt.system.bl.service.student.StudentService;
import com.bib.ojt.system.persistence.dao.student.StudentRepository;
import com.bib.ojt.system.persistence.entity.Student;
import com.bib.ojt.system.web.form.StudentForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    /**
     * <h3>doGetStudentList</h3>
     * <p>Method for retrieving student list</p>
     * @return*/

    @Override
    public void doAddStudent(StudentForm studentForm) {
        Student student = new Student(studentForm);
        student.setDelFlag(Boolean.FALSE);
        student.setCreatedAt(new Date());
        studentRepository.save(student);
    }

    @Override
    public List<StudentDTO> doGetStduentList() {
        List<Student> students = studentRepository.findAll();
//        List<StudentForm> studentForms = new ArrayList<>();
//        for(Student student : students) {
//            studentForms.add(new StudentForm(student));
//        }
        List<StudentDTO> studentDTOS = students.stream().map(StudentDTO::new).toList();
        return studentDTOS;
    }
    @Override
    public StudentForm doGetStudentById(Integer studentId){
         Optional <Student> student = this.studentRepository.findById(studentId);
         return student.map(StudentForm::new).orElse(null);
//         if (student.isPresent()){
//             return new StudentDTO(student.get());
//         }
//         return null;
    }

    @Override
    public void doUpdateStudent(StudentForm studentForm) {
        Optional <Student> student = this.studentRepository.findById(studentForm.getStudentId());
        if (student.isPresent()){
            Student oldStudent = student.get();
            oldStudent.setName(studentForm.getName());
            oldStudent.setEmail(studentForm.getEmail());
            oldStudent.setAge(studentForm.getAge());
            oldStudent.setAddress(studentForm.getAddress());
            oldStudent.setUpdatedAt(new Date());
            studentRepository.saveAndFlush(oldStudent);
        }
    }

    @Override
    public void doDeleteStudent(Integer studentId) {
        Optional <Student> student = this.studentRepository.findById(studentId);
        if (student.isPresent()){
            Student oldStudent = student.get();
            oldStudent.setDelFlag(Boolean.TRUE);
            studentRepository.save(oldStudent);
        }

    }

    public List<Student> doGetAllStudents() {
        return studentRepository.findByDelFlagFalseOrDelFlagIsNull();
    }


}
