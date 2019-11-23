package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.subsystems.subsystemutils.Subsystem;

/**
 * assumes that up means extend, down means retract
 */
public class Elevator implements Subsystem {
    private DcMotor lift;
    private DcMotor extend;
    private Gamepad manipController;

    public Elevator(Gamepad manipController,  DcMotor lift, DcMotor extend) {
        this.manipController = manipController;
        this.lift = lift;
        this.extend = extend;
    }

    @Override
    public void init()
    {
        //does nothing
    }

    @Override
    public void update() {
        double leftStickY = manipController.left_stick_y;
        if(leftStickY > 0) {
            lift.setPower(1);
            extend.setPower(1);
        }
        else if (leftStickY < 0)
        {
            lift.setPower(-1);
            extend.setPower(-1);
        }
        else
        {
            lift.setPower(0);
            extend.setPower(0);
        }
    }
}
