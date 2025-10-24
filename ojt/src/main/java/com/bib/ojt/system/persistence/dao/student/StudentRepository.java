package com.bib.ojt.system.persistence.dao.student;

import com.bib.ojt.system.persistence.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByDelFlagFalseOrDelFlagIsNull();

}
