import com.samer.regestration.model.dao.dao_Impl.ScheduleDAOImple;
import com.samer.regestration.model.entity.Schedule;

public class ScheduleTest {
    public static void main(String[] args) {
        Schedule schedule = new Schedule("1", "3");
        ScheduleDAOImple scheduleDAOImple = new ScheduleDAOImple();
        System.out.println(scheduleDAOImple.findByStudentId("1"));
    }
}
