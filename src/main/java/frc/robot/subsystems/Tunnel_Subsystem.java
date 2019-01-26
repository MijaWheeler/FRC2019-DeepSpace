/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*---------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.TunnelIntakeOff;
//import com.ctre.CANTalon;
//import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Spark;

/*
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Tunnel_Subsystem extends Subsystem {

  static Spark TunnelSRX = new Spark(0); 
  // Put methods for cont

  public void startTunnel(){ 
		TunnelSRX.set(0.5);
	}

	public void stopTunnel(){ 
		TunnelSRX.set(0.1);
	}


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    		setDefaultCommand(new TunnelIntakeOff());

  }
}
