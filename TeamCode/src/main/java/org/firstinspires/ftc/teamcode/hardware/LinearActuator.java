package org.firstinspires.ftc.teamcode.hardware;
import com.qualcomm.robotcore.hardware.DcMotor;

public class LinearActuator {
  private DcMotor act;
  private boolean inverted;
  public LinearActuator(DcMotor act)
  {
    this(act, false);
  }
  public LinearActuator(DcMotor act, boolean inverted) {
    this.act = act;
    this.inverted = inverted;
  }

  public void setVolt(double vltg) {
    if (inverted) {
      act.setPower(-vltg);
    } else {
      act.setPower(vltg);
    }
  }
}
