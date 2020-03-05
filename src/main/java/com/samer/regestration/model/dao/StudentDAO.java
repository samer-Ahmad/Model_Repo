package com.samer.regestration.model.dao;

import com.samer.regestration.model.entity.Student;

import java.sql.SQLException;

public interface StudentDAO {
    Student findStudentById(String studentId) throws SQLException;

    Student findStudentByEmail(String studentEmail) throws SQLException;

    void save(Student student) throws SQLException;

    void update(Student student) throws SQLException;
}
