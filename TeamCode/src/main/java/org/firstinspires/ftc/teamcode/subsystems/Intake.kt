package org.firstinspires.ftc.teamcode.subsystems

import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.Gamepad
import com.qualcomm.robotcore.hardware.Servo
import org.firstinspires.ftc.teamcode.subsystems.subsystemutils.Subsystem

class Intake(controller : Gamepad, bootServo : Servo, leftIntake : DcMotor, rightIntake : DcMotor) : Subsystem {

    private val boot : Servo = bootServo
    private val controller : Gamepad = controller
    private val leftIntake : DcMotor = leftIntake
    private val rightIntake : DcMotor = rightIntake

    private var intakeOn = false

    override fun init() {
        // Not used
    }

    override fun update() {
        if (controller.right_bumper) {
            intakeOn = true
        }

        if (controller.left_bumper) {
            intakeOn = false
        }

        if (controller.y) {
            boot.position = 140.0
        }

        if (controller.a) {
            boot.position = 0.0
        }

        leftIntake.power = if (intakeOn) 1.0 else 0.0
        rightIntake.power = if (intakeOn) 1.0 else 0.0
    }
}