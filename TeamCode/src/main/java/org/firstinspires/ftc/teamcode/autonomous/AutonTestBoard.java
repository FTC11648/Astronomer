package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.hardware.hardwareutils.HardwareManager;

@Autonomous
public class AutonTestBoard extends LinearOpMode {

    HardwareManager hardware;

   public DcMotor motorzero;
   public DcMotor motorone;

    @Override
    public void runOpMode() {

        hardware = new HardwareManager(hardwareMap);

        motorzero = hardware.motorzero;
        motorone = hardware.motorone;

        motorzero.setPower(1);

        sleep(1000);

        motorzero.setPower(0);

    }
}
