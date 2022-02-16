// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.sensors.CANCoder;

import frc.robot.Constants;

public class ArmSubsystem extends SubsystemBase {
  private final TalonFX right = new TalonFX(Constants.Arm.kRightId);
  private final TalonFX left = new TalonFX(Constants.Arm.kLeftId);

  private final CANCoder canCoder = new CANCoder(Constants.Arm.kCANCoderId);
  
  /** Creates a new ArmSubsystem. */
  public ArmSubsystem() { 
  }

 
public void move (double armSpeed) {

  right.set(TalonFXControlMode.PercentOutput, -armSpeed);
  left.set(TalonFXControlMode.PercentOutput,armSpeed);

}


public void control (double z) {

  while (z > canCoder.getAbsolutePosition()){

  }



}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
