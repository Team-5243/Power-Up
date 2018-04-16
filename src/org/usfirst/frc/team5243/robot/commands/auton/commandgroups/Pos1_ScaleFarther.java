package org.usfirst.frc.team5243.robot.commands.auton.commandgroups;

import org.usfirst.frc.team5243.robot.commands.CubeClampSolAuton;
import org.usfirst.frc.team5243.robot.commands.CubeFlipSolAuton;
import org.usfirst.frc.team5243.robot.commands.auton.DriveStraight;
import org.usfirst.frc.team5243.robot.commands.auton.TurnLeft;
import org.usfirst.frc.team5243.robot.commands.auton.TurnRight;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Pos1_ScaleFarther extends CommandGroup { //TODO: test and fix any measurements or placements of commands

	/*
	 * Requested by: Small (God)
	 * Pos1_ScaleFather()'s intended trail is to go straight until it reaches the perimeter of the scale
	 * It will then turn right 90 degrees and go across the field until parallel to our scale side
	 * When parallel to the correct scale side, it will turn left and move forward and then "place" the cube
	 * 
	 * 
	 * addParallel is placed in relative position to where it is in Pos1_ScaleCloser
	 * All "placing" commands i.e. Cubesol & PistonElev are placed and formatted relative to Pos1_ScaleCloser
	 * 
	 * Side Note: may want to implement the command group FullLiftAuton.java may save time/be useful (if tested, obviously)
	 * 
	 * -Rudo
	 */

	public Pos1_ScaleFarther() {
		addSequential(new CubeClampSolAuton(Value.kReverse));
		addSequential(new DriveStraight(222)); //18.5 feet <POSSIBLY TOO SHORT>
		addSequential(new TurnRight(55)); //65 equals 90 for some reason... idk
		//addParallel(new CubeDartCommandAuton(true, .93)); //may need to be moved
		addSequential(new DriveStraight(216)); //18 feet <POSSIBLY TOO FAR>
		//addSequential(new ChangePistonElevAuton(Value.kReverse)); //may need to be moved
		addSequential(new TurnLeft(55));
		addSequential(new DriveStraight(24)); //possible too short depends on how far we go before turn left
		addSequential(new CubeClampSolAuton(Value.kForward)); //may need to be moved

	}
}
