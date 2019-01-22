/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import vexrobotics.BAGMotor;


//import BAG motots

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class TunnelSubsystem extends Subsystem {
  public  TunBag = new BAGMotor(0, MotorType.kDC);
  //public CANSparkMax MotorR2 = new CANSparkMax(1,MotorType.kBrushless);
  // Put methods for cont

  public void startTunnel(){ 
		TunBag.set(.75);
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
