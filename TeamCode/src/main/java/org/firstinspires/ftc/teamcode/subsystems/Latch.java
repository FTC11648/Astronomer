package org.firstinspires.ftc.teamcode.subsystems;

import org.firstinspires.ftc.teamcode.hardware.controls.GamepadWrapper;
import org.firstinspires.ftc.teamcode.subsystems.subsystemutils.Subsystem;
import com.qualcomm.robotcore.hardware.CRServo;

public class Latch implements Subsystem{

  private GamepadWrapper manipController;
  private CRServo servo;

  public Latch(GamepadWrapper manipController, CRServo servo){
    this.manipController = manipController;
    this.servo = servo;
  }

  @Override
  public void init(){
    //does nothing
  }

  @Override
  public void update(){
    double volt = manipController.getRightStickX();
    servo.setPower(volt);
  }
}
