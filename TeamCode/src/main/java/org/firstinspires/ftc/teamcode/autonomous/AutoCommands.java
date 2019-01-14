package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.hardware.hardwareutils.HardwareManager;

public class AutoCommands{
    private HardwareManager hardware;
    private DcMotor leftFrontDrive;
    private DcMotor leftRearDrive;
    private DcMotor rightFrontDrive;
    private DcMotor rightRearDrive;
    Telemetry telemetry;

    public AutoCommands(HardwareManager hardware, Telemetry telemetry) {
        this.telemetry = telemetry;
        this.hardware = hardware;
        leftFrontDrive = hardware.leftFrontDrive;
        leftRearDrive = hardware.leftRearDrive;
        rightFrontDrive = hardware.rightFrontDrive;
        rightRearDrive = hardware.rightRearDrive;
    }

    public void HorizontalMove(double power) {
        telemetry.addData("Power", power);
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