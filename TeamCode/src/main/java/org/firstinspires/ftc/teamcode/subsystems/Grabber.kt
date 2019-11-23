package org.firstinspires.ftc.teamcode.subsystems

import com.qualcomm.robotcore.hardware.CRServo
import com.qualcomm.robotcore.hardware.Gamepad
import org.firstinspires.ftc.teamcode.subsystems.subsystemutils.Subsystem

class Grabber(manipController: Gamepad, latchServo: CRServo, rotateServo: CRServo) : Subsystem {

    private val latch : CRServo = latchServo
    private val rotate : CRServo = rotateServo
    private val controller : Gamepad = manipController

    override fun init() {
        // Empty
    }

    override fun update() {
        when {
            controller.a -> latch.power = 1.0
            controller.b -> latch.power = -1.0
            else -> latch.power = 0.0
        }
        rotate.power = controller.left_stick_y.toDouble()
    }
}