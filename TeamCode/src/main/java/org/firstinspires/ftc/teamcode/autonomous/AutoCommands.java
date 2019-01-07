import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.hardware.hardwareutils.HardwareManager;

public class AutoCommands{
    private HardwareManager hardware;
    private DcMotor leftFrontDrive;
    private DcMotor leftRearDrive;
    private DcMotor rightFrontDrive;
    private DcMotor rightRearDrive;

    public AutoCommands(HardwareManager hardware) {
        this.hardware = hardware;
        leftFrontDrive = hardware.leftFrontDrive;
        leftRearDrive = hardware.leftRearDrive;
        rightFrontDrive = hardware.leftFrontDrive;
        rightRearDrive = hardware.rightRearDrive;
    }



    public void HorizontalMove(double power){
        double leftF = 0, rightF = 0, leftB = 0, rightB = 0;
        leftF += power;
        rightF += -power;
        leftB += -power;
        rightB += power;

        leftFrontDrive.setPower(leftF);
        leftRearDrive.setPower(leftB);
        rightFrontDrive.setPower(rightF);
        rightRearDrive.setPower(rightB);
    }

}