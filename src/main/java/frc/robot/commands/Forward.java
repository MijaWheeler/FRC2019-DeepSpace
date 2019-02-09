/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class Forward extends Command {
  private double inches;
  private double currentEncValue;
  private double axleSpins;
  private double finalEncValue;
  public Forward(double inches) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.LDriveTrain);
    requires(Robot.RDriveTrain);
    this.inches = inches;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    currentEncValue =  Robot.LDriveTrain.MotorL2_Encoder.getPosition();
    axleSpins = inches / 1.53 ; // multiplied by spins p/ 1 degree
    finalEncValue = currentEncValue - axleSpins;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //if angle is positive
    if (axleSpins > 0){
      currentEncValue = Robot.LDriveTrain.MotorL2_Encoder.getPosition();

      if(currentEncValue != finalEncValue){
        //turn left
        Robot.RDriveTrain.MotorR1.set(0.1);
        Robot.RDriveTrain.MotorR2.set(0.1);
        Robot.RDriveTrain.MotorR3.set(0.1);
    
        Robot.LDriveTrain.MotorL1.set(-0.1);
        Robot.LDriveTrain.MotorL2.set(-0.1);
        Robot.LDriveTrain.MotorL3.set(-0.1);

        System.out.println("Current: " + currentEncValue);
        System.out.println("Final: " + finalEncValue);
      }
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if(currentEncValue <= finalEncValue){
      return true;
    }else{
      return false;
    }
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
