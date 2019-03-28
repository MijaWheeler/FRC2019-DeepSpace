/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.Roller_Stop;
import edu.wpi.first.wpilibj.Spark;

/**
 * Add your docs here.
 */
public class Roller_Subsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public Spark RollerSpark = new Spark(2);

  public void startIntake(){
    RollerSpark.set(-0.5);
  }

  public void startOuttake(){
    RollerSpark.set(0.5);
  }

  public void stopRoller(){
    RollerSpark.set(0);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new Roller_Stop());

  }
}
