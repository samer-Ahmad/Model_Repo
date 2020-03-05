import com.samer.regestration.model.dao.dao_Impl.CourseDAOImpl;

import java.sql.SQLException;

public class CourseTest {
    public static void main(String[] args) {
//        Course course=new Course("2","011","Java","Karam","15",
//                "1-4-2020","4-5","245");
        CourseDAOImpl courseDAO = new CourseDAOImpl();

        try {
            System.out.println(courseDAO.findCourseByInstructor("Ali"));
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
