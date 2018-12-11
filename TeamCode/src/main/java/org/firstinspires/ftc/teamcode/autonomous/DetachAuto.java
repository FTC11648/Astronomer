package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.hardware.LinearActuator;
import org.firstinspires.ftc.teamcode.hardware.hardwareutils.HardwareManager;

/**
 * Untested auto. Time is not set yet. Detaches from lander by extending elevator, and then drives forward to fully detach
 */
@Disabled
@Autonomous
public class DetachAuto extends LinearOpMode {

    HardwareManager hardware;

    //drive train motors
    DcMotor leftFrontDrive;
    DcMotor leftRearDrive;
    DcMotor rightFrontDrive;
    DcMotor rightRearDrive;

    //Elevator Linear Actuators
    LinearActuator leftActuator;
    LinearActuator rightActuator;

    CRServo latch;
    @Override
    public void runOpMode() {
        hardware = new HardwareManager(hardwareMap);

        leftFrontDrive = hardware.leftFrontDrive;
        //leftRearDrive = hardware.leftRearDrive;
        rightFrontDrive = hardware.rightFrontDrive;
        //rightRearDrive = hardware.rightRearDrive;

        leftActuator = hardware.leftActuator;
        rightActuator = hardware.rightActuator;

        latch = hardware.latch;
        while (!opModeIsActive() && !isStopRequested()) {
            telemetry.addData("status", "waiting for start command...");
            telemetry.update();
        }
        //extend elevator to full. Assumes positive voltage extends the elevator
        leftActuator.setVolt(1);
        rightActuator.setVolt(1);
        sleep(AutoConstants.MILLISECONDS_TILL_FULL_ELEVATOR_EXTENSION);

        latch.setPower(-1);
        sleep(AutoConstants.MILLISECONDS_TO_DETACH_LATCH);
        latch.setPower(0);
        sleep(AutoConstants.MILLISECONDS_TO_WAIT);
    }
}
