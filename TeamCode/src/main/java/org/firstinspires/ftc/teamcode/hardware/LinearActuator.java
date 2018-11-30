package org.firsinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.hardware.DcMotor;

public class LinearActuator {
  private DcMotor act;
  public LinearActuator(DcMotor act) {
    this.act = act;
  }
  public void setVolt(double vltg) {
    act.setPower(vltg);
  }
}
