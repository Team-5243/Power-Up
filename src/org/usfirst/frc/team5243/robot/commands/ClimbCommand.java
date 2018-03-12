package org.usfirst.frc.team5243.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ClimbCommand extends Command {
	
	/*ClimbSubsystem climbSubsystem;
	boolean isLift;
	boolean isFinished;
	double start;*/
	
    public ClimbCommand(boolean lift) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	/*start = Timer.getFPGATimestamp();
    	climbSubsystem = new ClimbSubsystem();
    	requires(climbSubsystem);
    	isLift = lift;
    	isFinished = false;*/

    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	/*if(isLift) {
    		climbSubsystem.lift();
    	}
    	else {
    		climbSubsystem.lower();
    	}
    	if(climbSubsystem.getActuatorSpeed() == 0.0) {
    		this.end();
    	}*/
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	double end = Timer.getFPGATimestamp();
    	//climbSubsystem.stopActuators();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	//climbSubsystem.stopActuators();
    }
}
