/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorMatch;

public class ColorSensor1 extends SubsystemBase{
  private final I2C.Port i2cPort = I2C.Port.kOnboard;
  private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);
  private final ColorMatch m_colorSensor1 = new ColorMatch();

  public static final Color kBlueTarget = ColorSensor1.makeColor(0.143, 0.427, 0.429);
  public static final Color kGreenTarget = ColorSensor1.makeColor(0.197, 0.561, 0.240);
  public static final Color kRedTarget = ColorSensor1.makeColor(0.561, 0.232, 0.114);
  public static final Color kYellowTarget = ColorSensor1.makeColor(0.361, 0.524, 0.113);

  private ColorMatchResult matchedResult = new ColorMatchResult(Color.kBlack,0);

  public ColorSensor1() {
    m_colorSensor1.addColorMatch(kBlueTarget);
    m_colorSensor1.addColorMatch(kGreenTarget);
    m_colorSensor1.addColorMatch(kRedTarget);
    m_colorSensor1.addColorMatch(kYellowTarget);
  }
  public Color get_color() {
    Color detectedColor = m_colorSensor.getColor();
    String colorString;
    ColorMatchResult match = m_colorSensor1.matchClosestColor(detectedColor);

    if (match.color == kBlueTarget) {
      colorString = "Blue";
    } else if (match.color == kRedTarget){
      colorString = "Red";
    } else if (match.color == kGreenTarget){
      colorString = "Green";
    } else if (match.color == kYellowTarget) {
      colorString = "Yellow";
    } else {
      colorString = "Unknown";
    }
    SmartDashboard.putNumber("Red", detectedColor.red);
    SmartDashboard.putNumber("Green", detectedColor.green);
    SmartDashboard.putNumber("Blue", detectedColor.blue);
    SmartDashboard.putNumber("Confidence", match.confidence);
    SmartDashboard.putString("Detected Color", colorString);
  }
}