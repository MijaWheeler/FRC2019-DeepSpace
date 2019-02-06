/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.Robot;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

/**
 * Add your docs here.
 */
public class L_DriveTrain_Subsystem extends Subsystem {
  public CANSparkMax MotorL1 = new CANSparkMax(RobotMap.MotorL1ID,MotorType.kBrushless);
  public CANSparkMax MotorL2 = new CANSparkMax(RobotMap.MotorL2ID,MotorType.kBrushless);
  public CANSparkMax MotorL3 = new CANSparkMax(RobotMap.MotorL3ID,MotorType.kBrushless);

  public void DriveBackLDriveTrain(){
    Robot.LDriveTrain.MotorL1.set(-0.5);
    Robot.LDriveTrain.MotorL2.set(-0.5);
    Robot.LDriveTrain.MotorL3.set(-0.5);
  }

  public void DriveForLDriveTrain(){
    Robot.LDriveTrain.MotorL1.set(0.5);
    Robot.LDriveTrain.MotorL2.set(0.5);
    Robot.LDriveTrain.MotorL3.set(0.5);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
