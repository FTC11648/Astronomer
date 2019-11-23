package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.subsystems.subsystemutils.Subsystem;


public class Grabber implements Subsystem {

    Gamepad manipController;
    CRServo latch;
    CRServo rotate;

    public Grabber(Gamepad manip, CRServo latch, CRServo rotate) {
        this.rotate = rotate;
        this.latch = latch;
        this.manipController = manip;
    }

    @Override
    public void init() {
        rotate.setPower(0);
    }

    @Override
    public void update() {
        if (manipController.a) {
            latch.setPower(0);
        } else if (manipController.b) {
            latch.setPower(0);
        } else {
            latch.setPower(0);
        }

        if (manipController.left_stick_y > .2 ) {
            rotate.setPower(0.7);
        } else if (manipController.left_stick_y < -.2) {
            rotate.setPower(0.3);
        } else {
            rotate.setPower(0);
        }
    }
}
