/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;
public static int Joystick_Port = 0;
public static int Feeder_Height_Trigger = 1;
public static int SRX_Test_Trigger = 2;
public static int Ball_Rocket_Low_Trigger = 3;
public static int Cargo_Load_Trigger = 4;

  public static int Elevator_Talon_1_ID = 6;
  public static int Elevator_Talon_2_ID = 7;

  public int Elevator_Height = 1; {
    if (Elevator_Height < 1) {
      Elevator_Height = 1;
    }
    if (Elevator_Height > 3) {
      Elevator_Height = 3;
    }
  }

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
}
