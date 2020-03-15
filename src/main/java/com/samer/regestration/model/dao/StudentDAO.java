package com.samer.regestration.model.dao;

import com.samer.regestration.model.entity.Student;

public interface StudentDAO {

    Student findStudentById(String studentId);

    Student findStudentByEmail(String studentEmail);

    int save(Student student);

    int update(Student student);
}
