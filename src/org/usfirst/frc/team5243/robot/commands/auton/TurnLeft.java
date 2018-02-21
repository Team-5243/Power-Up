package org.usfirst.frc.team5243.robot.commands.auton;

import org.usfirst.frc.team5243.robot.Robot;
import org.usfirst.frc.team5243.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnLeft extends Command {
	DriveSubsystem driveSubsystem;
	boolean fin;
	int deg;
	
	/**
	 * Command for turning the robot left
	 * @param degrees the number of degrees the robot should turn lefts
	 */
    public TurnLeft(int degrees) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	driveSubsystem = Robot.driveSubsystem;
        requires(driveSubsystem);
        deg = degrees;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	driveSubsystem.zeroYaw();
    	fin = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println("Turning Left");
    	driveSubsystem.rotateLeft(-deg);
    	if (driveSubsystem.isStopped()) {
    		fin = true;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return fin;
    }

    // Called once after isFinished returns true
    protected void end() {
    	driveSubsystem.stopMotors();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
