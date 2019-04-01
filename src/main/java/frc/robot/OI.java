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
import edu.wpi.first.wpilibj.GenericHID;


/*COMMADS */
import frc.robot.commands.Shark_Down;
import frc.robot.commands.Shark_Up;
import frc.robot.commands.Lift_Up;
import frc.robot.commands.Lift_Down;
import frc.robot.commands.RollerTunnelBox_Group;
import frc.robot.commands.RollerTunnelBox_GroupReverse;
import frc.robot.commands.MecanumArmRollerDeploy;;






/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */


public class OI {
//// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);

  //Joystick
  static Joystick stick0 = new Joystick(RobotMap.JoystickPort);
  
  //Trigger
  public JoystickAnalogButton LTrigger = new JoystickAnalogButton(stick0, RobotMap.LTrigger);
  public JoystickAnalogButton RTrigger = new JoystickAnalogButton(stick0, RobotMap.RTrigger);
  
  //Center Console
  Button RMiddle = new JoystickButton(stick0, RobotMap.RMiddle); //
  Button LMiddle = new JoystickButton(stick0, RobotMap.LMiddle); //
  
  //Letter button
  Button buttonX  = new JoystickButton(stick0, RobotMap.ButtonX); 
  Button buttonY = new JoystickButton(stick0, RobotMap.ButtonY); 
  Button buttonA  = new JoystickButton(stick0, RobotMap.ButtonA);
  Button buttonB = new JoystickButton(stick0, RobotMap.ButtonB); 

  //Bumper
  Button LBumper = new JoystickButton(stick0, RobotMap.LBumper); 
  Button RBumper = new JoystickButton(stick0, RobotMap.RBumper); 


  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.



  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  public OI() {

   /*Buttons */
    buttonX.whileHeld(new Shark_Up()); 
    buttonA.whileHeld(new Shark_Down());

    buttonY.whenPressed(new MecanumArmRollerDeploy() ); 

    /*Bumpers */
    LBumper.whileHeld(new Lift_Up());
    LTrigger.whileHeld(new Lift_Down());

    RBumper.whileHeld(new RollerTunnelBox_Group() ); // command group with tunnel, box, and rollers
    RTrigger.whileHeld(new RollerTunnelBox_GroupReverse() ); // command group with tunnel, box, and rollers


  }
  
  public static int GetDPadAngle() {
    return stick0.getPOV();
  } 

  public class JoystickAnalogButton extends Button {

    GenericHID m_joystick;
    int m_axisNumber;
    private double THRESHOLD = 0.5;
  
    /**
     * Create a button for triggering commands off a joystick's analog axis
     * 
     * @param joystick The GenericHID object that has the button (e.g. Joystick, KinectStick, etc)
     * @param axisNumber The axis number
     */
    public JoystickAnalogButton(GenericHID joystick, int axisNumber) {
        m_joystick = joystick;
        m_axisNumber = axisNumber;
    }
  
    /**
     * Create a button for triggering commands off a joystick's analog axis
     * 
     * @param joystick The GenericHID object that has the button (e.g. Joystick, KinectStick, etc)
     * @param axisNumber The axis number
     * @param threshold The threshold to trigger above (positive) or below (negative)
     */
    public JoystickAnalogButton(GenericHID joystick, int axisNumber, double threshold) {
      m_joystick = joystick;
      m_axisNumber = axisNumber;
      THRESHOLD = threshold;
    }
  
    /**
     * Set the value above which triggers should occur (for positive thresholds)
     *  or below which triggers should occur (for negative thresholds)
     * The default threshold value is 0.5
     *  
     * @param threshold the threshold value (1 to -1)
     */
    public void setThreshold(double threshold){
      THRESHOLD = threshold;
    }
   
    /**
     * Get the defined threshold value.
     * @return the threshold value
     */
    public double getThreshold(){
      return THRESHOLD;
    }
    
  
    public boolean get() {
      if(THRESHOLD < 0){
        return m_joystick.getRawAxis(m_axisNumber) < THRESHOLD;    //Return true if axis value is less than negative threshold
      } else {
        return m_joystick.getRawAxis(m_axisNumber) > THRESHOLD;    //Return true if axis value is greater than positive threshold
      }
    }
  }

    public static double getLeftStickY(){
      return (stick0.getRawAxis(RobotMap.LeftJoystickID));
    
    }

    public static double getRightStickY(){
      return (stick0.getRawAxis(RobotMap.RightJoystickID));
    }
}