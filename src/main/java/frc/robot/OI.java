/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

//Import additional commands 
import frc.robot.commands.HatchArm_Feeder;
import frc.robot.commands.HatchArm_Ground;
import frc.robot.commands.HatchArm_Stowed;



/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

  //Joystick rightjoy = new Joystick(RobotMap.joystick1port);  //DK added to create new joystick input
  Joystick stick0 = new Joystick(RobotMap.controllerPort); //create new joystick input

  Button ButtonB = new JoystickButton(stick0, RobotMap.ButtonB);
  Button ButtonX = new JoystickButton(stick0, RobotMap.ButtonX);
  Button ButtonY = new JoystickButton(stick0, RobotMap.ButtonY);


  //public static final int HatchArm_Enc = 9;

public OI() {
  //runs specific command when pressed
  ButtonB.whenPressed(new HatchArm_Stowed()); //b button
  ButtonX.whenPressed(new HatchArm_Ground());//x
  ButtonY.whenPressed(new HatchArm_Feeder()); //y
}


}

