// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.MotorSubsystem;
import frc.robot.subsystems.MusicSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.MotorCommand;
import frc.robot.commands.MusicCommand;
import frc.robot.commands.BrakeCommand;
import frc.robot.commands.ArcadeCommand;
import frc.robot.commands.ArmCommand;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);


  private final Joystick happyStick = new Joystick(Constants.RobotContainer.Ajoystick);

  private final JoystickButton brake = new JoystickButton(happyStick, Constants.RobotContainer.BRAKE_BUTTON);
  private final JoystickButton playMusicButton = new JoystickButton(happyStick, Constants.RobotContainer.PLAY_MUSIC_BUTTON);
  private final JoystickButton moveArmUpButton = new JoystickButton(happyStick, Constants.Arm.MOVE_ARM_UP_BUTTON);
  private final JoystickButton moveArmDownButton = new JoystickButton(happyStick, Constants.Arm.MOVE_ARM_DOWN_BUTTON);
  private final MotorSubsystem runMotor = new MotorSubsystem();
  private final MusicSubsystem Music = new MusicSubsystem();
  private final ArmSubsystem Arm = new ArmSubsystem();


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    runMotor.setDefaultCommand(new MotorCommand(runMotor, happyStick.getX(), happyStick.getY()));
    //runMotor.setDefaultCommand(new MotorCommand(runMotor, happyStick::getY, happyStick::getY));
    //runMotor.setDefaultCommand(new ArcadeCommand(runMotor, happyStick.getY(), happyStick.getX()));
    Arm.setDefaultCommand(new ArmCommand(Arm, 0));
  }
  

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

  
    brake.whileHeld(new BrakeCommand(runMotor));
    playMusicButton.whileHeld(new MusicCommand(Music));
    moveArmUpButton.whileHeld(new ArmCommand(Arm, Constants.Arm.ArmMoveSpeed));
    moveArmDownButton.whileHeld(new ArmCommand(Arm, -Constants.Arm.ArmMoveSpeed));


  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
