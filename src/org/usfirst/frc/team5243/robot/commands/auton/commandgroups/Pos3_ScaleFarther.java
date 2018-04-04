package org.usfirst.frc.team5243.robot.commands.auton.commandgroups;

import org.usfirst.frc.team5243.robot.commands.ChangeCubeSolAuton;
import org.usfirst.frc.team5243.robot.commands.ClimbCommandAuton;
import org.usfirst.frc.team5243.robot.commands.DriveStraightHalfSpeed;
import org.usfirst.frc.team5243.robot.commands.auton.DriveStraight;
import org.usfirst.frc.team5243.robot.commands.auton.TurnLeft;
import org.usfirst.frc.team5243.robot.commands.auton.TurnRight;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Pos3_ScaleFarther extends CommandGroup { //TODO: test and fix any measurements or placements of commands

	/*
	 * Requested by: Small (God)
	 * Pos1_ScaleFather()'s intended trail is to go straight until it reaches the perimeter of the scale
	 * It will then turn left 90 degrees and go across the field until parallel to our scale side
	 * When parallel to the correct scale side, it will turn right and move forward and then "place" the cube
	 */

    public Pos3_ScaleFarther() {
    	addSequential(new ChangeCubeSolAuton(Value.kReverse));
    	addSequential(new DriveStraight(228)); //17 feet <POSSIBLY TOO SHORT>
    	addSequential(new TurnLeft(55)); //65 equals 90 for some reason... idk
    	//addParallel(new CubeDartCommandAuton(true, .93)); //may need to be moved
    	addSequential(new DriveStraight(246)); //18.5 feet <POSSIBLY TOO FAR>
    	addSequential(new TurnRight(55));
    	addSequential(new ClimbCommandAuton(true, 1));
    	addSequential(new DriveStraightHalfSpeed(54)); //4.5 ft (half speed)
    	addSequential(new ChangeCubeSolAuton(Value.kForward)); //may need to be moved
    	
    }
}
