package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class Forwardx extends Command {
  private double inches; 
  private double currentEncValue ;
  private double axleSpins;
  private double finalEncValue;
  
  public Forwardx(double inches) {
    requires(Robot.LDriveTrain);
    requires(Robot.RDriveTrain);
    this.inches = inches;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    currentEncValue = Robot.LDriveTrain.MotorL2_Encoder.getPosition();
    axleSpins = inches / RobotMap.GearBoxRatio; // inches dividedb by the ration of axel rota.:inches driven
    finalEncValue = currentEncValue - axleSpins;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if (axleSpins > 0){
      currentEncValue = Robot.LDriveTrain.MotorL2_Encoder.getPosition();

      if(currentEncValue != finalEncValue){
        //move forward
        Robot.RDriveTrain.MotorR1.set(-0.1);
        Robot.RDriveTrain.MotorR2.set(-0.1);
        Robot.RDriveTrain.MotorR3.set(-0.1);
    
        Robot.LDriveTrain.MotorL1.set(0.1);
        Robot.LDriveTrain.MotorL2.set(0.1);
        Robot.LDriveTrain.MotorL3.set(0.1);

        System.out.println("Current: " + currentEncValue);
        System.out.println("Final: " + finalEncValue);
      }
     }

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if(currentEncValue <= finalEncValue){
      //return true; //original value-motors run forever
      return false; // motor stops after a bit

    }else{
      //return false;  //original value
      return true; 
     
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
