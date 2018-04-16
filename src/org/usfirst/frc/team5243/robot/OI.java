/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package org.usfirst.frc.team5243.robot;


import org.usfirst.frc.team5243.robot.commands.ClimbCommandTeleop;
import org.usfirst.frc.team5243.robot.commands.CubeClampToggle;
import org.usfirst.frc.team5243.robot.commands.CubeFlipToggle;
import org.usfirst.frc.team5243.robot.commands.CubeIntakeCommand;
import org.usfirst.frc.team5243.robot.commands.CubeReleaseCommand;

//import org.usfirst.frc.team5243.robot.commands.ClimbCommand;
//import org.usfirst.frc.team5243.robot.commands.CubeCommand;
//import org.usfirst.frc.team5243.robot.commands.CubeToggle;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	Joystick rightstick;
	Joystick leftstick;
	
	Button lift;
	Button lower;
	
	Button cubeClampSol;
	Button cubeFlipSol;
	
	Button cubeIntake;
	Button cubeRelease;
	
		// Button switchToPlayback;
	
	/**
	 * Initializes the joysticks and buttons. Assigns buttons to commands.
	 */
	public void init() {
		leftstick = new Joystick(0);
		rightstick = new Joystick(1);
		//piston = new JoystickButton(leftstick, 4);
		//buttons assocated with potentiometers for the dart actuators used for extending the arm and pushing the cube mechanism
		lift = new JoystickButton(rightstick, 5);
		lower = new JoystickButton(rightstick, 3);
		
		cubeClampSol = new JoystickButton(rightstick, 1);
		cubeFlipSol = new JoystickButton(rightstick, 2);
		
		cubeIntake = new JoystickButton(rightstick, 6);
		cubeRelease = new JoystickButton(rightstick, 4);
		
		lift.whileHeld(new ClimbCommandTeleop(true));
		lower.whileHeld(new ClimbCommandTeleop(false));
		
		cubeClampSol.whenPressed(new CubeClampToggle());
		cubeFlipSol.whenPressed(new CubeFlipToggle());
		
		cubeIntake.whileHeld(new CubeIntakeCommand());
		cubeRelease.whileHeld(new CubeReleaseCommand());
	}
	
	/**
	 * Gets the left joystick
	 * @return the left joystick
	 */
	public Joystick getLeftStick() {
		return leftstick;
	}
	
	/**
	 * Gets the right joystick
	 * @return the rightstick
	 */
	public Joystick getRightStick() {
		return rightstick;
	}
}