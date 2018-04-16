package org.usfirst.frc.team5243.robot.commands.auton.commandgroups;

import org.usfirst.frc.team5243.robot.commands.CubeClampSolAuton;
import org.usfirst.frc.team5243.robot.commands.ClimbCommandAuton;
import org.usfirst.frc.team5243.robot.commands.auton.DriveBack;
import org.usfirst.frc.team5243.robot.commands.auton.DriveStraight;
import org.usfirst.frc.team5243.robot.commands.auton.TurnRight;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Pos1_ScaleCloser_Wall extends CommandGroup {

    public Pos1_ScaleCloser_Wall() {
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
    	//addSequential(new ChangeCubeSolAuton(Value.kReverse));
    	//addParallel(new CubeDartCommandAuton(true, .93));
    	addSequential(new DriveStraight(278));
    	addSequential(new TurnRight(55));
    	addSequential(new DriveBack());
    	addSequential(new ClimbCommandAuton(true, 1));
    	addSequential(new DriveStraight(18));
    	addSequential(new CubeClampSolAuton(Value.kForward));
    	
    }
}
