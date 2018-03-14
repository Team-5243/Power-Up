package org.usfirst.frc.team5243.robot.commands.auton.commandgroups;

import org.usfirst.frc.team5243.robot.commands.ChangeCubeSolAuton;
import org.usfirst.frc.team5243.robot.commands.ChangePistonElevAuton;
import org.usfirst.frc.team5243.robot.commands.ClimbCommandAuton;
import org.usfirst.frc.team5243.robot.commands.CubeDartCommandAuton;
import org.usfirst.frc.team5243.robot.commands.auton.DriveStraight;
import org.usfirst.frc.team5243.robot.commands.auton.TurnRight;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Pos1_ScaleCloser extends CommandGroup {

    public Pos1_ScaleCloser() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	addSequential(new ChangeCubeSolAuton(Value.kReverse));
    	addParallel(new CubeDartCommandAuton(true, .93));
    	addSequential(new DriveStraight(278));
    	addSequential(new ClimbCommandAuton(true, 1));
    	//addSequential(new ChangePistonElevAuton(Value.kReverse));
    	addSequential(new TurnRight(55));
    	addSequential(new DriveStraight(6));
    	//addSequential(new CubeDartCommandAuton(true, 4.3));
    	addSequential(new ChangeCubeSolAuton(Value.kForward));
    	//addSequential(new CubeDartCommandAuton(false, .8));
    	//cube lift command
    }
}
