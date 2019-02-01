/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
//import frc.robot.commands.HatchArm_Feeder;
import frc.robot.commands.HatchArm_Stowed;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;


/**
 * Add your docs here.
 */
public class HatchArmPID_Subsystem extends PIDSubsystem {
  /**
   * Add your docs here.
   */
  
  TalonSRX HA_SRX = new TalonSRX(6);


  public HatchArmPID_Subsystem() {
    // Intert a subsystem name and PID values here
    super("HatchArmPID_Subsystem", 0.00009, 0, 0);
    // Use these to get going:
    // setSetpoint() - Sets where the PID controller should move the system
    // to
    // enable() - Enables the PID controller.
    
    enable(); //enables the PID Controller
    setAbsoluteTolerance(0); //Sets the absolute parameters of PID
    HA_SRX.setSensorPhase(true); //controls the direction of the motor control using boolean
    HA_SRX.setSelectedSensorPosition(0, 0, 1); //sensor position, pidIdx, time out
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
     setDefaultCommand(new HatchArm_Stowed());
  }

  @Override
  protected double returnPIDInput() {
    // Return your input value for the PID loop
    // e.g. a sensor, like a potentiometer:
    // yourPot.getAverageVoltage() / kYourMaxVoltage;
    
    return HA_SRX.getSelectedSensorPosition(0);
    
  }

  @Override
  protected void usePIDOutput(double output) {
    // Use output to drive your system, like a motor
    // e.g. yourMotor.set(output);
    HA_SRX.set(ControlMode.PercentOutput, output);

  }
}
