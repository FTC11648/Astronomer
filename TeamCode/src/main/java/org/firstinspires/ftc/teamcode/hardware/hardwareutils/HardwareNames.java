package org.firstinspires.ftc.teamcode.hardware.hardwareutils;

/**
 * Contains all hardware device names, which directly correlate with names of devices in the Hardware config file on the RobotController.
 */
public class HardwareNames {

    //drive train motor names
    public static final String leftMotor = "leftMotor"; //
    public static final String rightMotor = "rightMotor";
    public static final String rightFrontDriveMotor = "rightFrontDrive";
    public static final String rightRearDriveMotor = "rightRearDrive";

    //elevator motor names
    public static final String leftElevatorActuator = "leftElevator"; // Hub 1 port 1
    public static final String rightElevatorActuator = "rightElevator"; // Hub 1 Port 0

    //latching mechanism servo name
    public static final String latchingServo = "latch"; // port 0

    public static final String imu = "imu";
    public static final String colorSensor = "colorSensor";
}
