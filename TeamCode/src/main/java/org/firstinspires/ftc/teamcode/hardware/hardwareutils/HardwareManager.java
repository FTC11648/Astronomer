package org.firstinspires.ftc.teamcode.hardware.hardwareutils;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.hardware.IMU;
import org.firstinspires.ftc.teamcode.hardware.LinearActuator;

/**
 * Contains all pieces of Hardware used on Robot. Only declare & initialize Hardware here.
 */
public class  HardwareManager {

    HardwareMap hardwareMap;

    //Drivetrain Motors
    public DcMotor leftFrontDrive;
    public DcMotor rightFrontDrive;
    public DcMotor leftRearDrive;
    public DcMotor rightRearDrive;



    //Latching Mechanism Servo
    public CRServo latch;

    public IMU imu;

    public HardwareManager(HardwareMap hardwareMap)
    {
        this.hardwareMap = hardwareMap;
        initDrivetrain();
        initLatchingMechanism();
        imu = null; // hardwareMap.get(IMU.class, HardwareNames.imu);
    }

    private void initDrivetrain()
    {
        leftFrontDrive = hardwareMap.get(DcMotor.class, HardwareNames.leftFrontDriveMotor);
        leftRearDrive = hardwareMap.get(DcMotor.class, HardwareNames.leftRearDriveMotor);


        rightFrontDrive = hardwareMap.get(DcMotor.class, HardwareNames.rightFrontDriveMotor);
        rightFrontDrive.setDirection(DcMotorSimple.Direction.REVERSE);
        rightRearDrive = hardwareMap.get(DcMotor.class, HardwareNames.rightRearDriveMotor);
        rightRearDrive.setDirection(DcMotorSimple.Direction.REVERSE);
    }




    private void initLatchingMechanism()
    {
        latch = hardwareMap.get(CRServo.class, HardwareNames.latchingServo);
    }
}
