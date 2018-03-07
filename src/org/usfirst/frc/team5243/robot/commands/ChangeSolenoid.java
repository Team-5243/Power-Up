package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;
import org.usfirst.frc.team5243.robot.subsystems.CubeSubsystem;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;




public class ChangeSolenoid extends Command {

	Value direction;
	CubeSubsystem cubeSubsystem;
	
	/**
	 * Contructor for changing the state of the solenoid
	 * @param on the state the solenoid should be
	 */
    public ChangeSolenoid(Value direction) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.direction = direction;
    	cubeSubsystem = Robot.cubeSubsystem;
    	requires(cubeSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	cubeSubsystem.setCubeSolenoid(direction);
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
