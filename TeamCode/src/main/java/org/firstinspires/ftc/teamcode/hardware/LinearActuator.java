package org.firsinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

public class LinearActuator {
  private DcMotor act;
  public LinearActuator(DcMotor act) {
    this.act = act;
  }

  public void moveUp(double vltg) {
    telemetry.addData("Command", "Moving setting direction upwards");
    this.act.setDirection(DcMotor.Direction.FORWARD);
    this.act.setPower(vltg);
  }

  public void moveDown(double vltg) {
    telemetry.addData("Command", "Moving setting direction downwards");
    this.act.setDirection(DcMotor.Direction.REVERSE);
    this.act.setPower(vltg);
  }
}
