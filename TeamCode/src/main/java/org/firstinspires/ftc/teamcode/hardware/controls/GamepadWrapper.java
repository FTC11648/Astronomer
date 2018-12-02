package org.firstinspires.ftc.teamcode.hardware.controls;

import com.qualcomm.robotcore.hardware.Gamepad;

public class GamepadWrapper {
    Gamepad gamepad;
    public GamepadWrapper(Gamepad gamepad)
    {
        this.gamepad = gamepad;
    }

    public boolean getBtnA(){
        return gamepad.a;
    }


    public boolean getBtnB(){
        return gamepad.b;
    }


    public boolean getBtnX(){
        return gamepad.x;
    }


    public boolean getBtnY(){
        return gamepad.y;
    }

    public boolean getDPadUp(){
        return gamepad.dpad_up;
    }

    public boolean getDPadDown(){
        return gamepad.dpad_down;
    }

    public boolean getDPadLeft(){
        return gamepad.dpad_left;
    }

    public boolean getDPadRight(){
        return gamepad.dpad_right;
    }

    public double getLeftTrigger(){
        return gamepad.left_trigger;
    }

    public double getRightTrigger(){
        return gamepad.right_trigger;
    }

    public boolean getLeftBumper(){
        return gamepad.left_bumper;
    }

    public boolean getRightBumper(){
        return gamepad.right_bumper;
    }

    public double getRightStickX(){
        return gamepad.right_stick_x;
    }

    public double getRightStickY(){
        return -gamepad.right_stick_y;
    }

    public double getLeftStickX(){
        return gamepad.left_stick_x;
    }

    public double getLeftStickY(){
        return -gamepad.left_stick_y;
    }
}

