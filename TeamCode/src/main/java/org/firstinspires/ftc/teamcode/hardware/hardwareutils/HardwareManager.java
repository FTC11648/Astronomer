package org.firstinspires.ftc.teamcode.hardware.hardwareutils;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.hardware.IMU;

/**
 * Contains all pieces of Hardware used on Robot. Only declare & initialize Hardware here.
 */
public class  HardwareManager {

    HardwareMap hardwareMap;

    //Drivetrain Motors
    public DcMotor leftFrontDrive;
    public DcMotor rightFrontDrive;
    public ColorSensor colorsenser;




    //Latching Mechanism Servo
    public CRServo latch;

    public IMU imu;

    public HardwareManager(HardwareMap hardwareMap)
    {
        this.hardwareMap = hardwareMap;
        initDrivetrain();
        //initLatchingMechanism();
        initSensor ();
        imu = null; // hardwareMap.get(IMU.class, HardwareNames.imu);
    }

    private void initDrivetrain()
    {
       leftFrontDrive = hardwareMap.get(DcMotor.class, HardwareNames.leftMotor);
       rightFrontDrive= hardwareMap.get(DcMotor.class, HardwareNames.rightMotor);
    }

    private void initSensor ()
    {
        colorsenser = hardwareMap.get(ColorSensor.class, HardwareNames.colorSensor);
    }


    private void initLatchingMechanism()
    {
        latch = hardwareMap.get(CRServo.class, HardwareNames.latchingServo);
    }
}
