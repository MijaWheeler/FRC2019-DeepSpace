/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;


public class TurnOnAngle extends Command {
  private double degrees;
  private double currentREncValue;
  private double currentLEncValue;
  private double axleSpins;
  private double finalREncValue;
  private double finalLEncValue;
  public TurnOnAngle(double degrees) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.LDriveTrain);
    requires(Robot.RDriveTrain);
    this.degrees = degrees;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    currentREncValue = Robot.RDriveTrain.MotorR2_Encoder.getPosition();
    currentLEncValue = Robot.LDriveTrain.MotorL2_Encoder.getPosition();
    axleSpins = degrees * RobotMap.axleSpinspDegree; // multiplied by spins p/ 1 degree
    finalREncValue = currentREncValue - axleSpins;
    finalLEncValue = currentLEncValue - axleSpins;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if (axleSpins < 0){
      currentREncValue = Robot.RDriveTrain.MotorR2_Encoder.getPosition();

      if(currentREncValue != finalREncValue){
        //turn right
        Robot.RDriveTrain.MotorR1.set(.1);
        Robot.RDriveTrain.MotorR2.set(.1);
        Robot.RDriveTrain.MotorR3.set(.1);
    
        Robot.LDriveTrain.MotorL1.set(.1);
        Robot.LDriveTrain.MotorL2.set(.1);
        Robot.LDriveTrain.MotorL3.set(.1);
        System.out.println("R Curr: " + currentREncValue);
        System.out.println("R Final: " + finalREncValue);
      }
    }else if (axleSpins > 0){
      currentLEncValue = Robot.LDriveTrain.MotorL2_Encoder.getPosition();

      if(currentLEncValue != finalLEncValue){
        //turn left
        Robot.RDriveTrain.MotorR1.set(-.1);
        Robot.RDriveTrain.MotorR2.set(-.1);
        Robot.RDriveTrain.MotorR3.set(-.1);
    
        Robot.LDriveTrain.MotorL1.set(-.1);
        Robot.LDriveTrain.MotorL2.set(-.1);
        Robot.LDriveTrain.MotorL3.set(-.1);
        System.out.println("R Curr: " + currentLEncValue);
        System.out.println("R Final: " + finalLEncValue);
    }
  }
}

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if(axleSpins > 0 && currentLEncValue < finalLEncValue){
      return true;
    }else if(axleSpins < 0 && currentREncValue > finalREncValue){
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
