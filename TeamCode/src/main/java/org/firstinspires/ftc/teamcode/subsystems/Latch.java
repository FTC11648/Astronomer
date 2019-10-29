package org.firstinspires.ftc.teamcode.subsystems;

import org.firstinspires.ftc.teamcode.hardware.controls.GamepadWrapper;
import org.firstinspires.ftc.teamcode.subsystems.subsystemutils.Subsystem;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Gamepad;

public class Latch implements Subsystem{

  private Gamepad manipController;
  private CRServo servo;

  public Latch(Gamepad manipController, CRServo servo){
    this.manipController = manipController;
    this.servo = servo;
  }

  @Override
  public void init(){
    //does nothing
  }

  @Override
  public void update(){
    double volt = manipController.right_stick_x;
    servo.setPower(volt);
  }
}
