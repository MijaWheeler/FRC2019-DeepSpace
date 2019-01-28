/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.HatchArm_Stowed;

//import com.ctre.phoenix.motorcontrol.ControlMode;
//import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.command.WaitUntilCommand;


/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class HatchArm_Subsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  TalonSRX HA_SRX = new TalonSRX(6);
  static DigitalInput liftLim1 = new DigitalInput(RobotMap.LiftLimit1); //
	static DigitalInput liftLim2 = new DigitalInput(RobotMap.LiftLimit2);


  // Put methods for cont

  
  public void Stow(){  // Method 
		HA_SRX.set(ControlMode.Position, 0);
  }
  
  public void Ground(){  // Method 
		HA_SRX.set(ControlMode.Position, 270);
  }
  
  public void Feeder(){  // Method 
		HA_SRX.set(ControlMode.Position, 90);
	}



  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new HatchArm_Stowed());
  }
}
