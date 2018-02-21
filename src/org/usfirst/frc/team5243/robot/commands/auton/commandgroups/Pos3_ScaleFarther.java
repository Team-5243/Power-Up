package org.usfirst.frc.team5243.robot.commands.auton.commandgroups;

import org.usfirst.frc.team5243.robot.commands.ChangeSolenoid;
import org.usfirst.frc.team5243.robot.commands.ClimbCommandAuton;
import org.usfirst.frc.team5243.robot.commands.CubeCommand;
import org.usfirst.frc.team5243.robot.commands.auton.DriveStraight;
import org.usfirst.frc.team5243.robot.commands.auton.TurnLeft;
import org.usfirst.frc.team5243.robot.commands.auton.TurnRight;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Pos3_ScaleFarther extends CommandGroup {

    public Pos3_ScaleFarther() {
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
    	addSequential(new ChangeSolenoid(Value.kForward));
    	addSequential(new DriveStraight(5));
    	addSequential(new TurnLeft(90));
    	addSequential(new DriveStraight(6));
    	addSequential(new TurnRight(90));
    	addSequential(new DriveStraight(.5));
    	addSequential(new ClimbCommandAuton(true, 1));
    	addSequential(new CubeCommand(true));
    	addSequential(new ChangeSolenoid(Value.kReverse));
    }
}
