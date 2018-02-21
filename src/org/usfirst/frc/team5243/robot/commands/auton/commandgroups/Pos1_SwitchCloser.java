package org.usfirst.frc.team5243.robot.commands.auton.commandgroups;

import org.usfirst.frc.team5243.robot.commands.ChangeSolenoid;
import org.usfirst.frc.team5243.robot.commands.ClimbCommandAuton;
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
    	//addSequential(new ChangeSolenoid(Value.kForward));
    	addSequential(new DriveStraight(150));
    	addSequential(new TurnRight(90));
    	addSequential(new ClimbCommandAuton(true, .5));
    	addSequential(new DriveStraight(12)); 
    	//addSequential(new CubeCommand(true));    	
    	addSequential(new ChangeSolenoid(Value.kReverse));
    }

}
