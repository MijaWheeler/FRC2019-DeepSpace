/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.Shark_Stop;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;


/**
 * Add your docs here.
 */
public class BabyShark_Subsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  TalonSRX Shark_SRX = new TalonSRX(RobotMap.Shark_Talon_ID);

  public void Shark_Up(){
    Shark_SRX.set(ControlMode.PercentOutput, -0.3);
  }

  public void Shark_Down(){
    Shark_SRX.set(ControlMode.PercentOutput, 0.3);
  }

  public void Shark_Stop(){
    Shark_SRX.set(ControlMode.PercentOutput, 0.0);
  }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new Shark_Stop());

  }
}
