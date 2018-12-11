package org.firstinspires.ftc.teamcode.hardware;
import com.qualcomm.robotcore.hardware.DcMotor;

public class LinearActuator {
  private DcMotor act;
  private boolean inverted;
  private double scaleFactor;
  public LinearActuator(DcMotor act)
  {
    this(act, false);
  }
  public LinearActuator(DcMotor act, boolean inverted) {
    this.act = act;
    this.inverted = inverted;
    scaleFactor = 1;
  }

  public void scale(double scaleFactor)
  {
    this.scaleFactor = Math.abs(scaleFactor);
  }

  public void setVolt(double vltg) {
    if (inverted) {
      act.setPower(-vltg * scaleFactor);
    } else {
      act.setPower(vltg * scaleFactor);
    }
  }

}
