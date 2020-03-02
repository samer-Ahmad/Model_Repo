package com.samer.regestration.model.dao.dao_Impl;

import com.samer.regestration.model.dao.StudentDAO;
import com.samer.regestration.model.entity.Student;
import com.samer.regestration.model.utils.DataSourcePool;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAOImpl implements StudentDAO {
    DataSourcePool pool = new DataSourcePool();

    public Student findById(String id) throws SQLException {
        String statement = "select * from student where id ='" + id + "'";
        ResultSet resultSet = query(statement);

        Student student = new Student();

        student.setId(resultSet.getString("id"));
        student.setFirstName(resultSet.getString("firstName"));
        student.setLastName(resultSet.getString("lastName"));
        student.setEmail(resultSet.getString("email"));
        student.setPassword(resultSet.getString("password"));
        student.setJoinYear(resultSet.getInt("joinYear"));

        return student;
    }


    public Student findByEmail() {

    }

    public void save(Student student) {

    }

    public void update(Student student) {

    }

    public ResultSet query(String statement) throws SQLException {
        PreparedStatement statement1 = pool.getConnection("jdbc:mysql://localhost/student",
                "root", "root@JEA").getConnection().prepareStatement(statement);
        ResultSet resultSet = statement1.executeQuery();

        return resultSet;
    }
}
