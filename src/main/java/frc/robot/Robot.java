/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.commands.Set_LEDs_BLUE;
import frc.robot.commands.Set_LEDs_RED;
import frc.robot.subsystems.Arduino_LED_Subsystem;
import frc.robot.subsystems.BabyShark_Subsystem;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.LDriveTrain_Subsystem;
import frc.robot.subsystems.RDriveTrain_Subsystem;
import edu.wpi.first.wpilibj.DriverStation;
//import frc.robot.subsystems.Hatch_Intake_Subsystem;
import frc.robot.subsystems.Box_Subsystem;
import frc.robot.subsystems.Roller_Subsystem;
import frc.robot.subsystems.RollerArm_Subsystem;
//import frc.robot.subsystems.Elevator_Lift_Subsystem;
//import frc.robot.subsystems.BabyShark_Subsystem;
//Additional Subsystem imports
import frc.robot.subsystems.Tunnel_Subsystem;
import frc.robot.subsystems.Elevator_Lift2_Subsystem;

import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

import edu.wpi.cscore.AxisCamera;
import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.first.cameraserver.CameraServer;


/**

 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public static ExampleSubsystem m_subsystem = new ExampleSubsystem();
  public static OI m_oi;

  Thread m_visionThread;

  Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  //New Subsystems
  public static Tunnel_Subsystem Tunnel = new Tunnel_Subsystem();
  public static RDriveTrain_Subsystem RDriveTrain = null;
  public static LDriveTrain_Subsystem LDriveTrain = null;
  public static Arduino_LED_Subsystem Arduino_LED = new Arduino_LED_Subsystem();
  public static Box_Subsystem Box_Subsystem = new Box_Subsystem(); 
  //public static Hatch_Intake_Subsystem Hatch_Intake_Subsystem = new Hatch_Intake_Subsystem(); 
  public static Roller_Subsystem Roller = new Roller_Subsystem();
  public static RollerArm_Subsystem Roller_Arm = new RollerArm_Subsystem();
 // public static Elevator_Lift2_Subsystem Elevator_Lift_Subsystem = new Elevator_Lift2_Subsystem();
  public static BabyShark_Subsystem Shark = new BabyShark_Subsystem();
  public static Elevator_Lift2_Subsystem Lift2 = new Elevator_Lift2_Subsystem();

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {

    m_visionThread = new Thread(() -> {
      // Get the Axis camera from CameraServer
      AxisCamera camera
          = CameraServer.getInstance().addAxisCamera("10.30.8.11:5800");
      // Set the resolution
      camera.setResolution(640, 480);

      // Get a CvSink. This will capture Mats from the camera
      CvSink cvSink = CameraServer.getInstance().getVideo();
      // Setup a CvSource. This will send images back to the Dashboard
      CvSource outputStream
          = CameraServer.getInstance().putVideo("Rectangle", 640, 480);

      // Mats are very memory expensive. Lets reuse this Mat.
      Mat mat = new Mat();

      // This cannot be 'true'. The program will never exit if it is. This
      // lets the robot stop this thread when restarting robot code or
      // deploying.
      while (!Thread.interrupted()) {
        // Tell the CvSink to grab a frame from the camera and put it
        // in the source mat.  If there is an error notify the output.
        if (cvSink.grabFrame(mat) == 0) {
          // Send the output the error.
          outputStream.notifyError(cvSink.getError());
          // skip the rest of the current iteration
          continue;
        }
        // Put a rectangle on the image
        Imgproc.rectangle(mat, new Point(100, 100), new Point(400, 400),
            new Scalar(255, 255, 255), 5);
        // Give the output stream a new image to display
        outputStream.putFrame(mat);
      }
    });
    m_visionThread.setDaemon(true);
    m_visionThread.start();

    RDriveTrain = new RDriveTrain_Subsystem();
    LDriveTrain = new LDriveTrain_Subsystem();
    
    m_oi = new OI();
    //m_chooser.setDefaultOption("Default Auto", new ExampleCommand());
    // chooser.addOption("My Auto", new MyAutoCommand());
    //SmartDashboard.putData("Auto mode", m_chooser);

    //SmartDashboard.putData("LEDs Blue", new Set_LEDs_BLUE());
    //SmartDashboard.putData("LEDs Red", new Set_LEDs_RED());
    //SmartDashboard.putData("PArty", new Set_LEDs_PartyMode());

    SmartDashboard.putData(Roller_Arm);
    SmartDashboard.putData(Tunnel);
    //SmartDashboard.putData(RDriveTrain);
    //SmartDashboard.putData(LDriveTrain);
    SmartDashboard.putData(Arduino_LED);
    SmartDashboard.putData(Box_Subsystem);
    SmartDashboard.putData(Roller);
    //SmartDashboard.putData(Elevator_Lift_Subsystem);
    SmartDashboard.putData(Shark);
    SmartDashboard.putData(Lift2);

    DriverStation.Alliance color;
    color = DriverStation.getInstance().getAlliance();
    if(color == DriverStation.Alliance.Blue){
      new Set_LEDs_BLUE().start();
    }
    else{
      new Set_LEDs_RED().start();
    }
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
   */
  @Override
  public void disabledInit() {
    //Set LEDs to party mode
    Robot.Arduino_LED.Party.set(true); //turn on party mode

    
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString code to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_chooser.getSelected();

    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector",
     * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
     * = new MyAutoCommand(); break; case "Default Auto": default:
     * autonomousCommand = new ExampleCommand(); break; }
     */

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.start();
    }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}