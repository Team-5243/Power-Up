package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;
import org.usfirst.frc.team5243.robot.subsystems.CubeSubsystem;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CubeBeltCommandAuton extends Command {

	CubeSubsystem cubeSubsystem;
	boolean isIntake;
	boolean isFinished;
	double time;
	double start;
	
    public CubeBeltCommandAuton(boolean in, double sec) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	start = Timer.getFPGATimestamp();
    	isIntake = in;
    	time = sec;
    	isFinished = false;
    	cubeSubsystem = Robot.cubeSubsystem;
    	requires(cubeSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }
 
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(isIntake) {
    		cubeSubsystem.intakeCube();
    	} else {
    		cubeSubsystem.releaseCube();
    	}
    	if(Timer.getFPGATimestamp() - start == time) {
    		isFinished = true;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isFinished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	cubeSubsystem.stopBelts();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	cubeSubsystem.stopBelts();
    }
}
