package com.bib.ojt.system.web.controller.student;

import com.bib.ojt.system.bl.dto.StudentDTO;
import com.bib.ojt.system.bl.service.student.StudentService;
import com.bib.ojt.system.common.util.FileUploadUtil;
import com.bib.ojt.system.web.form.StudentForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Controller
//@RestController
public class StudentController {

    //DI
    @Autowired
    StudentService studentService;
    /*
    @GetMapping("/add")
    public ModelAndView getStudentRegistrationForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("student/addStudent"); //TODO 1
        modelAndView.addObject("studentForm", new StudentForm());//Form backing object 2
        return modelAndView;
    }

     */
// public ModelAndView getStudentRegistrationForm(StudentForm studentForm) throws IOException
    //        String fileName = StringUtils.cleanPath(Objects.requireNonNull(studentForm.getFile().getOriginalFilename()));
//        FileUploadUtil.saveFile(fileName,studentForm.getFile());
//        studentForm.setImage(fileName);
//        this.studentService.doAddStudent(studentForm);


        /* String fileName = StringUtils.cleanPath(Objects.requireNonNull(bookForm.getFile().getOriginalFilename()));
        FileUploadUtil.saveFile(fileName, bookForm.getFile());
        bookForm.setImage(fileName);
        this.bookService.addBook(bookForm);
        view.setViewName("redirect:/list");
        */
        @GetMapping("/add")
        public ModelAndView getStudentRegistrationForm()  {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("student/addStudent"); //TODO 1
        modelAndView.addObject("studentForm", new StudentForm());//Form backing object 2
        return modelAndView;
    }

    @PostMapping(value = "/submit")
    public ModelAndView addStudent(@ModelAttribute("studentForm") StudentForm studentForm) {
        ModelAndView modelAndView = new ModelAndView("redirect:/students");
        this.studentService.doAddStudent(studentForm);
        System.out.println("Form submitted...");
        return modelAndView;
    }

    @GetMapping("/students")
    public ModelAndView getStudentList() {
        ModelAndView modelAndView = new ModelAndView("student/studentList");
        List<StudentDTO> studentList = this.studentService.doGetStduentList();
        modelAndView.addObject("studentList", studentList);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView getStudent(@PathVariable("id") Integer studentId) {
        ModelAndView modelAndView = new ModelAndView("student/editStudent");
        StudentForm studentForm = this.studentService.doGetStudentById(studentId);
//        if (studentDTO == null)
        modelAndView.addObject("studentForm", studentForm);
        return modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView updateStudent(StudentForm studentForm) {
        ModelAndView modelAndView = new ModelAndView("redirect:/students");
        StudentForm oldStudent = this.studentService.doGetStudentById(studentForm.getStudentId());
        //        if (oldStudent == null)
        this.studentService.doUpdateStudent(studentForm);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteStudent(@PathVariable("id") Integer studentId) {
        ModelAndView modelAndView = new ModelAndView("redirect:/students");
        StudentForm oldStudent = this.studentService.doGetStudentById(studentId);
//        if (oldStudent == null)

       this.studentService.doDeleteStudent(studentId);
        return modelAndView;
    }
}