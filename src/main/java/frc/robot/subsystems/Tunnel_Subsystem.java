/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.command.Command;
import BAGMotor;

//import org.usfirst.frc.team3008.robot.commands.clawControlOpen_Command;
//import com.ctre.phoenix.motorcontrol.can.*;

//import org.usfirst.frc.team3008.robot.RobotMap;
//import org.usfirst.frc.team3008.robot.commands.LDrivetrain_Command;
//import org.usfirst.frc.team3008.robot.commands.RDrivetrain_Command;

//import org.usfirst.frc.team3008.robot.commands.TunnelIntake_Command;


//import BAG motots

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class TunnelSubsystem extends Subsystem {
  public  TunBag = new BAGMotor(0, MotorType.kDC);
  // Put methods for cont

  public void startTunnel(){ 
		TunBag.set(0.75);
	}

	public void stopTunnel(){ 
		TunBag.set(0);
	}


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    		setDefaultCommand(null);

  }
}
