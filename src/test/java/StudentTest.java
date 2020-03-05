import com.samer.regestration.model.dao.dao_Impl.StudentDAOImpl;
import com.samer.regestration.model.entity.Student;

import java.sql.SQLException;

public class StudentTest {
    // Var arg  int...  or string...
//    public static int calculate(int... numbers){
//        int a=0;
//        for(int number : numbers){
//
//        a+=number; }
//       return a;
//    }
    public static void main(String[] args) {

//        System.out.println(calculate(1,2,3,4,5,6,7));
        Student student = new Student("2", "Ali", "Karam", "Ali_Karam", "4321", "1904");
        StudentDAOImpl studentDAO = new StudentDAOImpl();
        try {
            studentDAO.update(student);
        } catch (SQLException e) {
            System.out.println(e.getSQLState());

        }
    }
}
