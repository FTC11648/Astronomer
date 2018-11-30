package org.firstinspires.ftc.teamcode.subsystems;

import org.firstinspires.ftc.teamcode.hardware.LinearActuator;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.DcMotor;

public class Elevator implements Subsystem{
  private LinearActuator actuator1;
  private LinearActuator actuator2;
  private Gamepad manipController;

  public Elevator(Gamepad manipController, LinearActuator actuator1, LinearActuator actuator2) {
    this.manipController = manipController;
    this.actuator1 = actuator1;
    this.actuator2 = actuator2;
  }
  @Override
  public void init()
  {
    //does nothing
  }
  @Override
  public void update() {
    double leftStickY = -manipController.left_stick_y;
    actuator1.setVolt(leftStickY);
    actuator2.setVolt(leftStickY);
  }
}
