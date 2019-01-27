/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

//Import additional commands *probably could be done in one line of code as command file
import frc.robot.commands.HatchArm_Feeder;
import frc.robot.commands.HatchArm_Ground;
import frc.robot.commands.HatchArm_Stowed;



/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

  //Joystick rightjoy = new Joystick(RobotMap.joystick1port);  //DK added to create new joystick input
  Joystick stick0 = new Joystick(0); //create new joystick input

  Button StowBut = new JoystickButton(stick0, 2); //b button
  Button GroundBut = new JoystickButton(stick0, 3); //x button
  Button FeedBut = new JoystickButton(stick0, 4); // y button


public OI() {
  //runs specific command when pressed
  StowBut.whenPressed(new HatchArm_Stowed());
  GroundBut.whenPressed(new HatchArm_Ground());
  FeedBut.whenPressed(new HatchArm_Feeder());


}



}

