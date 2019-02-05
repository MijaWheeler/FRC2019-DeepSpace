/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
//import frc.robot.OI;
//import frc.robot.subsystems.HatchArmPID_Subsystem;

/**
 * An example command.  You can replace me with your own command.
 */
public class HatchArm_Ground extends Command {
  public HatchArm_Ground() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.HatchArm);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    
    Robot.HatchArm.setSetpoint(2048); //Full = 4096; 180deg = 2048spt
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    //Robot.HatchArm.setSetpoint(1024); //Full = 4096; start = 0// 2/4

  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
