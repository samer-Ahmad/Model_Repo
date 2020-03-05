package com.samer.regestration.model.dao.dao_Impl;

import com.samer.regestration.model.dao.StudentDAO;
import com.samer.regestration.model.entity.Student;
import com.samer.regestration.model.utils.DataSourcePool;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAOImpl implements StudentDAO {
    DataSourcePool pool = new DataSourcePool();

    public Student findStudentById(String id) throws SQLException {
        String statement = "select * from student where id ='" + id + "'";
        ResultSet resultSet = getResultSet(statement);

        Student student = new Student();
        return getStudent(student, resultSet);
    }


    public Student findStudentByEmail(String email) throws SQLException {
        Student student1 = new Student();
        String statement = "select * from student where email ='" + email + "'";
        ResultSet resultSet = getResultSet(statement);
        return getStudent(student1, resultSet);
    }


    public void save(Student student) throws SQLException {
        String statement = "insert into student(id,firstName,lastName,email,password,joinYear)" +
                "value(?,?,?,?,?,?)";
        insertExecute(statement, student);

//        String statement = "insert into student value('" + student.getId() + "' , '"+student.getFirstName()+"' , ' "+
//                student.getLastName()+"' , '"+student.getEmail()+"' , '"+student.getPassword()+"' , '"+
//                student.getJoinYear()+"')";
    }

    public void update(Student student) throws SQLException {
        String statement = "update  student set firstName=? , lastName=? ,  email=? ,  password=? , joinYear=? " +
                "where id = ?";
        updateExecute(statement, student);
    }

    private ResultSet getResultSet(String statement) throws SQLException {
        PreparedStatement statement1 = pool.getConnection("jdbc:mysql://localhost/student_db",
                "root", "root@JEA").getConnection().prepareStatement(statement);
        ResultSet resultSet = statement1.executeQuery();

        return resultSet;
    }

    private Student getStudent(Student student, ResultSet resultSet) throws SQLException {
        resultSet.next();
        student.setId(resultSet.getString("id"));
        student.setFirstName(resultSet.getString("firstName"));
        student.setLastName(resultSet.getString("lastName"));
        student.setEmail(resultSet.getString("email"));
        student.setPassword(resultSet.getString("password"));
        student.setJoinYear(resultSet.getString("joinYear"));

        return student;
    }

    private void insertExecute(String query, Student student) throws SQLException {
        PreparedStatement preparedStatement = pool.getConnection("jdbc:mysql://localhost/student_db",
                "root", "root@JEA").getConnection().prepareStatement(query);
        preparedStatement.setString(1, student.getId());
        preparedStatement.setString(2, student.getFirstName());
        preparedStatement.setString(3, student.getLastName());
        preparedStatement.setString(4, student.getEmail());
        preparedStatement.setString(5, student.getPassword());
        preparedStatement.setString(6, student.getJoinYear());
        preparedStatement.executeUpdate();
    }

    private void updateExecute(String query, Student student) throws SQLException {
        PreparedStatement preparedStatement = pool.getConnection("jdbc:mysql://localhost/student_db",
                "root", "root@JEA").getConnection().prepareStatement(query);
        preparedStatement.setString(6, student.getId());
        preparedStatement.setString(1, student.getFirstName());
        preparedStatement.setString(2, student.getLastName());
        preparedStatement.setString(3, student.getEmail());
        preparedStatement.setString(4, student.getPassword());
        preparedStatement.setString(5, student.getJoinYear());
        preparedStatement.executeUpdate();
    }


}
