/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class TunnelIntakeOff extends Command {
  public TunnelIntakeOff() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.Tunnel); // import all recuired subsystems
  }

  // Called just before this Command runs the first time
  //@Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.Tunnel.stopTunnel();
     //during the execution of this button, stop method runs

  }

  // Make this return true when this Command no longer needs to run execute()
 @Override
  protected boolean isFinished() {
    return false;

  }

  // Called once after isFinished returns true
  @Override
  protected void end() {   
    Robot.Tunnel.stopTunnel(); 
    // motor remains off, probably could be done w/out this 
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
 // @Override
  protected void interrupted() {
  }
}
