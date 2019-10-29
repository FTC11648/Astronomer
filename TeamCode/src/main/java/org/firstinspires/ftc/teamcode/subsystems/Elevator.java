package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.hardware.LinearActuator;
import org.firstinspires.ftc.teamcode.hardware.controls.GamepadWrapper;
import org.firstinspires.ftc.teamcode.subsystems.subsystemutils.Subsystem;

/**
 * assumes that up means extend, down means retract
 */
public class Elevator implements Subsystem {
  private LinearActuator left;
  private LinearActuator right;
  private Gamepad manipController;

  public Elevator(Gamepad manipController, LinearActuator left, LinearActuator right) {
    this.manipController = manipController;
    this.left = left;
    this.right = right;
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
      left.setVolt(1);
      right.setVolt(1);
    }
    else if (leftStickY < 0)
    {
      left.setVolt(-1);
      right.setVolt(-1);
    }
    else
    {
      left.setVolt(0);
      right.setVolt(0);
    }
    }
}
