package org.firstinspires.ftc.teamcode.subsystems

import android.os.SystemClock.sleep
import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.Gamepad
import com.qualcomm.robotcore.hardware.Servo
import org.firstinspires.ftc.teamcode.subsystems.subsystemutils.Subsystem

class Intake(controller : Gamepad, bootServo : Servo, leftIntake : DcMotor, rightIntake : DcMotor) : Subsystem {

    private val boot : Servo = bootServo
    private val controller : Gamepad = controller
    private val leftIntake : DcMotor = leftIntake
    private val rightIntake : DcMotor = rightIntake

    override fun init() {
        boot.position = 0.0
        leftIntake.power = 0.5
        rightIntake.power = 0.5
        sleep(500)
        leftIntake.power = 0.0
        rightIntake.power = 0.0

    }

    override fun update() {
        when {
            controller.right_bumper -> {
                leftIntake.power = -.25
                rightIntake.power = .25
            }
            controller.left_bumper -> {
                leftIntake.power = 1.0
                rightIntake.power = -1.0
            }
            else -> {
                rightIntake.power = 0.0
                leftIntake.power = 0.0
            }
        }

        if (controller.y) {
            boot.position = 180.0
        }

        if (controller.a) {
            boot.position = 0.0
        }
    }
}