package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;
import org.usfirst.frc.team5243.robot.subsystems.ClimbSubsystem;
import org.usfirst.frc.team5243.robot.subsystems.CubeSubsystem;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;




public class ClimbCommandTeleop extends Command {

	ClimbSubsystem climbSubsystem;
	CubeSubsystem cubeSubsystem;
	boolean isLift;
	boolean isFinished;
	double start;

	/**
	 * Contructor for extending or retracting the climb mechanism
	 * @param d true if the climb mechanism should be lifting, false if the climb mechanism should be lowering
	 */
	public ClimbCommandTeleop(boolean on) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		start = Timer.getFPGATimestamp();
		cubeSubsystem = Robot.cubeSubsystem;
		climbSubsystem = Robot.climbSubsystem;
		requires(climbSubsystem);
		requires(cubeSubsystem);
		isLift = on;
		isFinished = false;

	}

	// Called just before this Command runs the first time
	protected void initialize() {
		
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if(isLift) {
			cubeSubsystem.retract();
			System.out.println("lift called");
			climbSubsystem.lift();
		}
		else {
			System.out.println("lower called");
			climbSubsystem.lower();
		}
		/*if(climbSubsystem.getActuatorSpeed() == 0.0) {
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
		climbSubsystem.stopActuators();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		climbSubsystem.stopActuators();
		this.end();
	}
}