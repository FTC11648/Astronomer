package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.hardware.hardwareutils.HardwareManager;

/* TODO */
@Disabled
@Autonomous
public class MetalDetachAuto extends LinearOpMode {
    private final long MILLISECONDS_TILL_FULL_ELEVATOR_EXTENSION = 1300;
    private final long MILLISECONDS_TO_DETACH_LATCH = 3300L; // TODO: CHANGE
    private final long MILLISECONDS_TO_WAIT = 0500L;
    private final long MILLISECONDS_TO_DRIVE_SIDEWAYS = 0100;
    private final long MILLISECONDS_TO_DRIVE_FORWARD = 0400L;

    HardwareManager hardware;

    DcMotor leftFrontDrive;
    DcMotor rightFrontDrive;

    public void runOpMode() {

    }
}
