package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.subsystems.CubeSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SlideCubeCommand extends Command {
	boolean slidesF; //boolean used to deide whether to pull or push the cube mechanism
	CubeSubsystem cubeSubsystem;
    public SlideCubeCommand(boolean slide) {
    	//slide is true when pushButton is pressed and false when pullBUtton is pressed
    	cubeSubsystem = new CubeSubsystem();        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	slidesF = slide;
    	requires(cubeSubsystem);
    	
    	
    	
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//if the button to push is pressed, the mechanism is pushed out
    	/*if(slidesF) 
    		cubeSubsystem.pushOut();
    	//if the button to pull is pressed, the mechanism is pulled in
    	else 
    		cubeSubsystem.pullIn();*/
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
