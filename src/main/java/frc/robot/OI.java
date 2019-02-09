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

import frc.robot.commands.TurnLeft;
import frc.robot.commands.TurnRight;
<<<<<<< HEAD
import frc.robot.commands.TurnOnAngle;
import frc.robot.commands.Forward;;

=======
import frc.robot.commands.getLimelightX;
>>>>>>> 7644a0975f8bd564bed6cf608a6baa7615c9f0de


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  static Joystick stick0 = new Joystick(0);
  

//// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.
  Button buttonA = new JoystickButton(stick0, RobotMap.ButtonA);
  Button buttonX = new JoystickButton(stick0, RobotMap.ButtonX);
  Button buttonY = new JoystickButton(stick0, RobotMap.ButtonY);
  Button buttonB = new JoystickButton(stick0, RobotMap.ButtonB);



  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
  public OI(){
    buttonA.whenPressed(new TurnLeft(90));
    buttonX.whenPressed(new TurnRight(90));
<<<<<<< HEAD
    buttonY.whenPressed(new TurnOnAngle(xAngle));
    buttonB.whenPressed(new Forward(12)); //inches-move to robot map


=======
    buttonY.whenPressed(new getLimelightX());
>>>>>>> 7644a0975f8bd564bed6cf608a6baa7615c9f0de
  }
    public static double getLeftStickY(){
      return (stick0.getRawAxis(RobotMap.LeftJoystickID));
    
    }

    public static double getRightStickY(){
      return (stick0.getRawAxis(RobotMap.RightJoystickID));
    }
}