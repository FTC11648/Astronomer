package org.firstinspires.ftc.teamcode.subsystems.subsystemutils;

import org.firstinspires.ftc.teamcode.subsystems.subsystemutils.Subsystem;

public class SubsystemManager {
  Subsystem[] subSystems;
  public SubsystemManager(Subsystem ...subSystems) {
    this.subSystems = subSystems;
  }

  public void init() {
    for (Subsystem subSystem : subSystems)  {
      subSystem.init();
    }
  }

  public void update() {
    for (Subsystem subSystem : subSystems)  {
      subSystem.update();
    }
  }
}
