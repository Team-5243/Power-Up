/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5243.robot;


/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */

public class RobotMap {

	public static final int frontLeft = 6;
	public static final int frontRight = 5;
	public static final int backLeft = 3;
	public static final int backRight = 2;
	
	public static final int leftClimb = 4;
	public static final int rightClimb = 7;
	
	public static final int cubeSolenoidCubeF = 0;
	public static final int cubeSolenoidCubeR = 1;
	
	public static final int cubeSolenoidElevF = 0; //TODO: Placement values
	public static final int cubeSolenoidElevR = 1;
	
	public static final int cubeCompressor = 0;
	
	public static final int cubePotentiometer = 2;
	public static final int cubeActuator = 1;
	
	public static final int leftPotentiometer = 1;
	public static final int rightPotentiometer = 0;

}
