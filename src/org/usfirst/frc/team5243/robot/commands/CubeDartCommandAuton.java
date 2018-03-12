package org.usfirst.frc.team5243.robot.commands;

import org.usfirst.frc.team5243.robot.Robot;
import org.usfirst.frc.team5243.robot.subsystems.CubeSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CubeDartCommandAuton extends Command {
	
	boolean isForward; //boolean used to deide whether to pull or push the cube mechanism
	boolean isFinished;
	double voltage;
	CubeSubsystem cubeSubsystem;
    public CubeDartCommandAuton(boolean slideF, double vol) {
    	//slide is true when pushButton is pressed and false when pullBUtton is pressed
        // Use requires() here to declare subsystem dependencies
    	cubeSubsystem = Robot.cubeSubsystem;
    	requires(cubeSubsystem);
    	isForward = slideF;
    	voltage = vol;
    	isFinished = false;
    	
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
    	if(isForward) {
    		cubeSubsystem.extendDartAuton(voltage);
    		System.out.println("Cube Dart Auton Extending");
    	} else {
    		cubeSubsystem.retractDartAuton(voltage);
    		System.out.println("Cube Dart Auton Retracting");
    	}
    	
    	if(cubeSubsystem.getCubeDartSpeed() == 0.0) {
    		isFinished = true;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isFinished;
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
