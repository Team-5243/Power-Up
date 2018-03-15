package org.usfirst.frc.team5243.robot.commands.auton;

import org.usfirst.frc.team5243.robot.Robot;
import org.usfirst.frc.team5243.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveBack extends Command {

	DriveSubsystem driveSubsystem;
	
    public DriveBack() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	driveSubsystem = Robot.driveSubsystem;
    	requires(driveSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	driveSubsystem.driveBack();    	
    	System.out.println("DriveBack is running");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return driveSubsystem.hasCollided();
    }

    // Called once after isFinished returns true
    protected void end() {
    	driveSubsystem.stopMotors();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	driveSubsystem.stopMotors();
    }
}
