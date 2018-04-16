package org.usfirst.frc.team5243.robot.commands.auton.commandgroups;

import org.usfirst.frc.team5243.robot.commands.CubeClampSolAuton;
import org.usfirst.frc.team5243.robot.commands.ClimbCommandAuton;
import org.usfirst.frc.team5243.robot.commands.auton.DriveStraight;
import org.usfirst.frc.team5243.robot.commands.auton.TurnLeft;
import org.usfirst.frc.team5243.robot.commands.auton.TurnRight;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Pos2_SwitchLeft extends CommandGroup {

    public Pos2_SwitchLeft() {
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
    	//addSequential(new ChangeSolenoid(Value.kForward));
    	//addParallel(new CubeDartCommandAuton(true, .93));
    	addSequential(new DriveStraight(36));
    	addSequential(new TurnLeft(45));
    	addSequential(new DriveStraight(72));
    	addSequential(new ClimbCommandAuton(true, .5));
    	addSequential(new TurnRight(35));
    	addSequential(new DriveStraight(34));
    	addSequential(new CubeClampSolAuton(Value.kForward));
    	
    	
    }
}
