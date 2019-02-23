/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.commands.Elevator_Height_Position;
import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;

/**
 * Add your docs here.
 */

public class Elevator_Lift_Subsystem extends PIDSubsystem {
  /**
   * Add your docs here.
   */
  TalonSRX Elevator_Talon_1 = new TalonSRX(RobotMap.Elevator_Talon_1_ID);
  TalonSRX Elevator_Talon_2 = new TalonSRX(RobotMap.Elevator_Talon_2_ID);


  public int Elevator_Height = 0;

  public Elevator_Lift_Subsystem() {
    // Intert a subsystem name and PID values here
    super("Elevator_Lift_Subsystem", 0.00008, 0, 0);
    // Use these to get going:
    // setSetpoint() - Sets where the PID controller should move the system
    // to
    // enable() - Enables the PID controller.
    enable();
    setAbsoluteTolerance(0);

    Elevator_Talon_1.setSensorPhase(true);
    Elevator_Talon_1.setSelectedSensorPosition(0, 0, 1);

    Elevator_Talon_1.configPeakCurrentLimit(15, 0);
    Elevator_Talon_1.configPeakCurrentDuration(0, 30);
    Elevator_Talon_1.configContinuousCurrentLimit(10, 0);
    Elevator_Talon_1.enableCurrentLimit(true);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new Elevator_Height_Position());
  }

  @Override
  protected double returnPIDInput() {
    // Return your input value for the PID loop
    // e.g. a sensor, like a potentiometer:
    // yourPot.getAverageVoltage() / kYourMaxVoltage;
    return Elevator_Talon_1.getSelectedSensorPosition(0);
  }

  @Override
  protected void usePIDOutput(double output) {
    // Use output to drive your system, like a motor
    // e.g. yourMotor.set(output);
    Elevator_Talon_1.set(ControlMode.PercentOutput, output);
    Elevator_Talon_2.set(ControlMode.PercentOutput, output);
  }

  public void MO_Up() {
    if (this.Elevator_Height == 5) {
      return;
    } else {
      this.Elevator_Height = this.Elevator_Height + 1;
      System.out.println(this.Elevator_Height);
    }
  }

  public void MO_Down() {
    if (this.Elevator_Height == 0) {
      return;
    } else {
      this.Elevator_Height = this.Elevator_Height - 1;
      System.out.println(this.Elevator_Height);
    }
  }
}
