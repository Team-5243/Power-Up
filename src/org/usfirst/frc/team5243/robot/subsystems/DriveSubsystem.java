package org.usfirst.frc.team5243.robot.subsystems;

import org.usfirst.frc.team5243.robot.Robot;
import org.usfirst.frc.team5243.robot.RobotMap;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class DriveSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	VictorSP frontLeft;
	VictorSP frontRight;
	VictorSP backLeft;
	VictorSP backRight;
	SpeedControllerGroup left;
	SpeedControllerGroup right;
	
	DifferentialDrive drive;
	
	public DriveSubsystem() {
		frontLeft = new VictorSP(RobotMap.frontLeft);
		frontRight = new VictorSP(RobotMap.frontRight);
		backLeft = new VictorSP(RobotMap.backLeft);
		backRight = new VictorSP(RobotMap.backRight);
		left = new SpeedControllerGroup(frontLeft, backLeft);
		right = new SpeedControllerGroup(frontRight, backRight);
		
		drive = new DifferentialDrive(right, left);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void tankDrive() {
    	drive.tankDrive(Robot.oi.getLeftStick().getY(), Robot.oi.getRightStick().getY());
    }
}

