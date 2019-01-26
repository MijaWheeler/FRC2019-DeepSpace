/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class Hatch_Intake_On_For_T extends Command {

  private int Delay_Time;

  public Hatch_Intake_On_For_T() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.Hatch_Intake_Subsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Delay_Time = 0;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.Hatch_Intake_Subsystem.Sol.set(true); // Sol is the solenoid

    Delay_Time = Delay_Time + 20;
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if(Delay_Time >= 1000) return true; //set the delay on the solenoid
    else return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.Hatch_Intake_Subsystem.Sol.set(false);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
