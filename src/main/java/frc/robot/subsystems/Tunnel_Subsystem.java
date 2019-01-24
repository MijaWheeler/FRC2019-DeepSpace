/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Subsystem;

//import edu.wpi.first.wpilibj.MotorSafety;;

//import BAG motots

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Tunnel_Subsystem extends Subsystem {
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
