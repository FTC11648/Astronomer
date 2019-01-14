package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.hardware.hardwareutils.HardwareManager;

/**
 * Untested auto. Time is not set yet. Detaches from lander by extending elevator, and then drives forward to fully detach
 */
//@Disabled
@Autonomous
public class DetachAuto extends LinearOpMode {

    HardwareManager hardware;
    AutoCommands commands;

    @Override
    public void runOpMode() {
        hardware = new HardwareManager(hardwareMap);
        commands = new AutoCommands(hardware, telemetry);

        waitForStart();
        while(opModeIsActive()) {
            commands.HorizontalMove(0.5);
            telemetry.update();
        }
    }

}
