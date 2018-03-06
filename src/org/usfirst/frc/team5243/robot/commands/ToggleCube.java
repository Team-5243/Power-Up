package org.usfirst.frc.team5243.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ToggleCube extends Command {

	//CubeSubsystem cubeSubsystem;
	
    public ToggleCube() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	//cubeSubsystem = Robot.cubeSubsystem;
    	//requires(cubeSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//cubeSubsystem.toggle();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
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
