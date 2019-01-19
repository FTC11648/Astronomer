package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.hardware.IMU;
import org.firstinspires.ftc.teamcode.hardware.hardwareutils.HardwareManager;

@Autonomous
public class IMUTester extends LinearOpMode {
    HardwareManager hardware;
    AutoCommands commands;
    @Override
    public void runOpMode() {
        hardware = new HardwareManager(hardwareMap);
        commands = new AutoCommands(hardware, telemetry);
        waitForStart();
        while (opModeIsActive()) {

            final double heading = hardware.imu.getRelativeHeading();

            boolean doneTurn1 = commands.gyroCorrect(90.0, 1, heading, 0.1, 0.3) > 10;
            this.telemetry.addData("Heading", heading);
            this.telemetry.addData("Done Turn", doneTurn1);
        }
    }
}
