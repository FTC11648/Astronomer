package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;

public class IMU {

    private BNO055IMU imu;
    private BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();

    public IMU(BNO055IMU imu){
        this.imu = imu;
        parameters.angleUnit           = BNO055IMU.AngleUnit.DEGREES;
        parameters.accelUnit           = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        parameters.calibrationDataFile = "BNO055IMUCalibration.json";
        parameters.loggingEnabled      = true;
        parameters.loggingTag          = "IMU";
        parameters.accelerationIntegrationAlgorithm = new JustLoggingAccelerationIntegrator();
        imu.initialize(parameters);
    }

    public double getxAngle(){ return imu.getAngularOrientation().thirdAngle; }

    public double getYAngle(){ return imu.getAngularOrientation().secondAngle; }
    // if angle does not correspond, or is incorrect flip the order

    public double getZAngle(){ return imu.getAngularOrientation().firstAngle; }

}
