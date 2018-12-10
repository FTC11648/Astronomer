package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.hardware.controls.GamepadWrapper;
import org.firstinspires.ftc.teamcode.hardware.hardwareutils.HardwareManager;
import org.firstinspires.ftc.teamcode.subsystems.Latch;
import org.firstinspires.ftc.teamcode.subsystems.TwinstickMecanum;
import org.firstinspires.ftc.teamcode.subsystems.subsystemutils.Subsystem;
import org.firstinspires.ftc.teamcode.subsystems.Elevator;
import org.firstinspires.ftc.teamcode.subsystems.subsystemutils.SubsystemManager;

@TeleOp
public class MasterTeleop extends OpMode {
    HardwareManager hardware;

    GamepadWrapper driveController; //gamepad 1;
    GamepadWrapper manipController; //gamepad 2;

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
        driveController = new GamepadWrapper(gamepad1);
        manipController = new GamepadWrapper(gamepad2);


        Subsystem drive = setUpDriveTrain();
        Subsystem latch = setUpLatch();
        Subsystem elevator = setUpElevator();
        subsystems = new SubsystemManager(drive, latch, elevator);
    }
    @Override
    public void loop() {
        subsystems.update();

    }

    private Subsystem setUpElevator() {
      return new Elevator(manipController, hardware.leftActuator, hardware.rightActuator);
    }
    private Subsystem setUpLatch()
    {
        return new Latch(manipController, hardware.latch);
    }
    private Subsystem setUpDriveTrain()
    {
        return new TwinstickMecanum(driveController, hardware.leftFrontDrive, hardware.rightFrontDrive, hardware.rightRearDrive, hardware.leftRearDrive);
    }
}
