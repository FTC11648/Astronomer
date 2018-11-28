import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

public class System ()
        {
public abstract class Subsystem implements  LinearOpMode
{
    RobotHardware robot = new RobotHardware();

    public void runOpMode()
    {
        robot.init(hardwareMap);

        telemetry.addData("Status", "Ready!");
        telemetry.update();

        // Wait for driver to press Initilize
        waitForStart();

        Init();

        while (opModeIsActive())
        {
            TeleOp();
        }

        telemetry.addData("Status", "Complete!");
        telemetry.update();
    }

    public void Init()
    {

        telemetry.addData("Init", "Complete!");
        telemetry.update();

        //1 sec pause
        sleep(1000);
    }

    public void TeleOp()
    {
            /*
            code
            */

        // Send telemetry message to signify robot is running;
        telemetry.addData("arm",   "%.2f", armPosition);
        telemetry.addData("elevator",  "%.2f", elevatorPosition);
        telemetry.update();

        //40 mS pause
        sleep(40);
    }
}
}
