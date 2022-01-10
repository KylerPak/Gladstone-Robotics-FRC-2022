/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DrivetrainSubsystem extends SubsystemBase {
  private final DifferentialDrive driveTrain;
  public double speed;
  public double rotation;

  public DrivetrainSubsystem(SpeedController leftMotor, SpeedController rightMotor) {
    driveTrain = new DifferentialDrive(leftMotor, rightMotor);

    //rightGroup.setInverted(true);
    //leftEncoder.setDistancePerPulse(2 * Math.PI * kWheelRadius / kEncoderResolution * kTransmissionFactor);
    //rightEncoder.setDistancePerPulse(2 * Math.PI * kWheelRadius / kEncoderResolution * kTransmissionFactor);
 
    //leftEncoder.reset();
    //rightEncoder.reset();
  }

  @Override
  public void periodic() { 
    //setSpeeds(kinematics.toWheelSpeeds(new ChassisSpeeds(speed, 0.0, rotation)));
    driveTrain.arcadeDrive(speed, rotation);
  }
}