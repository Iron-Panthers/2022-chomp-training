// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;


public class MotorSubsystem extends SubsystemBase {
  /** Creates a new Motor. */
  public MotorSubsystem() {

    //follows
    left2.follow(left1);
    right2.follow(right1);
  }
  
  private final WPI_TalonFX left1 = new WPI_TalonFX(Constants.Motor.kLeft1Id);
  private final WPI_TalonFX left2 = new WPI_TalonFX(Constants.Motor.kLeft2Id);
  private final WPI_TalonFX right1 = new WPI_TalonFX(Constants.Motor.kRight1Id);
  private final WPI_TalonFX right2 = new WPI_TalonFX(Constants.Motor.kRight2Id);


    public void setDrive(double y) {
      left1.set(y);
      left2.set(y);
      right1.set(y);
      right2.set(y);
    }

    public void turnRight(double x) {
      right1.set(-x);
      right2.set(-x);
      left1.set(x);
      left2.set(x);
    }

    public void turnLeft(double x) {
      right1.set(x);
      right2.set(x);
      left1.set(-x);
      left2.set(-x);
    }


  public void setPower(WPI_TalonFX motor, double power) {

    motor.set(power);
  
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