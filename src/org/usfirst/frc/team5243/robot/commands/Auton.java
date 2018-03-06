package org.usfirst.frc.team5243.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auton extends CommandGroup {

    public Auton() {
        //addSequential(new MoveForward(10));
    	addSequential(new Turn(90));
    }
}
