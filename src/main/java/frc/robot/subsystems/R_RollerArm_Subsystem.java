/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.RobotMap;
import frc.robot.commands.ArmStowed;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

/**
 * Add your docs here.
 */
public class R_RollerArm_Subsystem extends PIDSubsystem {
  /**
   * Add your docs here.
   */
  TalonSRX R_ArmSRX = new TalonSRX(RobotMap.MecanumArmRightSRXID);

  public R_RollerArm_Subsystem() {
    // Intert a subsystem name and PID values here
    super("R_RollerArmPID_Subsystem", 0.00009, 0, 0);
    // Use these to get going:
    // setSetpoint() - Sets where the PID controller should move the system
    // to
    // enable() - Enables the PID controller.
    enable();//setup encoders
    setAbsoluteTolerance(0);//setup encoders
    R_ArmSRX.setSensorPhase(false);//setup encoders
    R_ArmSRX.setSelectedSensorPosition(0, 0, 1); //setup encoders

    R_ArmSRX.configPeakCurrentLimit(15,0); //set max amps to 15
    R_ArmSRX.configPeakCurrentDuration(0  ,30);
		R_ArmSRX.configContinuousCurrentLimit(10, 0);
		R_ArmSRX.enableCurrentLimit(true);

  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new ArmStowed());

  }

  @Override
  protected double returnPIDInput() {
    // Return your input value for the PID loop
    // e.g. a sensor, like a potentiometer:
    // yourPot.getAverageVoltage() / kYourMaxVoltage;
    return R_ArmSRX.getSelectedSensorPosition(0);
  }

  @Override
  protected void usePIDOutput(double output) {
    // Use output to drive your system, like a motor
    // e.g. yourMotor.set(output);
    R_ArmSRX.set(ControlMode.PercentOutput, output);
  }
}
