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
import frc.robot.commands.Hatch_Intake_On_For_T;
import frc.robot.commands.Print_Left_Trigger;
import frc.robot.commands.Print_Right_Trigger;
import frc.robot.commands.Hatch_Intake_Off;

import edu.wpi.first.wpilibj.GenericHID;



/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  Joystick stick0 = new Joystick(0);
  


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
  Button button1 = new JoystickButton(stick0, 1);
  Button button2 = new JoystickButton(stick0, 2);
  
  public JoystickAnalogButton TriggerR = new JoystickAnalogButton(stick0, 3, -0.5);
  public JoystickAnalogButton TriggerL = new JoystickAnalogButton(stick0, 3, 0.5);

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());
  public OI() {
    // button1.whileHeld(new Hatch_Intake_On());
    button1.whenPressed(new Hatch_Intake_On_For_T());
    button2.whenPressed(new Hatch_Intake_Off());

    TriggerR.whenPressed(new Print_Right_Trigger());
    TriggerL.whenPressed(new Print_Left_Trigger());
  }

  // Run the command while the button is being held down and interrupt it once
  // the button i s released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());

   /* public static double getLeftStickY(){
      return (stick0.getRawAxis(1));
    
    }

    public static double getRightStickY(){
      return (stick0.getRawAxis(5));
    } */
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
}

