/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*---------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.TunnelIntakeOff; //command needed in order to set defalt 
import edu.wpi.first.wpilibj.Spark;

/*
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Tunnel_Subsystem extends Subsystem {

  static Spark TunnelSpark = new Spark(RobotMap.TunnelSparkCANID); //(port number)
  
  //***Methods to be used within commands
  public void startTunnel(){  // Method makes motor move forward
		TunnelSpark.set(-0.5);
	}

	public void stopTunnel(){ //Method makes motor stop
		TunnelSpark.set(0.1);
	}


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());

        setDefaultCommand(new TunnelIntakeOff());
        //the motor is off as defalt command

  }
}
