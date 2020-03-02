package com.samer.regestration.model.dao;

import com.samer.regestration.model.entity.Student;

import java.sql.SQLException;

public interface StudentDAO {
    Student findById(String id) throws SQLException;

    Student findByEmail();

    void save(Student student);

    void update(Student student);
}
