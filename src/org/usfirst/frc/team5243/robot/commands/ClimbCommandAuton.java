package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;
import org.usfirst.frc.team5243.robot.subsystems.ClimbSubsystem;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;




public class ClimbCommandAuton extends Command {

	ClimbSubsystem climbSubsystem;
	boolean isLift;
	boolean isFinished;
	double start;
	double percent;

	/**
	 * Contructor for extending or retracting the climb mechanism
	 * @param d true if the climb mechanism should be lifting, false if the climb mechanism should be lowering
	 */
	public ClimbCommandAuton(boolean on, double per) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		start = Timer.getFPGATimestamp();
		climbSubsystem = Robot.climbSubsystem;
		requires(climbSubsystem);
		isLift = on;
		percent = per;
		isFinished = false;

	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if(isLift) {
			System.out.println("lift called");
			climbSubsystem.liftAuton(percent);
		}
		else {
			System.out.println("lower called");
			climbSubsystem.lowerAuton(percent);
		}
		if(climbSubsystem.getActuatorSpeeds() == 0.0) {
    		isFinished = true;
    	}

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return isFinished;
	}

	// Called once after isFinished returns true
	protected void end() {
		double end = Timer.getFPGATimestamp();
		climbSubsystem.stopActuators();
		System.out.println("Finished");
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		climbSubsystem.stopActuators();
		this.end();
	}
}