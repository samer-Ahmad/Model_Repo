import com.samer.regestration.model.dao.dao_Impl.CourseDAOImpl;

import java.sql.SQLException;

public class CourseTest {
    public static void main(String[] args) {
        CourseDAOImpl courseDAO = new CourseDAOImpl();

        try {
            System.out.println(courseDAO.findCourseByName("Math"));
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
