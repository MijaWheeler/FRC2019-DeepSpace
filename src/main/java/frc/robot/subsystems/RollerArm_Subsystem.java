/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.RobotMap;
import frc.robot.commands.ArmDirectional;
// import frc.robot.commands.ArmStowed;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

/**
 * Add your docs here.
 */
public class RollerArm_Subsystem extends PIDSubsystem {
  /**
   * Add your docs here.
   */
  TalonSRX L_ArmSRX = new TalonSRX(RobotMap.Mecanum_SRX_ID_1);
  TalonSRX R_ArmSRX = new TalonSRX(RobotMap.Mecanum_SRX_ID_2);

  public RollerArm_Subsystem() {
    // Intert a subsystem name and PID values here
    super("RollerArmPID_Subsystem", 0.00009, 0, 0);
    // Use these to get going:
    // setSetpoint() - Sets where the PID controller should move the system
    // to
    // enable() - Enables the PID controller.
    enable();//setup encoders
    setAbsoluteTolerance(0);//setup encoders
    L_ArmSRX.setSensorPhase(false);//setup encoders
    L_ArmSRX.setSelectedSensorPosition(0, 0, 1); //setup encoders

    L_ArmSRX.configPeakCurrentLimit(15,0); //set max amps to 15
    L_ArmSRX.configPeakCurrentDuration(0  ,30);
		L_ArmSRX.configContinuousCurrentLimit(10, 0);
		L_ArmSRX.enableCurrentLimit(true);

  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new ArmDirectional());
  }

  @Override
  protected double returnPIDInput() {
    // Return your input value for the PID loop
    // e.g. a sensor, like a potentiometer:
    // yourPot.getAverageVoltage() / kYourMaxVoltage;
    return L_ArmSRX.getSelectedSensorPosition(0);
  }

  @Override
  protected void usePIDOutput(double output) {
    // Use output to drive your system, like a motor
    // e.g. yourMotor.set(output);
    L_ArmSRX.set(ControlMode.PercentOutput, output);
    R_ArmSRX.set(ControlMode.PercentOutput, output);
  }
}
