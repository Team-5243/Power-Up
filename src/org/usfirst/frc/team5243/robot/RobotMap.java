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
	
	public static final int clampCubeSolF = 7; //Placeholder value	//Red and Yellow
	public static final int clampCubeSolR = 6; //Placeholder value
	
	public static final int flipCubeSolF = 3; //Placeholder value 	//Blue and Green
	public static final int flipCubeSolR = 2; //Placeholder value
	
	public static final int cubeCompressor = 0;

	public static final int leftBelt = 1; //Placeholder value
	public static final int rightBelt = 2; //Placeholder value
	
	public static final int leftPotentiometer = 1;
	public static final int rightPotentiometer = 0;

}
