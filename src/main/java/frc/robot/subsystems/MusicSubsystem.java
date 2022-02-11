// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.music.Orchestra;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

public class MusicSubsystem extends SubsystemBase {

  private final TalonFX music1 = new TalonFX(Constants.Music.kMusic1Id);
  private final TalonFX music2 = new TalonFX(Constants.Music.kMusic2Id);
  private final TalonFX music3 = new TalonFX(Constants.Music.kMusic3Id);
  private final TalonFX music4 = new TalonFX(Constants.Music.kMusic4Id);
  private final Orchestra chompOrchestra = new Orchestra();

  /** Creates a new ExampleSubsystem. */
  public MusicSubsystem() {

 chompOrchestra.addInstrument(music1);
    chompOrchestra.addInstrument(music2);
    chompOrchestra.addInstrument(music3);
    //chompOrchestra.addInstrument(music4);
    chompOrchestra.loadMusic(Constants.Music.fileName);
    
  }

  public void playMusic() {

    chompOrchestra.play();

  }

  public void pauseMusic(){
    chompOrchestra.pause();
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
