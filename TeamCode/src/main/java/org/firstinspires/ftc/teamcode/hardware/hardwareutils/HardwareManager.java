package org.firstinspires.ftc.teamcode.hardware.hardwareutils;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Contains all pieces of Hardware used on Robot. Only declare & initialize Hardware here.
 */
public class  HardwareManager {

    HardwareMap hardwareMap;

    // Drive train Motors
    public DcMotor leftFrontDrive;
    public DcMotor rightFrontDrive;
    public DcMotor rightRearDrive;
    public DcMotor leftRearDrive;
    public ColorSensor colorsenser;

    // Elevator motors
    public DcMotor elevatorLift;
    public DcMotor elevatorExtend;

    // Block Grabber
    public CRServo blockPanServo;
    public CRServo blockTiltServo;

    // Latching Mechanism Servo
    public CRServo latch;

    // Boot Mechanism Servo
    public CRServo boot;

    public HardwareManager(HardwareMap hardwareMap) {
        this.hardwareMap = hardwareMap;
        initDriveTrain();
        initBlockControlMechanism();
        initElevator();
        initBoot();
    }

    private void initBoot() {
        boot = hardwareMap.get(CRServo.class, HardwareNames.bootServo);
    }

    private void initDriveTrain() {
        // Set the motors
        leftFrontDrive = hardwareMap.get(DcMotor.class, HardwareNames.leftFrontDrive);
        leftRearDrive = hardwareMap.get(DcMotor.class, HardwareNames.leftRearDrive);
        rightFrontDrive = hardwareMap.get(DcMotor.class, HardwareNames.rightFrontDrive);
        rightRearDrive = hardwareMap.get(DcMotor.class, HardwareNames.rightRearDrive);
        // Reverse right motors
        rightFrontDrive.setDirection(DcMotorSimple.Direction.REVERSE);
        rightRearDrive.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    private void initElevator() {
        elevatorLift = hardwareMap.get(DcMotor.class, HardwareNames.armLifter);
        elevatorExtend = hardwareMap.get(DcMotor.class, HardwareNames.armExtender);
    }

    private void initBlockControlMechanism()
    {
        blockPanServo = hardwareMap.get(CRServo.class, HardwareNames.blockPanServo);
        blockTiltServo = hardwareMap.get(CRServo.class, HardwareNames.blockTiltServo);
        latch = hardwareMap.get(CRServo.class, HardwareNames.latchingServo);
    }
}
