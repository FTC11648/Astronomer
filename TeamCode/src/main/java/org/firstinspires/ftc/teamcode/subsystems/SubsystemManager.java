package org.firstinspires.ftc.teamcode.subsystems;

public class SubsystemManager {
  Subsystem[] subSystems;
  public SubsytemManager(Subsystem ...subSystems) {
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
