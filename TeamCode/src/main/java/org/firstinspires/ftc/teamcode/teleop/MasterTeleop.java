package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.hardware.hardwareutils.HardwareManager;
import org.firstinspires.ftc.teamcode.subsystems.TwinstickMecanum;
import org.firstinspires.ftc.teamcode.subsystems.subsystemutils.Subsystem;
import org.firstinspires.ftc.teamcode.subsystems.subsystemutils.SubsystemManager;

@TeleOp
public class MasterTeleop extends OpMode {
    HardwareManager hardware;

    Gamepad driveController; //gamepad 1;
    Gamepad manipController; //gamepad 2;

    SubsystemManager subsystems;
    @Override
    public void init_loop() {
        // If you are using Motorola E4 phones,
        // you should send telemetry data while waiting for start.
        telemetry.addData("status", "loop test... waiting for start");
    }
    @Override
    public void init() {
        //verify switch on bottom is in X pos
        //for drive controller, do Start btn + A btn
        //for manip controller, do Start btn + B btn
        hardware = new HardwareManager(hardwareMap);
        driveController = new Gamepad();
        manipController = new Gamepad();


        Subsystem drive = setUpDriveTrain();


        subsystems = new SubsystemManager(drive);
    }
    @Override
    public void loop() {
        subsystems.update();

    }

    private Subsystem setUpDriveTrain()
    {
        return new TwinstickMecanum(driveController, hardware.leftFrontDrive, hardware.rightFrontDrive);
    }
}
