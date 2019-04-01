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

 /*CONTROLER */ 
  //Joystick port
  public static int JoystickPort = 0;
  
  //left motor ID
  public static int MotorL1ID = 1;
  public static int MotorL2ID = 3;
  public static int MotorL3ID = 5;

  //right motor ID
  public static int MotorR1ID = 0;
  public static int MotorR2ID = 2;
  public static int MotorR3ID = 4;

  //letter buttons on right
  public static int ButtonA = 1;
  public static int ButtonB = 2;
  public static int ButtonX = 3;
  public static int ButtonY = 4;

  //trigger IDs
  public static int LTrigger = 2;
  public static int RTrigger = 3;

  //LB and RB on back
  public static int LBumper = 5;
  public static int RBumper = 6;

  //back and start on remote
  public static int LMiddle = 7;
  public static int RMiddle = 8;

  //left and right joystick ID and left and right SRjoystick button ID
  public static int LJoystickBtn = 9;
  public static int RJoystickBtn = 10;
  public static int LeftJoystickID = 1;  
  public static int RightJoystickID = 5;

  /*MOTOR CONTROL */
  public static int TunnelSparkCANID = 0;
  public static int HatchSolCANID = 12;

  //mecanum roller arm talons
  public static int Mecanum_Talon_ID_1 = 11; 
  public static int Mecanum_Talon_ID_2 = 9;

  //elevator talons
  public static int Elevator_Talon_1_ID = 6;
  public static int Elevator_Talon_2_ID = 7;

  //Baby Shark talon
  public static int Shark_Talon_ID = 8;


  //arrays for encoder positivalues
  public static int[] Height_List = new int[] {476, 1314, 5022, 6487, 9454, 11809};


  //Mecanum Arm Roller Setpoints
  public static int RA_Deploy = -6000; //ball intake
  public static int RA_Stow = 0; //defalt
  public static int RA_Reset = 6000;

  
}
