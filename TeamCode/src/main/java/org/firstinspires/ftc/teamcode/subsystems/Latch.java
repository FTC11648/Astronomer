package org.firstinspires.ftc.teamcode.subsystems;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.hardware.controls.GamepadWrapper;
import org.firstinspires.ftc.teamcode.subsystems.subsystemutils.Subsystem;
import com.qualcomm.robotcore.hardware.CRServo;

public class Latch implements Subsystem{

  private GamepadWrapper manipController;
  private CRServo servo;
  private Telemetry tester;

  public Latch(GamepadWrapper manipController, Telemetry tester, CRServo servo){
    this.manipController = manipController;
    this.servo = servo;
    this.tester = tester;
  }

  @Override
  public void init(){
    //does nothing
  }

  @Override
  public void update(){
    double volt = manipController.getRightStickX();
    tester.addData("Voltage", volt);
    tester.update();
    servo.setPower(volt);
  }
}
