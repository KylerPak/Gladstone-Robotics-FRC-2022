/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DrivetrainSubsystem driveTrainSubsystem;

  private XboxController controller = new XboxController(0);
  //private Gyro gyro = new ADXRS450_Gyro(SPI.Port.kOnboardCS0);
  private final TeleopDriveCommand teleopDriveCommand;

  private final JoystickButton aButton = new JoystickButton(controller, 1);
  private final JoystickButton bButton = new JoystickButton(controller, 2);
  private final JoystickButton xButton = new JoystickButton(controller, 3);
  private final JoystickButton yButton = new JoystickButton(controller, 4);
  private final JoystickButton leftBumper = new JoystickButton(controller, 5);
  private final JoystickButton rightBumper = new JoystickButton(controller, 6);
  private final JoystickButton leftMiddleButton = new JoystickButton(controller, 7);
  private final JoystickButton rightMiddleButton = new JoystickButton(controller, 8);
  //private JoystickButton leftJoystickButton = new JoystickButton(controller, 9);
  //private final JoystickButton rightJoystickButton = new JoystickButton(controller, 10);
  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  
  public RobotContainer() {
      Talon leftDriveFront = new Talon(1); 
      Talon leftDriveBack = new Talon(3); 
      Talon rightDriveFront = new Talon(2); 
      Talon rightDriveBack = new Talon(4); 
      SpeedController leftMotor = new SpeedControllerGroup(leftDriveFront, leftDriveBack);
      SpeedController rightMotor = new SpeedControllerGroup(rightDriveFront, rightDriveBack);
      /*leftDriveFront.setInverted(true);
      leftDriveBack.setInverted(true);
      rightDriveFront.setInverted(true);
      rightDriveBack.setInverted(true);*/
      driveTrainSubsystem = new DrivetrainSubsystem(leftMotor, rightMotor);
      teleopDriveCommand = new TeleopDriveCommand(driveTrainSubsystem, controller);
    
    CommandScheduler.getInstance().setDefaultCommand(driveTrainSubsystem, teleopDriveCommand);
    configureButtonBindings();
  }  

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoysticpixyLightskButton}.
   */
  private void configureButtonBindings() {
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }

  public Command getTeleopCommand(){
    return teleopDriveCommand;
  }
}