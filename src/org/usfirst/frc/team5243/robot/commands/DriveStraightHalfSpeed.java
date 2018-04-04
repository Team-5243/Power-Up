package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;
import org.usfirst.frc.team5243.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveStraightHalfSpeed extends Command {

	DriveSubsystem driveSubsystem;
	double dis;
	boolean isFinished;
	/**
	 * Command for driving the robot straight
	 * @param distance the distance the robot should drive straight
	 */
    public DriveStraightHalfSpeed(double distance) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	dis = distance;
    	driveSubsystem = Robot.driveSubsystem;
    	requires(driveSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	driveSubsystem.zeroYaw();
    	driveSubsystem.driveStraight(dis);
    	isFinished = true;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println("DriveStraightHalfSpeed is running");

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isFinished;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
