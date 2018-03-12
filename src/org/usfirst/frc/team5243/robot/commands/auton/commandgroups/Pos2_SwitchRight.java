package org.usfirst.frc.team5243.robot.commands.auton.commandgroups;

import org.usfirst.frc.team5243.robot.commands.ChangeCubeSolAuton;
import org.usfirst.frc.team5243.robot.commands.ClimbCommandAuton;
import org.usfirst.frc.team5243.robot.commands.CubeDartCommandAuton;
import org.usfirst.frc.team5243.robot.commands.auton.DriveStraight;
import org.usfirst.frc.team5243.robot.commands.auton.TurnLeft;
import org.usfirst.frc.team5243.robot.commands.auton.TurnRight;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Pos2_SwitchRight extends CommandGroup {

    public Pos2_SwitchRight() {
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
    	addParallel(new CubeDartCommandAuton(true, .93));
    	addSequential(new DriveStraight(6));
    	addSequential(new TurnRight(45));
    	addSequential(new DriveStraight(68));
    	addSequential(new TurnLeft(45));
    	addSequential(new ClimbCommandAuton(true, .5));
    	addSequential(new DriveStraight(40));
    	addSequential(new ChangeCubeSolAuton(Value.kForward));
    }
}
