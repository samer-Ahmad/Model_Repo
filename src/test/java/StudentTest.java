import com.samer.regestration.model.dao.dao_Impl.StudentDAOImpl;

public class StudentTest {
    public static void main(String[] args) {


        StudentDAOImpl studentDAO = new StudentDAOImpl();
        System.out.println(studentDAO.findStudentById("2"));
        System.out.println(studentDAO.findStudentByEmail("AHM"));

    }
}
