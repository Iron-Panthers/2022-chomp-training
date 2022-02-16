// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.MotorSubsystem;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.Joystick;

/** An example command that uses an example subsystem. */
public class MotorCommand extends CommandBase {
   
  private MotorSubsystem testMotor;
  /*
  private DoubleSupplier getX;
  private DoubleSupplier getY;
*/


private Double getX;
private Double getY;

 /*
  public MotorCommand(MotorSubsystem testMotor, DoubleSupplier getX, DoubleSupplier getY) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.testMotor = testMotor;
    this.getX = getX;
    this.getY = getY;
    addRequirements(testMotor);
  }
*/

public MotorCommand(MotorSubsystem testMotor, double getX, double getY) {
  // Use addRequirements() here to declare subsystem dependencies.
  this.testMotor = testMotor;
  this.getX = getX;
  this.getY = getY;
  addRequirements(testMotor);
}

  // Called when the command is initially scheduled.
  @Override/*  */
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  
  public void execute() {
    //testMotor.turns(getX.getAsDouble(), getY.getAsDouble());
    testMotor.turns(getX, getY);
    testMotor.shiftLow();
    //testMotor.turnRight(happyStick.getX());
    //testMotor.turnLeft(happyStick.getX());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    testMotor.setDrive(0);
    testMotor.shiftHigh();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
