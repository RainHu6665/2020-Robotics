/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

// import frc.robot.commands.DriveCommand;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
// import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
// import edu.wpi.first.wpilibj.throttle;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import frc.robot.RobotContainer;
import frc.robot.Constants;
// import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;


public class DriveTrain extends SubsystemBase {

  Spark motorL1 = new Spark(Constants.motorL1);
  Spark motorL2 = new Spark(Constants.motorL2);
  SpeedControllerGroup m_leftControllerGroup = new SpeedControllerGroup(motorL1, motorL2);

  Spark motorR1 = new Spark(Constants.motorR1);
  Spark motorR2 = new Spark(Constants.motorR2);
  SpeedControllerGroup m_rightControllerGroup = new SpeedControllerGroup(motorR1, motorR2);

  DifferentialDrive m_DriveTrain = new DifferentialDrive(m_leftControllerGroup, m_rightControllerGroup);
  // m_DriveTrain.close();


  // public double getZ(final Joystick joystick) {
  //   moveLimiter = new double getZ()
  // }

  public double getZ(double moveLimiter) {
    // moveLimiter = new double getZ()
    return 0.0;
  }

  public void TakeJoystickInput (Joystick joystick){
      
      // final double moveLimiter = RobotContainer.Joystick.throttle.getZ;
      // final double turnLimiter = RobotContainer.throttle.getZ;
      m_DriveTrain.arcadeDrive(joystick.getY()*.65, joystick.getX()*.65);
    }

  // public void arcadeDrive​(.65* joystick.getY() , 0.65* joystick.getX());

  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
