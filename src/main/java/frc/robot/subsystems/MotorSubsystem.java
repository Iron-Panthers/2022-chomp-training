// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;


public class MotorSubsystem extends SubsystemBase {
  private final TalonFX left1 = new TalonFX(Constants.Motor.kLeft1Id);
  private final TalonFX left2 = new TalonFX(Constants.Motor.kLeft2Id);
  private final TalonFX right1 = new TalonFX(Constants.Motor.kRight1Id);
  private final TalonFX right2 = new TalonFX(Constants.Motor.kRight2Id);

  /** Creates a new Motor. */
  public MotorSubsystem() {

    //follows
    left2.follow(left1);
    right2.follow(right1);
  }

    public void setDrive(double y) {
      left1.set(TalonFXControlMode.PercentOutput, -y);
      left2.set(TalonFXControlMode.PercentOutput, -y);
      right1.set(TalonFXControlMode.PercentOutput, y);
      right2.set(TalonFXControlMode.PercentOutput, y);
    }

    public void turnRight(double x) {
      right1.set(TalonFXControlMode.PercentOutput, -x);
      right2.set(TalonFXControlMode.PercentOutput, -x);
      left1.set(TalonFXControlMode.PercentOutput, x);
      left2.set(TalonFXControlMode.PercentOutput, x);
    }

    public void turnLeft(double x) {
      right1.set(TalonFXControlMode.PercentOutput, x);
      right2.set(TalonFXControlMode.PercentOutput, x);
      left1.set(TalonFXControlMode.PercentOutput, -x);
      left2.set(TalonFXControlMode.PercentOutput, -x);
    }


  public void setPower(TalonFX motor, double power) {

    motor.set(TalonFXControlMode.PercentOutput, power);
  
  }

  public void printText() {

    System.out.println("Gertrude says hi");

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