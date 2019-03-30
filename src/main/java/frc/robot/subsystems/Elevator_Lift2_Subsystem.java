/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.commands.Lift_Stop;

/**
 * Add your docs here.
 */
public class Elevator_Lift2_Subsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  TalonSRX Elevator_Talon_1 = new TalonSRX(RobotMap.Elevator_Talon_1_ID);
  TalonSRX Elevator_Talon_2 = new TalonSRX(RobotMap.Elevator_Talon_2_ID);
  
  public Elevator_Lift2_Subsystem(){
    Elevator_Talon_1.configPeakCurrentLimit(15, 0);
    Elevator_Talon_1.configPeakCurrentDuration(0, 30);
    Elevator_Talon_1.configContinuousCurrentLimit(10, 0);
    Elevator_Talon_1.enableCurrentLimit(true);
  }

  public void Lift_Up() {
    Elevator_Talon_1.set(ControlMode.PercentOutput, 0.4);
    Elevator_Talon_2.set(ControlMode.PercentOutput, 0.4);
  }

  public void Lift_Down() {
    Elevator_Talon_1.set(ControlMode.PercentOutput, -0.2);
    Elevator_Talon_2.set(ControlMode.PercentOutput, -0.2);
  }

  public void Lift_Stop() {
    Elevator_Talon_1.set(ControlMode.PercentOutput, 0);
    Elevator_Talon_2.set(ControlMode.PercentOutput, 0);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new Lift_Stop());
  }
}
