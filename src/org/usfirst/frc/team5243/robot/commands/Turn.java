package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;
import org.usfirst.frc.team5243.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Turn extends Command {

	DriveSubsystem driveSubsystem;
	int degrees;
	
    public Turn(int degrees) {
    	this.degrees = degrees;
    	driveSubsystem = Robot.driveSubsystem;
        requires(driveSubsystem);

    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//driveSubsystem.turn(degrees);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

    	//cubePinSubsystem.pressureManage();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
