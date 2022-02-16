// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import frc.robot.Constants;


public class MotorSubsystem extends SubsystemBase {
  private final TalonFX left1 = new TalonFX(Constants.Motor.kLeft1Id);
  private final TalonFX left2 = new TalonFX(Constants.Motor.kLeft2Id);
  private final TalonFX right1 = new TalonFX(Constants.Motor.kRight1Id);
  private final TalonFX right2 = new TalonFX(Constants.Motor.kRight2Id);
  private final Solenoid shifter = new Solenoid(PneumaticsModuleType.CTREPCM, Constants.Motor.pcmID);

 
  MotorController controlLeft1 = new WPI_TalonFX(Constants.Motor.kLeft1Id);
  MotorController controlLeft2 = new WPI_TalonFX(Constants.Motor.kLeft2Id);

  MotorController controlRight1 = new WPI_TalonFX(Constants.Motor.kRight1Id);
  MotorController controlRight2 = new WPI_TalonFX(Constants.Motor.kRight2Id);

  MotorControllerGroup controllerRight = new MotorControllerGroup(controlRight1, controlRight2);

  MotorControllerGroup controllerLeft = new MotorControllerGroup(controlLeft1, controlLeft2);
  
  DifferentialDrive chompArcadeDrive = new DifferentialDrive(controllerLeft, controllerRight);

  /** Creates a new Motor. */
  public MotorSubsystem() {

    //follows
    left2.follow(left1);
    right2.follow(right1);
    shiftLow();
    

  }

  public void turns (double x, double y){
    if (y>=0) {
      right1.set(TalonFXControlMode.PercentOutput, (x/Constants.Motor.sensitivity)+(y/Constants.Motor.sensitivity));
      left1.set(TalonFXControlMode.PercentOutput, (x/Constants.Motor.sensitivity)-(y/Constants.Motor.sensitivity));
    }
    else {
      right1.set(TalonFXControlMode.PercentOutput, -((x/Constants.Motor.sensitivity)-(y/Constants.Motor.sensitivity)));
      left1.set(TalonFXControlMode.PercentOutput, -((x/Constants.Motor.sensitivity)+(y/Constants.Motor.sensitivity)));
    }
  }

  public void arcadeDrive(double moveSpeed, double rotateSpeed) {
    chompArcadeDrive.arcadeDrive(moveSpeed, rotateSpeed);
  }


    public void setDrive(double y) {
      left1.set(TalonFXControlMode.PercentOutput, -y/3);
      left2.set(TalonFXControlMode.PercentOutput, -y/3);
      right1.set(TalonFXControlMode.PercentOutput, y/3);
      right2.set(TalonFXControlMode.PercentOutput, y/3);
    }

    
    public void shiftHigh(){
      shifter.set(false);
    }
    public void shiftLow(){
      shifter.set(true);
    }
    public boolean isLowGear(){
      return shifter.get();
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