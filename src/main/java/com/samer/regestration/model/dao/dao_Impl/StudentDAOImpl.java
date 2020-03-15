package com.samer.regestration.model.dao.dao_Impl;

import com.samer.regestration.model.dao.StudentDAO;
import com.samer.regestration.model.entity.Student;
import com.samer.regestration.model.utils.DataSourcePool;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAOImpl implements StudentDAO {
    private DataSourcePool pool = new DataSourcePool("jdbc:mysql://localhost/student_db",
            "root", "root@JEA");

    public Student findStudentById(String id) {
        String statement = String.format("select * from student where id=%s", id);
        return selectStudent(statement);
    }

    public Student findStudentByEmail(String email) {
        String statement = String.format("SELECT * FROM student where email ='%s'", email);
        return selectStudent(statement);
    }

    public int save(Student student) {
        String statement = "insert into student(id,firstName,lastName,email,password,joinYear)" +
                "value(?,?,?,?,?,?)";
        int numberOfRowEffected = 0;
        try {
            numberOfRowEffected = insertExecute(statement, student);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return numberOfRowEffected;
    }

    public int update(Student student) {
        String statement = "update  student set firstName=? , lastName=? ,  email=? ,  password=? , joinYear=? " +
                "where id = ?";
        int numberOfRowEffected = 0;
        try {
            numberOfRowEffected = updateExecute(statement, student);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return numberOfRowEffected;
    }

    private ResultSet getResultSet(String statement) throws SQLException {
        PreparedStatement statement1 = pool.getConnection().getConnection().prepareStatement(statement);
        ResultSet resultSet = statement1.executeQuery();
        return resultSet;
    }

    private Student selectStudent(String statement) {
        ResultSet resultSet;
        Student student1;
        try {
            resultSet = getResultSet(statement);
            resultSet.next();
            student1 = buildStudent(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return student1;
    }

    public Student buildStudent(ResultSet resultSet) throws SQLException {
        Student student = new Student();
        student.setId(resultSet.getString("id"));
        student.setFirstName(resultSet.getString("firstName"));
        student.setLastName(resultSet.getString("lastName"));
        student.setEmail(resultSet.getString("email"));
        student.setPassword(resultSet.getString("password"));
        student.setJoinYear(resultSet.getString("joinYear"));
        return student;
    }

    private int insertExecute(String query, Student student) throws SQLException {
        PreparedStatement preparedStatement = pool.getConnection().getConnection().prepareStatement(query);
        preparedStatement.setString(1, student.getId());
        preparedStatement.setString(2, student.getFirstName());
        preparedStatement.setString(3, student.getLastName());
        preparedStatement.setString(4, student.getEmail());
        preparedStatement.setString(5, student.getPassword());
        preparedStatement.setString(6, student.getJoinYear());
        return preparedStatement.executeUpdate();
    }

    private int updateExecute(String query, Student student) throws SQLException {
        PreparedStatement preparedStatement = pool.getConnection().getConnection().prepareStatement(query);
        preparedStatement.setString(6, student.getId());
        preparedStatement.setString(1, student.getFirstName());
        preparedStatement.setString(2, student.getLastName());
        preparedStatement.setString(3, student.getEmail());
        preparedStatement.setString(4, student.getPassword());
        preparedStatement.setString(5, student.getJoinYear());
        return preparedStatement.executeUpdate();
    }


}
