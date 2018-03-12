package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;
import org.usfirst.frc.team5243.robot.subsystems.ClimbSubsystem;
import org.usfirst.frc.team5243.robot.subsystems.CubeSubsystem;

import edu.wpi.first.wpilibj.command.Command;


public class CubeDartCommandTeleop extends Command {
	
	CubeSubsystem cubeSubsystem;
	ClimbSubsystem climbSubsystem;
	boolean isExtending;
    	
	/**
	 * Constructor for extending or retracting the cube mechanism
	 * @param isEx true if the cube mechanism should be extending, false if the cube mechanism should be retracting
	 */
	public CubeDartCommandTeleop(boolean isEx) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
		cubeSubsystem = Robot.cubeSubsystem;
		climbSubsystem = Robot.climbSubsystem;
		requires(cubeSubsystem);
		requires(climbSubsystem);
		isExtending = isEx;
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    /**
     * The first if statement serves as a limit for the cube dart actuator when the arms are lifting/lowering to
     * ensure that the robot stays within the size limit.
     */
    
    protected void execute() { //TODO: Test the limit values
    		if(isExtending) {
        		cubeSubsystem.extendCubeDart();
        		//System.out.println("extending");
        	} else { 
        		cubeSubsystem.retractCubeDart();
        		//System.out.println("retracting");
        	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	cubeSubsystem.stopCubeDart();
    }
}