package org.usfirst.frc.team5243.robot.commands.auton.commandgroups;

import org.usfirst.frc.team5243.robot.commands.CubeClampSolAuton;
import org.usfirst.frc.team5243.robot.commands.CubeFlipSolAuton;
import org.usfirst.frc.team5243.robot.commands.ClimbCommandAuton;
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
    	addSequential(new CubeClampSolAuton(Value.kReverse)); //clamps the cube
    	addSequential(new DriveStraight(326));
    	addSequential(new CubeFlipSolAuton(Value.kForward)); //raises the cube mech upright
    	addSequential(new ClimbCommandAuton(true, 1));
    	addSequential(new TurnRight(55));
    	addSequential(new DriveStraight(6));
    	//addSequential(new CubeFlipSolAuton(Value.kReverse)); //lowers the cube mech
    	addSequential(new CubeClampSolAuton(Value.kForward)); //releases the cube
    	//addSequential(new CubeFlipSolAuton(Value.kForward)); //raises the cube mech
    	//cube lift command
    }
}
