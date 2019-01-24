/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.BallTransport;


/**
 * Add your docs here.
 */
public class BallTransport_Subsystem extends Subsystem {
  public WPI_TalonSRX motor1 = new WPI_TalonSRX(10);
  public WPI_TalonSRX motor2 = new WPI_TalonSRX(11);
  public WPI_TalonSRX motor3 = new WPI_TalonSRX(12);
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new BallTransport());
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
