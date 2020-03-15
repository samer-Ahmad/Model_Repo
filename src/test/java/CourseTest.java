import com.samer.regestration.model.builder.courseBuilder.CourseBuilder;
import com.samer.regestration.model.dao.dao_Impl.CourseDAOImpl;
import com.samer.regestration.model.entity.Course;


public class CourseTest {
    public static void main(String[] args) {
        Course course = new CourseBuilder().setCourseId("8").setCourseCode("789").setCourseName("Pro").
                setCapacity("15").build();
        CourseDAOImpl courseDAO = new CourseDAOImpl();

        System.out.println(courseDAO.findCourseByInstructor("Ali"));
        System.out.println(courseDAO.delete("8"));


    }
}
