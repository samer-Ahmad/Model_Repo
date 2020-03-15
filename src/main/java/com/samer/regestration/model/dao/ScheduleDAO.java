package com.samer.regestration.model.dao;

import com.samer.regestration.model.entity.Course;
import com.samer.regestration.model.entity.Schedule;
import com.samer.regestration.model.entity.Student;

import java.util.List;

public interface ScheduleDAO {

    int save(Schedule schedule);

    int update(Schedule schedule);

    int delete(Schedule schedule);

    List<Course> findByStudentId(String studentId);

    List<Student> findByCourseId(String courseId);
}
