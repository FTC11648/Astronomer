package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.I2cAddr;

import org.firstinspires.ftc.teamcode.hardware.hardwareutils.HardwareManager;

@Autonomous
public class ParkOnRedTape extends LinearOpMode {
public HardwareManager hardware;
    @Override
    public void runOpMode() {
        hardware = new HardwareManager (hardwareMap);
        DcMotor rightMotor = hardware.rightFrontDrive;
        DcMotor leftMotor = hardware.leftFrontDrive;
        ColorSensor colorSensor = hardware.colorSensor;
        while(!opModeIsActive()&&!isStopRequested()){
            telemetry.addData("status", "waiting for start command");
            telemetry.update();
        }
        waitForStart();
        colorSensor.enableLed(true);
        while (colorSensor.red() < 20 ){
            rightMotor.setPower(-1);
            leftMotor.setPower(-1);
        }
        colorSensor.enableLed(false);
        rightMotor.setPower(0);
        leftMotor.setPower(0);
    }
}
