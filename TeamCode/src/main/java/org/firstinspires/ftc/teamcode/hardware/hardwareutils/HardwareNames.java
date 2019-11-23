package org.firstinspires.ftc.teamcode.hardware.hardwareutils;

/**
 * Contains all hardware device names, which directly correlate with names of devices in the Hardware config file on the RobotController.
 */
public class HardwareNames {

    //drive train motor names
    public static final String leftFrontDriveMotor = "leftFrontDrive"; //
    public static final String leftRearDriveMotor = "leftRearDrive";
    public static final String rightFrontDriveMotor = "rightFrontDrive";
    public static final String rightRearDriveMotor = "rightRearDrive";

    public static final String blockPanServo = "blockpositioner";
    public static final String blockTiltServo = "orienter";

    public static final String bootServo = "boot";

    //arm motor names
    public static final String armLifter = "armmotor"; // Hub 1 port 1
    public static final String armExtender = "pulleymotor"; // Hub 1 Port 0

    //latching mechanism servo name
    public static final String latchingServo = "grabber"; // port 0

}
