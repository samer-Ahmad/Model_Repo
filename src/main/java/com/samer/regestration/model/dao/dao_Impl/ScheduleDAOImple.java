package com.samer.regestration.model.dao.dao_Impl;

import com.samer.regestration.model.dao.ScheduleDAO;
import com.samer.regestration.model.entity.Course;
import com.samer.regestration.model.entity.Schedule;
import com.samer.regestration.model.entity.Student;
import com.samer.regestration.model.utils.DataSourcePool;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDAOImple implements ScheduleDAO {
    private DataSourcePool pool = new DataSourcePool("jdbc:mysql://localhost/student_db",
            "root", "root@JEA");

    @Override
    public int save(Schedule schedule) {
        if (schedule == null) {
            return -1;
        }
        String statement = String.format("insert into schedule (studentId,courseId) value(%s,%s)",
                schedule.getStudentId(), schedule.getCourseId());
        int numberOfRowEffected;
        try {
            numberOfRowEffected = Execute(statement);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return numberOfRowEffected;
    }

    @Override
    public int update(Schedule schedule) {
        if (schedule == null) {
            return -1;
        }
        String statement = String.format("update schedule set studentId=%s ,courseId=%s where studentId=%s",
                schedule.getStudentId(), schedule.getCourseId(), schedule.getStudentId());
        int numberOfRowEffected;
        try {
            numberOfRowEffected = Execute(statement);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return numberOfRowEffected;
    }

    @Override
    public int delete(Schedule schedule) {
        if (schedule == null) {
            return -1;
        }
        String statement = String.format("delete from schedule where studentId=%s", schedule.getStudentId());
        int numberOfRowEffected;
        try {
            numberOfRowEffected = Execute(statement);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return numberOfRowEffected;
    }

    @Override
    public List<Course> findByStudentId(String studentId) {
        ResultSet resultSet;
        List<Course> courses = null;
        String statement = String.format("select * from student_db.schedule inner join student_db.course_table \n" +
                "on (schedule.courseId = course_table.courseId)\n" +
                "where schedule.studentId =%s", studentId);

        try {
            resultSet = getResultSet(statement);
            courses = getCourseList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }

    @Override
    public List<Student> findByCourseId(String courseId) {
        ResultSet resultSet;
        List<Student> students = null;
        String statement = String.format("select * from student_db.schedule inner join student_db.student \n" +
                "on (schedule.studentId = student.Id)\n" +
                "where schedule.courseId =%s", courseId);

        try {
            resultSet = getResultSet(statement);
            students = getStudentList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    private int Execute(String query) throws SQLException {
        PreparedStatement preparedStatement = pool.getConnection().getConnection().prepareStatement(query);
        return preparedStatement.executeUpdate();
    }

    private ResultSet getResultSet(String query) throws SQLException {
        PreparedStatement preparedStatement = pool.getConnection().getConnection().prepareStatement(query);
        return preparedStatement.executeQuery();
    }

    private List<Student> getStudentList(ResultSet resultSet) throws SQLException {
        List<Student> studentList = new ArrayList<>();
        StudentDAOImpl studentDAO = new StudentDAOImpl();
        while (resultSet.next()) {
            studentList.add(studentDAO.buildStudent(resultSet));
        }
        return studentList;
    }

    private List<Course> getCourseList(ResultSet resultSet) throws SQLException {
        List<Course> courseList = new ArrayList<>();
        CourseDAOImpl courseDAO = new CourseDAOImpl();
        while (resultSet.next()) {
            courseList.add(courseDAO.buildCourse(resultSet));
        }
        return courseList;
    }


}
