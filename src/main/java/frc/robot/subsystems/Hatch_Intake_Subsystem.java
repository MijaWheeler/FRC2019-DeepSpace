/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
 
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Solenoid;
import frc.robot.RobotMap;
import frc.robot.commands.Hatch_Intake_Off;
import frc.robot.commands.Hatch_Intake_On;

/**
 * Add your docs here.
 */
public class Hatch_Intake_Subsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  // public Solenoid Sol;

  public Solenoid Sol = new Solenoid(4, 5);
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(null);
  }
}
