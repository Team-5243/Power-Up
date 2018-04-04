package org.usfirst.frc.team5243.robot.commands.auton.commandgroups;

import org.usfirst.frc.team5243.robot.commands.ChangeCubeSolAuton;
import org.usfirst.frc.team5243.robot.commands.ClimbCommandAuton;
import org.usfirst.frc.team5243.robot.commands.CubeDartCommandAuton;
import org.usfirst.frc.team5243.robot.commands.auton.DriveStraight;
import org.usfirst.frc.team5243.robot.commands.auton.TurnRight;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Pos1_SwitchCloser extends CommandGroup {

    public Pos1_SwitchCloser() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	addSequential(new ChangeCubeSolAuton(Value.kReverse));
    	//addParallel(new CubeDartCommandAuton(true, .93));
    	addSequential(new DriveStraight(147)); //135
    	addSequential(new ClimbCommandAuton(true, .5));
    	addSequential(new TurnRight(55)); //65
    	addSequential(new DriveStraight(24)); //12     	
    	addSequential(new ChangeCubeSolAuton(Value.kForward));
    }

}
